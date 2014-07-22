package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;

public class CommonMsg implements Serializable {

	private static final long serialVersionUID = -3549365477276624993L;

	private int resStatus;
	private String errMsg;
	private int globalSeq;

	public int getGlobalSeq() {
		return globalSeq;
	}

	public void setGlobalSeq(int globalSeq) {
		this.globalSeq = globalSeq;
	}

	public int getResStatus() {
		return resStatus;
	}

	public void setResStatus(int resStatus) {
		this.resStatus = resStatus;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
