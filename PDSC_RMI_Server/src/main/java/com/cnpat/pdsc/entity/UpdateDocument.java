package com.cnpat.pdsc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TblUpdateDocument generated by hbm2java
 */
@Entity(name = "UpdateDocument")
@Table(name = "UpdateDocument", catalog = "PDSC_Management_DB")
public class UpdateDocument implements java.io.Serializable, UpdateEntity {

	private static final long serialVersionUID = 1317724292842745893L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "Seq", unique = true, nullable = false)
	private int seq;

	@ManyToOne
	@JoinColumn(name = "GlobalSeq")
	private UpdateMain updateMain;

	@Column(name = "UpdateID", nullable = false, length = 20)
	private String updateId;

	public UpdateDocument() {
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUpdateId() {
		return this.updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public UpdateMain getUpdateMain() {
		return updateMain;
	}

	public void setUpdateMain(UpdateMain updateMain) {
		this.updateMain = updateMain;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
