package com.monisoni.netbanking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.entity.BankUser;

@Repository
public class BankUserDAOImpl implements BankUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public BankUser findByUserName(String username) {

		// create a session
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<BankUser> query = session.createQuery("from BankUser where userName = :username ");
		query.setParameter("username", username);
		BankUser user = (BankUser) query.uniqueResult();

		System.out.println(">>> " + user.toString() + "USERNAME: " + username);

		return user;
	}

}
