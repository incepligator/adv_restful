package com.cubic.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.cubic.entity.CustomerEntity;

public class Database {
	
	//sudeep and me

	private static Database db = new Database();

	private static Map<String, CustomerEntity> customers = new HashMap<String, CustomerEntity>();

	private Database() {
	}

/*	static {
		CustomerEntity customer = new CustomerEntity();
		customer.setFirstName("sudeep");
		customer.setLastName("stha");
		customer.setPk(100);
		customers.put(String.valueOf(100), customer);
	}*/

	public static Database getDb() {
		return db;
	}

	public static void setDb(Database db) {
		Database.db = db;
	}

	public static Map<String, CustomerEntity> getCustomers() {

		return customers;
	}

	public static void setCustomers(Map<String, CustomerEntity> customers) {
		Database.customers = customers;
	}

	// crud operation of CustomerEntity

	/*public static CustomerEntity add(CustomerEntity customer) {

		customer.setPk(UUID.randomUUID().toString());
		customers.put(customer.getPk(), customer);
		return customer;
	}*/

	public void delete() {

	}

	public static CustomerEntity getById(String id) {

		return customers.get(id);

	}

}
