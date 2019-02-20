package com.capgemini.payment.repo;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import com.capgemini.payment.bean.Customer;
import com.capgemini.payment.util.Util;

public class WalletRepoImpl implements WalletRepo 
{
	EntityManager entitymanager = Util.getConnection();
	
	@Override
	public boolean save(Customer customer) throws SQLException 
	{
		if(findOne(customer.getMobileno())==null) {
		entitymanager.getTransaction().begin(); 
		entitymanager.persist(customer); 
		entitymanager.getTransaction().commit();  
		return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Customer findOne(String mobileNo) throws SQLException
	{
		Customer customer = entitymanager.find(Customer.class, mobileNo);  
		if(customer!=null)
			return customer;
		else
			return null;
	}

	@Override
	public boolean update(Customer customer) throws SQLException
	{
		entitymanager.getTransaction().begin();
		customer.getWallet().setBalance(customer.getWallet().getBalance());
		entitymanager.getTransaction().commit();
		return true;
	}
}