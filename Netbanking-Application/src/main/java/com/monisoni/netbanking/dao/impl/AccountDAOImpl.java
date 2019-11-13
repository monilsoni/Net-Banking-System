package com.monisoni.netbanking.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.dao.AccountDAO;
import com.monisoni.netbanking.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public Long accountBalance(String accountNo) {
		
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Account> query = session.createQuery("from Account where accountNo = :accountNo", Account.class);
		
		query.setParameter("accountNo", accountNo);
		
		List<Account> result = query.getResultList();
		
		if(!result.isEmpty()) {
			return result.get(0).getBalance();
		}
		
		
		return new Long(0);
	}


	@Override
	@Transactional
	public boolean isValidAccount(String accountNo) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Account> query = session.createQuery("from Account where accountNo = :accountNo", Account.class);
		
		query.setParameter("accountNo", accountNo);
		
		List<Account> result = query.getResultList();
		
		if(!result.isEmpty()) {
			return true;
		}
		
		return false;
	}


	@Override
	@Transactional
	public void updateAccount(String accountNo, long balance) {
		Session session = sessionFactory.getCurrentSession();
		
		Account account = (Account) session.get(Account.class,accountNo);
		
		account.setBalance(balance);

		session.update(account);
		
		
	}

}
