package com.monisoni.netbanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monisoni.netbanking.dao.UserRolesDAO;
import com.monisoni.netbanking.entity.UserRoles;

@Repository
public class UserRolesDAOImpl implements UserRolesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<String> findRoleByUserId(Long userId) {


		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		Query<UserRoles> query = session.createQuery("from UserRoles where userid = :id ");
		query.setParameter("id", userId);
		List<UserRoles> list = (List<UserRoles>) query.list();
		List<String> roles = new ArrayList<String>();
		
		for (UserRoles role : list) {
			roles.add(role.getRole());
		}

		System.out.println(">>> " + roles.toString() + " USERID: " + userId);
		
		return roles;
	}

}
