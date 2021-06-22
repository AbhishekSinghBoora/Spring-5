package com.infy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.service.CustomerServiceImpl;
import com.infy.util.SpringConfiguration;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		CustomerServiceImpl service = (CustomerServiceImpl) ctx.getBean("customerService");
		System.out.println(service.getCount());
		ctx.close();

	}

}
