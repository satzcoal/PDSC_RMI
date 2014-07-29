package com.cnpat.pdsc.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.cnpat.pdsc.common.Consts;
import com.cnpat.pdsc.entity.CoreDataInfo;
import com.cnpat.pdsc.entity.UpdateEntity;
import com.cnpat.pdsc.entity.UpdateMain;
import com.cnpat.pdsc.rmi.msg.CurrentUpdateInMsg;
import com.cnpat.pdsc.rmi.msg.CurrentUpdateOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryOutMsg;

@Configuration
@EnableAspectJAutoProxy
public class UpdateSummaryService {

	private HibernateTemplate ht;

	public CurrentUpdateOutMsg getCurrentUpdate(CurrentUpdateInMsg req) {

		Map<Integer, Integer> seqMap = new HashMap<Integer, Integer>();
		for (int ins : req.getDataTypeList()) {
			// DAO
			CoreDataInfo cdi = ht.get(CoreDataInfo.class, ins);

			seqMap.put(ins, cdi.getCurrentSeq());
		}

		CurrentUpdateOutMsg res = new CurrentUpdateOutMsg();
		res.setCurrentSeqMap(seqMap);

		return res;
	}

	public UpdateSummaryOutMsg getUpdateSummary(UpdateSummaryInMsg req) {

		CoreDataInfo cdi = ht.get(CoreDataInfo.class, req.getDataType());
		String entityName = cdi.getDetailEntityName();

		List<?> tmp = ht.find(
				"from UpdateMain where localSeq = ? and dataType = ?",
				req.getSeq(), req.getDataType());
		if (tmp == null || tmp.size() == 0) {
			// TODO
		}
		UpdateMain main = (UpdateMain) tmp.get(0);

		List<?> list = ht.find("from " + entityName + " where seq = ?",
				req.getSeq());

		UpdateSummaryOutMsg res = new UpdateSummaryOutMsg();
		res.setBatchNo(main.getBatchNo());
		res.setCount(main.getRecordNum());
		res.setCreateTime(main.getCreateTime());
		res.setIdList(new LinkedList<String>());
		// TODO
		res.setOpType(Consts.UPDATE_OPTYPE_ADD);
		res.setSeq(req.getSeq());

		for (Object ins : list) {
			UpdateEntity ue = (UpdateEntity) ins;
			res.getIdList().add(ue.getUpdateId());
		}

		return res;
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
