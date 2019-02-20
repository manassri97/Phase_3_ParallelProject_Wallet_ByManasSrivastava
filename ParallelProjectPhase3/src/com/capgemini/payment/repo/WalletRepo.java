package com.capgemini.payment.repo;

import java.sql.SQLException;

import com.capgemini.payment.bean.Customer;

public interface WalletRepo {
	public boolean save(Customer customer) throws SQLException;
	public Customer findOne(String mobileNo) throws SQLException;
	public boolean update(Customer customer) throws SQLException;
}
