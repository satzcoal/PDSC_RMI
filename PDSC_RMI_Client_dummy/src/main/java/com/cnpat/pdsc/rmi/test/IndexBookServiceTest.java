package com.cnpat.pdsc.rmi.test;

import java.rmi.RemoteException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnpat.pdsc.rmi.IndexBookService;

public class IndexBookServiceTest {

	private IndexBookService indexBookService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context.xml");
		IndexBookServiceTest test = (IndexBookServiceTest) ctx.getBean("test");
		try {
			test.indexBookService.bookData(null);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext)ctx).close();
	}

	public IndexBookService getIndexBookService() {
		return indexBookService;
	}

	public void setIndexBookService(IndexBookService indexBookService) {
		this.indexBookService = indexBookService;
	}

}
