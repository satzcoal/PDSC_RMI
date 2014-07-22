package com.cnpat.pdsc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;

/**
 * �������ķ���
 * 
 * @author Lee
 * 
 */
public interface IndexBookService extends Remote {
	/**
	 * ��������
	 * 
	 * @param msg
	 * @return
	 */
	public BookDataOutMsg bookData(BookDataInMsg msg) throws RemoteException;

}
