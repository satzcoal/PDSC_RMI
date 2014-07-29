package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.Map;

public class BookDataOutMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -3458863572132681008L;

	private Map<Integer, Integer> currentSeqMap;

	public Map<Integer, Integer> getCurrentSeqMap() {
		return currentSeqMap;
	}

	public void setCurrentSeqMap(Map<Integer, Integer> currentSeqMap) {
		this.currentSeqMap = currentSeqMap;
	}

	@Override
	public String toString() {
		return "BookDataOutMsg [currentSeqMap=" + mapToString(currentSeqMap)
				+ ", resStatus=" + resStatus + ", errMsg=" + errMsg + "]";
	}

}
