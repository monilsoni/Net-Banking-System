package com.monisoni.netbanking.dao.impl;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.dao.TransactionDAO;
import com.monisoni.netbanking.entity.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addTransaction(String from, String to, String amount, String details, Date date,
								long currentBalanceFrom, long currentBalanceTo) {
		
		Session session = sessionFactory.getCurrentSession();
		
		long transferAmount = Long.parseLong(amount);
		
		// inserting transaction details for the logged in user
		Transaction transaction = new Transaction();
		transaction.setAccountNo(from);
		transaction.setAmount(transferAmount);
		transaction.setCrDb("Db");
		transaction.setDetails(details);
		transaction.setDate(date);
		transaction.setClosingBalance(currentBalanceFrom - transferAmount);
		session.save(transaction);
		
		// inserting transaction details for the receiving user
		Transaction transaction2 = new Transaction();
		transaction2.setAccountNo(to);
		transaction2.setAmount(transferAmount);
		transaction2.setCrDb("Cr");
		transaction2.setDetails(details);
		transaction2.setDate(date);
		transaction2.setClosingBalance(transferAmount + currentBalanceTo);
		session.save(transaction2);
		
		

	}
	
	
	

}
