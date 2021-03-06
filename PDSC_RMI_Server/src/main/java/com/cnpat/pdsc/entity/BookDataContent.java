package com.cnpat.pdsc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TblBookDataContent generated by hbm2java
 */
@Entity
@Table(name = "BookDataContent", catalog = "PDSC_Management_DB")
public class BookDataContent implements java.io.Serializable {

	private static final long serialVersionUID = -1001872973458953512L;

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private long id;

	@Column(name = "DataType", nullable = false)
	private int dataType;

	public int getDataType() {
		return this.dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

}
