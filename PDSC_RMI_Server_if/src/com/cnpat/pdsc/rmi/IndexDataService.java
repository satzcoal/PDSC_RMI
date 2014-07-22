package com.cnpat.pdsc.rmi;

import java.rmi.Remote;

import com.cnpat.pdsc.rmi.msg.CurrentUpdateInMsg;
import com.cnpat.pdsc.rmi.msg.CurrentUpdateOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryOutMsg;

/**
 * �������ݷ���
 * 
 * @author Lee
 * 
 */
public interface IndexDataService extends Remote {

	/**
	 * ȡ������Seq
	 */
	public CurrentUpdateOutMsg getCurrentUpdate(CurrentUpdateInMsg msg);

	/**
	 * ȡ�ø���ժҪ
	 */
	public UpdateSummaryOutMsg getUpdateSummary(UpdateSummaryInMsg msg);

	/**
	 * ȡ�ø�����ϸ
	 */
	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg msg);
}
