package com.cnpat.pdsc.rmi.test;

import java.rmi.RemoteException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnpat.pdsc.rmi.IndexDataService;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryOutMsg;

public class IndexDataServiceTest {

	private IndexDataService indexDataService;

	public static void main(String... args) throws RemoteException {
		testGetUpdateSummary();
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
