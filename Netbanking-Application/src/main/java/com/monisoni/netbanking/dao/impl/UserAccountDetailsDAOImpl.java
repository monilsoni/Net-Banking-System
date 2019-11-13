package com.monisoni.netbanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.dao.UserAccountDetailsDAO;
import com.monisoni.netbanking.entity.Account;

@Repository
public class UserAccountDetailsDAOImpl implements UserAccountDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	static final Logger logger = Logger.getLogger(UserAccountDetailsDAOImpl.class);

	@Override
	@Transactional
	public List<Account> getAccounts(long userId) {

		BasicConfigurator.configure();

		Session session = sessionFactory.getCurrentSession();

		Query<Account> query = session.createQuery("from Account where userId = :id", Account.class);

		query.setParameter("id", userId);

		List<Account> result = new ArrayList<>();

		if (query != null) {
			result = query.getResultList();
		}

		return result;
	}

}
