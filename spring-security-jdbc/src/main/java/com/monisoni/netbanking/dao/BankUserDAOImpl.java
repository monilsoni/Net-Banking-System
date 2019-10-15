package com.monisoni.netbanking.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.monisoni.netbanking.entity.BankUser;
import com.monisoni.netbanking.entity.BankUserRole;

@Repository
public class BankUserDAOImpl implements BankUserDAO {

	@Override
	public BankUser findByUserName(String username) {
		
		BankUser user = null;

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BankUser.class)
				.addAnnotatedClass(BankUserRole.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
				
			@SuppressWarnings("unchecked")
			Query<BankUser> query = session.createQuery("from BankUser where userName = :username ");
			query.setParameter("username", username);
			user = (BankUser) query.uniqueResult();
			
			System.out.println(">>> " + user.toString() + "USERNAME: " + username);
			
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}

		return user;
	}

}
