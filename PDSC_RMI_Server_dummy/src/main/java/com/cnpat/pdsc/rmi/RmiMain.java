package com.cnpat.pdsc.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiMain {

	public static void main(String... args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context.xml");
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
