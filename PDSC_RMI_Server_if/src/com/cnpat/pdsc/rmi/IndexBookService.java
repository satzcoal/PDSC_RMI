package com.cnpat.pdsc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;

/**
 * 索引订阅服务
 * 
 * @author Lee
 * 
 */
public interface IndexBookService extends Remote {
	/**
	 * 订阅数据
	 * 
	 * @param msg
	 * @return
	 */
	public BookDataOutMsg bookData(BookDataInMsg msg) throws RemoteException;

}
