package com.cnpat.pdsc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblUpdateMain generated by hbm2java
 */
@Entity
@Table(name = "tbl_UpdateMain", catalog = "PDSC_Management_DB")
public class UpdateMain implements java.io.Serializable {

	private static final long serialVersionUID = -4973990127727936484L;

	@Id
	@Column(name = "GlobalSeq", unique = true, nullable = false)
	private int globalSeq;

	@Column(name = "LocalSeq", nullable = false)
	private int localSeq;

	@Column(name = "DataType", nullable = false)
	private int dataType;

	@Column(name = "OpType", nullable = false)
	private int opType;

	@Column(name = "BatchNo", nullable = false, length = 20)
	private String batchNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateTime", nullable = false, length = 19)
	private Date createTime;

	@Column(name = "RollbackFlag", nullable = false)
	private boolean rollbackFlag;

	@Column(name = "RollbackSeq")
	private Long rollbackSeq;

	@Column(name = "RecordNum", nullable = false)
	private int recordNum;

	public UpdateMain() {
	}

	public int getGlobalSeq() {
		return this.globalSeq;
	}

	public void setGlobalSeq(int globalSeq) {
		this.globalSeq = globalSeq;
	}

	public int getLocalSeq() {
		return this.localSeq;
	}

	public void setLocalSeq(int localSeq) {
		this.localSeq = localSeq;
	}

	public int getDataType() {
		return this.dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public int getOpType() {
		return this.opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isRollbackFlag() {
		return this.rollbackFlag;
	}

	public void setRollbackFlag(boolean rollbackFlag) {
		this.rollbackFlag = rollbackFlag;
	}

	public Long getRollbackSeq() {
		return this.rollbackSeq;
	}

	public void setRollbackSeq(Long rollbackSeq) {
		this.rollbackSeq = rollbackSeq;
	}

	public int getRecordNum() {
		return this.recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

}
