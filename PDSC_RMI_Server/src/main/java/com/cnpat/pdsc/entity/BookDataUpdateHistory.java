package com.cnpat.pdsc.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblBookDataUpdateHistory generated by hbm2java
 */
@Entity
@Table(name = "BookDataUpdateHistory", catalog = "PDSC_Management_DB")
public class BookDataUpdateHistory implements java.io.Serializable {

	private static final long serialVersionUID = -7612978298108085996L;
	
	private long bookId;
	private long globalSeq;
	private boolean rollbackFlag;
	private Date updateTime;
	private int status;

	public BookDataUpdateHistory() {
	}

	public BookDataUpdateHistory(long bookId, long globalSeq,
			boolean rollbackFlag, Date updateTime, int status) {
		this.bookId = bookId;
		this.globalSeq = globalSeq;
		this.rollbackFlag = rollbackFlag;
		this.updateTime = updateTime;
		this.status = status;
	}

	@Id
	@Column(name = "BookID", unique = true, nullable = false)
	public long getBookId() {
		return this.bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	@Column(name = "GlobalSeq", nullable = false)
	public long getGlobalSeq() {
		return this.globalSeq;
	}

	public void setGlobalSeq(long globalSeq) {
		this.globalSeq = globalSeq;
	}

	@Column(name = "RollbackFlag", nullable = false)
	public boolean isRollbackFlag() {
		return this.rollbackFlag;
	}

	public void setRollbackFlag(boolean rollbackFlag) {
		this.rollbackFlag = rollbackFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdateTime", nullable = false, length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "Status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
