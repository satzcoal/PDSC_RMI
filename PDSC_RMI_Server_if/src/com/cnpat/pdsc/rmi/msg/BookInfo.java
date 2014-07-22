package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;

public class BookInfo implements Serializable {

	private static final long serialVersionUID = -4358997847750343999L;

	private int bookDataID;
	private int opType;

	public int getBookDataID() {
		return bookDataID;
	}

	public void setBookDataID(int bookDataID) {
		this.bookDataID = bookDataID;
	}

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}
}
