package com.monisoni.netbanking.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.dao.UserDAO;
import com.monisoni.netbanking.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public User findByUserName(String username) {

		// create a session
		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery("from User where username = :username ");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();

		System.out.println(">>> " + user.toString() + "USERNAME: " + username);

		return user;
	}

	@Override
	@Transactional
	public List<User> getUserDetails(long userId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User where userId = :id",User.class);
		query.setParameter("id", userId);
		
		List<User> result = query.getResultList();
		
		
		return result;
	}
	
}
