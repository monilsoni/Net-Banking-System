package com.monisoni.netbanking.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.entity.BankUserRole;

@Repository
public class BankUserRolesDAOImpl implements BankUserRolesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<String> findRoleByUserId(Long userId) {


		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<BankUserRole> query = session.createQuery("from BankUserRole where userid = :id ");
		query.setParameter("id", userId);
		List<BankUserRole> list = (List<BankUserRole>) query.list();
		List<String> roles = new ArrayList<String>();
		
		for (BankUserRole role : list) {
			roles.add(role.getRole());
		}

		System.out.println(">>> " + roles.toString() + " USERID: " + userId);
		
		return roles;
	}

}
