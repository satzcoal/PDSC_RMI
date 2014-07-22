package com.cnpat.pdsc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblBookDataContent generated by hbm2java
 */
@Entity
@Table(name = "tbl_BookDataContent", catalog = "PDSC_Management_DB")
public class TblBookDataContent implements java.io.Serializable {

	private static final long serialVersionUID = -1001872973458953512L;

	@Id
	private long id;
	private int dataType;

	@Column(name = "ID", nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDataType() {
		return this.dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
}
