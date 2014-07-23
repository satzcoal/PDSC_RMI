package com.cnpat.pdsc.rmi.impl;

import java.rmi.RemoteException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cnpat.pdsc.common.Consts;
import com.cnpat.pdsc.rmi.IndexBookService;
import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;
import com.cnpat.pdsc.service.BookService;

public class IndexBookServiceImpl implements IndexBookService {

	private static final Logger logger = LogManager
			.getLogger(IndexBookServiceImpl.class);

	private BookService service;

	public BookDataOutMsg bookData(BookDataInMsg req) throws RemoteException {

		logger.debug("Book Data Start: " + req.toString());
		BookDataOutMsg res = new BookDataOutMsg();

		try {
			res = service.bookData(req, Consts.SERVICE_TYPE_RMI);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		logger.debug("Book Data End: " + res.toString());
		return res;
	}

	public BookService getService() {
		return service;
	}

	public void setService(BookService service) {
		this.service = service;
	}

}
