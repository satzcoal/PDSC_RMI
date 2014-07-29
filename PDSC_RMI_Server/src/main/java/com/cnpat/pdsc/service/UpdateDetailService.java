package com.cnpat.pdsc.service;

import java.util.LinkedList;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate4.HibernateTemplate;

import cn.com.cnpat.cprs.ds.xml.ExtraXMLData;
import cn.com.cnpat.cprs.ds.xml.ExtraXMLDataPublic;
import cn.com.cnpat.cprs.rmi.bean.CurrentBean;

import com.cnpat.pdsc.common.Consts;
import com.cnpat.pdsc.data.entity.Applicant;
import com.cnpat.pdsc.data.entity.Biblio;
import com.cnpat.pdsc.data.entity.Inventor;
import com.cnpat.pdsc.rmi.msg.UpdateDetailInMsg;
import com.cnpat.pdsc.rmi.msg.UpdateDetailOutMsg;
import com.cnpat.pdsc.rmi.msg.entry.CommonEntry;

@Configuration
@EnableAspectJAutoProxy
public class UpdateDetailService {

	private static final Logger logger = LogManager
			.getLogger(UpdateDetailService.class);

	private HibernateTemplate dataht;
	private String xmlRootPath;
	private String tmpRootPath = "D:\\cprs\\tmp\\";

	public UpdateDetailOutMsg getUpdateDetail(UpdateDetailInMsg req) {

		int datatype = req.getDataType();
		List<CommonEntry> list = null;

		switch (datatype) {
		case Consts.UPDATE_DATATYPE_CURRENT:
			list = makeCurrentBeans(req.getIdList());
			break;
		case Consts.UPDATE_DATATYPE_GRANT:
			list = makeGrantBeans(req.getIdList());
			break;
		case Consts.UPDATE_DATATYPE_PUBLIC:
			list = makePublicBeans(req.getIdList());
			break;
		default:
			break;
		}

		UpdateDetailOutMsg res = new UpdateDetailOutMsg();

		res.setResList(list);

		return res;
	}

	private List<CommonEntry> makePublicBeans(List<String> idList) {

		List<CommonEntry> list = new LinkedList<CommonEntry>();

		for (String ins : idList) {
			String fullpath = xmlRootPath + parseGrantSubPath(ins);

			System.out.println(fullpath);

			ExtraXMLDataPublic xmldatatool = null;
			try {
				ZipFile zip = new ZipFile(fullpath);
				List<?> headers = zip.getFileHeaders();

				String tmpfilepath = null;

				for (Object tmp : headers) {
					FileHeader header = (FileHeader) tmp;
					if (header.getFileName().toUpperCase().endsWith("XML")) {
						zip.extractFile(header, tmpRootPath);
						tmpfilepath = tmpRootPath + header.getFileName();
						break;
					}
				}

				xmldatatool = new ExtraXMLDataPublic();
				xmldatatool.read(tmpfilepath);
			} catch (Exception e) {
				// TODO
				e.printStackTrace();
			}
			list.add(new CommonEntry(ins, xmldatatool.getPublicBean()));
		}
		return list;
	}

	private List<CommonEntry> makeCurrentBeans(List<String> idList) {

		List<CommonEntry> list = new LinkedList<CommonEntry>();
		for (String ins : idList) {

			// TODO DAO
			Biblio bib = dataht.get(Biblio.class, ins);
			CurrentBean current = new CurrentBean();
			current.setAge_cod(bib.getAgent().getAgency_code());
			List<String> applist = new LinkedList<String>();
			for (Applicant app : bib.getApplicant()) {
				applist.add(app.getName());
				if (app.getSeq() == 1) {
					current.setApp_add(app.getAddress());
					current.setAre_cod(app.getProvince());
				}
			}
			current.setApp(null);
			current.setApp_dat(Integer.parseInt(bib.getFiling_date()));
			current.setApp_no(bib.getFiling_no());
			current.setDid(ins);
			current.setGra_dat(Integer.parseInt(bib.getPub_date()));
			current.setGra_no(bib.getPub_no());
			current.setId(null);
			List<String> invlist = new LinkedList<String>();
			for (Inventor inv : bib.getInventors()) {
				invlist.add(inv.getName());
			}
			current.setInv(invlist);
			current.setPri_cou(bib.getPrioritys().get(0).getPri_country());
			current.setPri_dat(Integer.parseInt(bib.getPrioritys().get(0)
					.getPri_date()));
			current.setPub_dat(Integer.parseInt(bib.getPub_date()));
			current.setPub_no(bib.getPub_no());
			current.setSta(bib.getCur_status());
			current.setTit(bib.getTitle());
			// current.setTyp(typ);

			list.add(new CommonEntry(ins, current));
		}
		return list;
	}

	private List<CommonEntry> makeGrantBeans(List<String> idList) {

		List<CommonEntry> list = new LinkedList<CommonEntry>();

		for (String ins : idList) {
			String fullpath = xmlRootPath + parseGrantSubPath(ins);

			System.out.println(fullpath);

			ExtraXMLData xmldatatool = null;
			try {
				ZipFile zip = new ZipFile(fullpath);
				List<?> headers = zip.getFileHeaders();

				String tmpfilepath = null;

				for (Object tmp : headers) {
					FileHeader header = (FileHeader) tmp;
					if (header.getFileName().toUpperCase().endsWith("XML")) {
						zip.extractFile(header, tmpRootPath);
						tmpfilepath = tmpRootPath + header.getFileName();
						break;
					}
				}

				xmldatatool = new ExtraXMLData();
				xmldatatool.read(tmpfilepath);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO

			}
			list.add(new CommonEntry(ins, xmldatatool.getGrantBean()));
		}
		return list;
	}

	private String parseGrantSubPath(String ins) {
		logger.info(ins);

		StringBuffer sb = new StringBuffer(ins.substring(0, 12));
		sb.insert(4, '\\');
		sb.insert(10, '\\');
		sb.insert(14, '\\');
		sb.append(ins.substring(0, 12)).append('\\').append(ins).append(".zip");

		logger.info(sb.toString());

		return sb.toString();
	}

	public String getXmlRootPath() {
		return xmlRootPath;
	}

	public void setXmlRootPath(String xmlRootPath) {
		this.xmlRootPath = xmlRootPath;
	}

	public static void main(String... args) {

		String ins = "20121020883520130102";

		UpdateDetailService uds = new UpdateDetailService();
		uds.setXmlRootPath("D:\\cprs\\xmldata\\");
		System.out.println(ins);

		List<String> idList = new LinkedList<String>();
		idList.add(ins);

		List<CommonEntry> list = uds.makePublicBeans(idList);

		System.out.println(list);
	}

	public HibernateTemplate getDataht() {
		return dataht;
	}

	public void setDataht(HibernateTemplate dataht) {
		this.dataht = dataht;
	}
}
