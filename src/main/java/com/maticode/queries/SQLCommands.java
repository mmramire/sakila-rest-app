package com.maticode.queries;

public class SQLCommands {

	/**
	 * 
	 * */
	private SQLCommands() {
	}

	// Customer

	public static final String SELECT_CUSTOMER_LIST_PARTIAL_DATA = "SELECT ID, name, phone, city, country FROM customer_list";

	// Staff

	/*
	 * The staff_list view provides a list of all staff members, including address
	 * and store information.
	 */
	public static final String SELECT_STAFF_LIST_PARTIAL_DATA = "SELECT ID, name, address, zip_code, phone, city, country FROM staff_list;";

}
