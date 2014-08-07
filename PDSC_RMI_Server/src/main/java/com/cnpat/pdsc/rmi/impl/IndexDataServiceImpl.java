package com.cnpat.pdsc.rmi.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cnpat.pdsc.rmi.IndexDataService;
import com.cnpat.pdsc.rmi.msg.CurrentUpdateInMsg;
import com.cnpat.pdsc.rmi.msg.CurrentUpdateOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateSummaryOutMsg;
import com.cnpat.pdsc.service.UpdateDetailService;
import com.cnpat.pdsc.service.UpdateSummaryService;

public class IndexDataServiceImpl implements IndexDataService {

	private static final Logger logger = LogManager
			.getLogger(IndexDataServiceImpl.class);
	private UpdateSummaryService summaryService;
	private UpdateDetailService detailService;

	public CurrentUpdateOutMsg getCurrentUpdate(CurrentUpdateInMsg req) {

		CurrentUpdateOutMsg res = new CurrentUpdateOutMsg();
		if (req == null || req.getDataTypeList() == null
				|| req.getDataTypeList().size() == 0) {
			res.setResStatus(1);
			res.setErrMsg("输入参数不合法！");
			return res;
		}

		try {
			res = summaryService.getCurrentUpdate(req);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		return res;
	}

	public UpdateSummaryOutMsg getUpdateSummary(UpdateSummaryInMsg req) {
		UpdateSummaryOutMsg res = new UpdateSummaryOutMsg();

		if (req == null) {
			res.setResStatus(1);
			res.setErrMsg("输入参数不合法！");
			return res;
		}

		try {
			res = summaryService.getUpdateSummary(req);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		return res;
	}

	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg req) {
		UpdateDetailOutMsg res = new UpdateDetailOutMsg();

		if (req == null || req.getIdList() == null
				|| req.getIdList().size() == 0) {
			res.setResStatus(1);
			res.setErrMsg("输入参数不合法！");
			return res;
		}

		try {
			res = detailService.getUpdateDetail(req);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		return res;
	}

	public UpdateSummaryService getSummaryService() {
		return summaryService;
	}

	public void setSummaryService(UpdateSummaryService service) {
		this.summaryService = service;
	}

	public UpdateDetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(UpdateDetailService detailService) {
		this.detailService = detailService;
	}
}
