package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.List;

import com.cnpat.pdsc.rmi.msg.entry.CommonEntry;

public class UpdateDetailOutMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = 4868151067346448900L;

	private List<CommonEntry> resList;

	public List<CommonEntry> getResList() {
		return resList;
	}

	public void setResList(List<CommonEntry> resList) {
		this.resList = resList;
	}
}
