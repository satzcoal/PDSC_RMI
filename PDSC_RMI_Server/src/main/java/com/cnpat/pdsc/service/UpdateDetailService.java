package com.cnpat.pdsc.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.cnpat.pdsc.common.Consts;
import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.entry.CommonEntry;

public class UpdateDetailService {

	private HibernateTemplate ht;

	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg req) {

		int datatype = req.getDataType();
		
		switch (datatype) {
		case Consts.UPDATE_DATATYPE_CURRENT:
			makeCurrentBeans(req.getIdList());
			break;
		case Consts.UPDATE_DATATYPE_GRANT:
			makeGrantBeans(req.getIdList());
			break;
		case Consts.UPDATE_DATATYPE_PUBLIC:
			makePublicBeans(req.getIdList());
			break;
		default:
			break;
		}

		UpdateDetailOutMsg res = new UpdateDetailOutMsg();
		List<CommonEntry> list = new LinkedList<CommonEntry>();

		res.setResList(list);

		return res;
	}

	private void makePublicBeans(List<String> idList) {

	}

	private void makeGrantBeans(List<String> idList) {

	}

	private void makeCurrentBeans(List<String> idList) {

	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
