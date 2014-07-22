package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.List;

public class BookDataInMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -621027206850640238L;

	private int bookRecordID;
	private List<BookInfo> bookInfoList;

	public int getBookRecordID() {
		return bookRecordID;
	}

	public void setBookRecordID(int bookRecordID) {
		this.bookRecordID = bookRecordID;
	}

	public List<BookInfo> getBookInfoList() {
		return bookInfoList;
	}

	public void setBookInfoList(List<BookInfo> bookInfoList) {
		this.bookInfoList = bookInfoList;
	}
}
