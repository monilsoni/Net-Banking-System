package com.monisoni.netbanking.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.monisoni.netbanking.entity.BankUser;
import com.monisoni.netbanking.entity.BankUserRole;

@Repository
public class BankUserRolesDAOImpl implements BankUserRolesDAO {

	@Override
	public List<String> findRoleByUserId(Long userId) {

		List<String> roles = new ArrayList<String>();
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(BankUser.class)
				.addAnnotatedClass(BankUserRole.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			Query<BankUserRole> query = session.createQuery("from BankUserRole where userid = :id ");
			query.setParameter("id", userId);
			List<BankUserRole> list = (List<BankUserRole>) query.list();
			for(BankUserRole role: list) {
				roles.add(role.getRole());
			}
			
			System.out.println(">>> " + roles.toString() + " USERID: " + userId);
			
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}

		return roles;
	}

}
