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
		logger.debug("Get Current Update Start: " + req.toString());
		CurrentUpdateOutMsg res = new CurrentUpdateOutMsg();

		try {
			res = summaryService.getCurrentUpdate(req);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		logger.debug("Get Current Update End: " + res.toString());
		return res;
	}

	public UpdateSummaryOutMsg getUpdateSummary(UpdateSummaryInMsg req) {
		logger.debug("Get Update Summary Start: " + req.toString());
		UpdateSummaryOutMsg res = new UpdateSummaryOutMsg();

		try {
			res = summaryService.getUpdateSummary(req);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		logger.debug("Get Update Summary End: " + res.toString());
		return res;
	}

	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg req) {
		logger.debug("Get Update Detail Start: " + req.toString());
		UpdateDetailOutMsg res = new UpdateDetailOutMsg();

		try {
			res = detailService.getUpdateDetail(req);
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			ex.printStackTrace();
		}

		logger.debug("Get Update Summary End: " + res.toString());
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
