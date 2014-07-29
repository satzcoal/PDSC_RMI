package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.Map;

public class CurrentUpdateOutMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -78816524505438222L;

	private Map<Integer, Integer> currentSeqMap;

	public Map<Integer, Integer> getCurrentSeqMap() {
		return currentSeqMap;
	}

	public void setCurrentSeqMap(Map<Integer, Integer> currentSeqMap) {
		this.currentSeqMap = currentSeqMap;
	}

	@Override
	public String toString() {
		return "CurrentUpdateOutMsg [currentSeqMap="
				+ mapToString(currentSeqMap) + ", resStatus=" + resStatus
				+ ", errMsg=" + errMsg + "]";
	}
}
