package com.cnpat.pdsc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PdscStarter {

	@SuppressWarnings("resource")
	public static void main(String... args) {
		new ClassPathXmlApplicationContext("applicationContext*.xml");
	}
}
