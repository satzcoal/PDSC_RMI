package com.cnpat.pdsc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.cnpat.pdsc.common.Consts;
import com.cnpat.pdsc.entity.BookDataContent;
import com.cnpat.pdsc.entity.BookDataInfo;
import com.cnpat.pdsc.entity.BookDataRecord;
import com.cnpat.pdsc.entity.BookDataRecordDetail;
import com.cnpat.pdsc.entity.CoreDataInfo;
import com.cnpat.pdsc.rmi.msg.BookDataInMsg;
import com.cnpat.pdsc.rmi.msg.BookDataOutMsg;
import com.cnpat.pdsc.rmi.msg.BookInfo;

public class BookService {

	private HibernateTemplate ht;

	public BookDataOutMsg bookData(BookDataInMsg req, int serviceType) {

		BookDataRecord record = new BookDataRecord();
		record.setCreateTime(new Date());
		record.setServiceType(serviceType);
		record.setUrl(req.getUrl());

		Set<BookDataRecordDetail> details = new HashSet<BookDataRecordDetail>();

		for (BookInfo ins : req.getBookInfoList()) {
			BookDataRecordDetail tmp = new BookDataRecordDetail();
			tmp.setOpType(ins.getOpType());
			tmp.setDataType(ins.getBookDataID());
			details.add(tmp);
		}

		record.setDetails(details);

		boolean isNew = false;

		// DAO
		BookDataInfo bookInfo = ht.get(BookDataInfo.class, req.getBookID());

		if (bookInfo == null) {
			bookInfo = new BookDataInfo();
			isNew = true;
		}

		this.updateBookInfoByBookRecord(req.getBookID(), bookInfo, record,
				isNew);
		record.setBookIns(bookInfo);

		// DAO
		ht.saveOrUpdate(bookInfo);
		ht.save(record);

		Map<Integer, Integer> seqMap = new HashMap<Integer, Integer>();
		for (BookDataContent ins : bookInfo.getContents()) {
			// DAO
			CoreDataInfo cdi = ht.get(CoreDataInfo.class, ins.getDataType());

			seqMap.put(ins.getDataType(), cdi.getCurrentSeq());
		}

		BookDataOutMsg res = new BookDataOutMsg();
		res.setCurrentSeqMap(seqMap);

		return res;
	}

	private BookDataInfo updateBookInfoByBookRecord(long bookID,
			BookDataInfo bookInfo, BookDataRecord record, boolean isNew) {

		if (isNew) {
			bookInfo.setBookId(bookID);
			bookInfo.setCreateTime(record.getCreateTime());
			bookInfo.setContents(new HashSet<BookDataContent>());
			bookInfo.setServiceType(record.getServiceType());
			bookInfo.setUrl(record.getUrl());
		} else {
			bookInfo.setModifyTime(record.getCreateTime());
			bookInfo.getContents().clear();
		}

		// TODO OPTYPE
		for (BookDataRecordDetail ins : record.getDetails()) {
			BookDataContent tmp = new BookDataContent();
			tmp.setDataType(ins.getDataType());
			bookInfo.getContents().add(tmp);
		}

		bookInfo.setStatus(Consts.BOOK_STATUS_ENABLE);

		return bookInfo;
	}

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

}
