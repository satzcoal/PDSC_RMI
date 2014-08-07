package com.cnpat.pdsc.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

	private static final Logger logger = LogManager
			.getLogger(UpdateSummaryService.class);

	public CurrentUpdateOutMsg getCurrentUpdate(CurrentUpdateInMsg req) {

		Map<Integer, Integer> seqMap = new HashMap<Integer, Integer>();
		for (int ins : req.getDataTypeList()) {
			// DAO
			CoreDataInfo cdi = ht.get(CoreDataInfo.class, ins);
			if (cdi == null) {
				logger.error("DATATYPE: " + ins + " NOT FOUND");
				continue;
			}
			seqMap.put(ins, cdi.getCurrentSeq());
		}

		CurrentUpdateOutMsg res = new CurrentUpdateOutMsg();
		res.setCurrentSeqMap(seqMap);

		return res;
	}

	public UpdateSummaryOutMsg getUpdateSummary(UpdateSummaryInMsg req) {

		UpdateSummaryOutMsg res = new UpdateSummaryOutMsg();
		CoreDataInfo cdi = ht.get(CoreDataInfo.class, req.getDataType());
		if (cdi == null) {
			logger.error("DATATYPE: " + req.getDataType() + " NOT FOUND!");
			res.setResStatus(1);
			return res;
		}
		String entityName = cdi.getDetailEntityName();

		List<?> tmp = ht.find(
				"from UpdateMain where localSeq = ? and dataType = ?",
				req.getSeq(), req.getDataType());
		if (tmp == null || tmp.size() == 0) {
			logger.error("DATATYPE: " + req.getDataType());
			logger.error("LOCAL SEQ: " + req.getSeq());
			res.setErrMsg("SEQ DATATYPE ERROR!");
			res.setResStatus(1);
			return res;
		}
		UpdateMain main = (UpdateMain) tmp.get(0);

		List<?> list = ht.find("from " + entityName + " where seq = ?",
				req.getSeq());

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
