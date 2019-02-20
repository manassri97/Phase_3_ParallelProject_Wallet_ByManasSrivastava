package com.capgemini.payment.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	
	public static EntityManager getConnection()
	{
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Wallet_JPA");  
	     EntityManager em=emf.createEntityManager();  
	     return em;
	}

}
