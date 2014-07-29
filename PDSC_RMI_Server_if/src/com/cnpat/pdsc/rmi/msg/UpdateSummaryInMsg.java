package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;

public class UpdateSummaryInMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -3262835157910635500L;

	private int dataType;
	private int seq;

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "UpdateSummaryInMsg [dataType=" + dataType + ", seq=" + seq
				+ ", resStatus=" + resStatus + ", errMsg=" + errMsg + "]";
	}

}
