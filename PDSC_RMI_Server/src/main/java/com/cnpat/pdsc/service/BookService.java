package com.cnpat.pdsc.service;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.cnpat.pdsc.entity.TblBookDataContent;

public class BookService {

	private HibernateTemplate ht;

	public void bookData() {
		TblBookDataContent bdc = new TblBookDataContent();
		bdc.setDataType(2);
		bdc.setId(4);
		ht.save(bdc);
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
}
