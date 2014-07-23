package com.cnpat.pdsc.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import cn.com.cnpat.cprs.rmi.bean.CurrentBean;

import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.entry.CommonEntry;

public class UpdateDetailService {

	private HibernateTemplate ht;

	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg req) {
		int datatype = req.getDataType();
		CurrentBean cb = new CurrentBean();
		switch (datatype) {

		}

		UpdateDetailOutMsg res = new UpdateDetailOutMsg();
		List<CommonEntry> list = new LinkedList<CommonEntry>();
		
		res.setResList();

		return null;
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
