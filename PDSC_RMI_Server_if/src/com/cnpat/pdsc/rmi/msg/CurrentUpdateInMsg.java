package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.List;

public class CurrentUpdateInMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -8019575688113220515L;

	private List<Integer> dataTypeList;

	public List<Integer> getDataTypeList() {
		return dataTypeList;
	}

	public void setDataTypeList(List<Integer> dataTypeList) {
		this.dataTypeList = dataTypeList;
	}

	@Override
	public String toString() {
		return "CurrentUpdateInMsg [dataTypeList=" + listToString(dataTypeList)
				+ ", resStatus=" + resStatus + ", errMsg=" + errMsg + "]";
	}

}
