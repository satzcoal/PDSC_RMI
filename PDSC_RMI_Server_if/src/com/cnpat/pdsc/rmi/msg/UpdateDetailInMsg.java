package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.List;

public class UpdateDetailInMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -1679064041611223667L;

	private int dataType;
	private List<String> idList;

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

	@Override
	public String toString() {
		return "UpdateDetailInMsg [dataType=" + dataType + ", idList="
				+ listToString(idList) + ", resStatus=" + resStatus
				+ ", errMsg=" + errMsg + "]";
	}

}
