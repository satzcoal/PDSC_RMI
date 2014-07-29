package com.cnpat.pdsc.rmi.msg;

import java.io.Serializable;
import java.util.List;

public class BookDataInMsg extends CommonMsg implements Serializable {

	private static final long serialVersionUID = -621027206850640238L;

	private long bookID;
	private List<BookInfo> bookInfoList;
	private String url;

	public final long getBookID() {
		return bookID;
	}

	public final void setBookID(long bookID) {
		this.bookID = bookID;
	}

	public List<BookInfo> getBookInfoList() {
		return bookInfoList;
	}

	public void setBookInfoList(List<BookInfo> bookInfoList) {
		this.bookInfoList = bookInfoList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BookDataInMsg [bookID=" + bookID + ", bookInfoList="
				+ listToString(bookInfoList) + ", url=" + url + ", resStatus="
				+ resStatus + ", errMsg=" + errMsg + "]";
	}
}
