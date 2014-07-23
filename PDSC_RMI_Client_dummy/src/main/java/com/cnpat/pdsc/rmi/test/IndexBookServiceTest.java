package com.cnpat.pdsc.rmi.test;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnpat.pdsc.rmi.IndexBookService;
import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;
import com.cnpat.pdsc.rmi.msg.BookInfo;

public class IndexBookServiceTest {

	private IndexBookService indexBookService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context.xml");
		IndexBookServiceTest test = (IndexBookServiceTest) ctx.getBean("testbook");
		try {
			BookDataInMsg inmsg = new BookDataInMsg();
			inmsg.setUrl("localhost");
			List<BookInfo> list = new LinkedList<BookInfo>();
			BookInfo info = new BookInfo();
			info.setBookDataID(1);
			info.setOpType(1);
			list.add(info);
			info = new BookInfo();
			info.setBookDataID(2);
			info.setOpType(2);
			list.add(info);
			inmsg.setBookInfoList(list);
			BookDataOutMsg outmsg = test.indexBookService.bookData(inmsg);

			for (int ins : outmsg.getCurrentSeqMap().keySet()) {
				System.out.println("DataContext: " + ins + " CurrentSeq: "
						+ outmsg.getCurrentSeqMap().get(ins));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext) ctx).close();
	}

	public IndexBookService getIndexBookService() {
		return indexBookService;
	}

	public void setIndexBookService(IndexBookService indexBookService) {
		this.indexBookService = indexBookService;
	}

}
