package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UpdateSummaryOutMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -7332543841931059740L;

	private String batchNo;
	private int count;
	private List<String> idList;
	private int seq;
	private int opType;
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
}
