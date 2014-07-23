package com.cnpat.pdsc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.cnpat.pdsc.rmi.msg.CurrentUpdateInMsg;
import com.cnpat.pdsc.rmi.msg.CurrentUpdateOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryOutMsg;

/**
 * 索引数据服务
 * 
 * @author Lee
 * 
 */
public interface IndexDataService extends Remote {

	/**
	 * 取得最新Seq
	 */
	public CurrentUpdateOutMsg getCurrentUpdate(CurrentUpdateInMsg msg)
			throws RemoteException;

	/**
	 * 取得更新摘要
	 */
	public UpdateSummaryOutMsg getUpdateSummary(UpdateSummaryInMsg msg)
			throws RemoteException;

	/**
	 * 取得更新明细
	 */
	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg msg)
			throws RemoteException;
}
