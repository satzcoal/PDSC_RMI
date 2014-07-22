package com.cnpat.pdsc.rmi.impl;

import java.rmi.RemoteException;

import com.cnpat.pdsc.rmi.IndexBookService;
import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;

public class IndexBookServiceImpl implements IndexBookService {

	public BookDataOutMsg bookData(BookDataInMsg msg) throws RemoteException {
		return null;
	}
}
