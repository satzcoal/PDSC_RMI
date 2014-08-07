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

		BookDataOutMsg res = new BookDataOutMsg();

		if (req == null || req.getUrl() == null
				|| req.getBookInfoList() == null) {
			res.setResStatus(1);
			res.setErrMsg("输入参数不合法！");
			return res;
		}

		try {
			res = service.bookData(req, Consts.SERVICE_TYPE_RMI);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		return res;
	}

	public BookService getService() {
		return service;
	}

	public void setService(BookService service) {
		this.service = service;
	}

}
