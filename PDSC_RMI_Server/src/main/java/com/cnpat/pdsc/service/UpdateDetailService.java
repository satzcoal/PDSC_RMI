package com.cnpat.pdsc.service;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;

public class UpdateDetailService {

	private HibernateTemplate ht;

	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg req) {
		int datatype = req.getDataType();
		switch (datatype) {
		case:
			
		}
		return null;
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
