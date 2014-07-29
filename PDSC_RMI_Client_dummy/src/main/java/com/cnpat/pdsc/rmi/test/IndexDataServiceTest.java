package com.cnpat.pdsc.rmi.test;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnpat.pdsc.rmi.IndexDataService;
import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryOutMsg;
import com.cnpat.pdsc.rmi.msg.entry.CommonEntry;

public class IndexDataServiceTest {

	private IndexDataService indexDataService;

	public static void main(String... args) throws RemoteException {
		//testGetUpdateSummary();
		testGetUpdateDetail();
	}

	private static void testGetUpdateDetail() throws RemoteException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context.xml");
		UpdateDetailInMsg msg = new UpdateDetailInMsg();
		msg.setDataType(0);
		List<String> idlist = new LinkedList<String>();
		idlist.add("201210208835");
		msg.setIdList(idlist);
		IndexDataServiceTest s = (IndexDataServiceTest) ctx.getBean("testdata");
		UpdateDetailOutMsg out = s.getIndexDataService().getUpdateDetail(msg);

		for (CommonEntry ins : out.getResList()) {
			System.out.println(ins.getEntryBean());
		}
		((ClassPathXmlApplicationContext) ctx).close();
	}

	public static void testGetUpdateSummary() throws RemoteException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context.xml");
		UpdateSummaryInMsg msg = new UpdateSummaryInMsg();
		IndexDataServiceTest s = (IndexDataServiceTest) ctx.getBean("testdata");
		msg.setDataType(1);
		msg.setSeq(1);
		UpdateSummaryOutMsg out = s.getIndexDataService().getUpdateSummary(msg);

		for (String id : out.getIdList()) {
			System.out.println(id);
		}
		((ClassPathXmlApplicationContext) ctx).close();
	}

	public IndexDataService getIndexDataService() {
		return indexDataService;
	}

	public void setIndexDataService(IndexDataService indexDataService) {
		this.indexDataService = indexDataService;
	}
}
