package com.cnpat.pdsc.rmi.impl;

import java.rmi.RemoteException;

import com.cnpat.pdsc.rmi.IndexBookService;
import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;
import com.cnpat.pdsc.service.BookService;

public class IndexBookServiceImpl implements IndexBookService {

	private BookService service;

	public BookDataOutMsg bookData(BookDataInMsg msg) throws RemoteException {
		try {
			System.out.println("say hello!!");
			service.bookData();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public BookService getService() {
		return service;
	}

	public void setService(BookService service) {
		this.service = service;
	}

}
