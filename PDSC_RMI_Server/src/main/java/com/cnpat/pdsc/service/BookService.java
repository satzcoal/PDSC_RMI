package com.cnpat.pdsc.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cnpat.pdsc.entity.TblBookDataContent;

public class BookService {

	protected static SessionFactory sessionFactory = null;

	protected static void setUp() throws Exception {
		// A SessionFactory is set up once for an application
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String... args) throws Exception {

		setUp();

		TblBookDataContent bdc = new TblBookDataContent();
		bdc.setDataType(1);
		bdc.setId(1);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bdc);
		session.getTransaction().commit();
		session.close();
	}
}
