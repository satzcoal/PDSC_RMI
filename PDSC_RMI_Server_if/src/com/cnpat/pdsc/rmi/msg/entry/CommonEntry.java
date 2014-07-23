package com.cnpat.pdsc.rmi.msg.entry;

import java.io.Serializable;

public class CommonEntry implements Serializable {

	private static final long serialVersionUID = 1136108520454432367L;
	private String id;
	private Object entryBean;

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final Object getEntryBean() {
		return entryBean;
	}

	public final void setEntryBean(Object entryBean) {
		this.entryBean = entryBean;
	}
}
