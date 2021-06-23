package com.infy.repository;

public class CustomerRepository {
	public String fetchCustomer(int count) {
		return "The number of customer fetched are :"+count;
	}
	
	public String createCustomer() {
		return "Customer is successfully created";
	}

}
