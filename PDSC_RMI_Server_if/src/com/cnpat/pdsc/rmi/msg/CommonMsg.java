package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CommonMsg implements Serializable {

	private static final long serialVersionUID = -3549365477276624993L;

	protected int resStatus = 0;
	protected String errMsg;
	protected int globalSeq;

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

	@Override
	public String toString() {
		return "CommonMsg [resStatus=" + resStatus + ", errMsg=" + errMsg
				+ ", globalSeq=" + globalSeq + "]";
	}

	protected String listToString(List<?> list) {
		if (list == null) {
			return null;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			for (Object ins : list) {
				sb.append(ins.toString()).append(",");
			}
			sb.deleteCharAt(sb.length() - 1).append("]");
			return sb.toString();
		}
	}

	protected String mapToString(Map<?, ?> map) {
		if (map == null) {
			return null;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			for (Object ins : map.keySet()) {
				sb.append(ins.toString()).append(":").append(map.get(ins))
						.append(",");
			}
			sb.deleteCharAt(sb.length() - 1).append("]");
			return sb.toString();
		}
	}
}
