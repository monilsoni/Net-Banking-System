package com.monisoni.netbanking.security;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monisoni.netbanking.dao.BankUserDAO;
import com.monisoni.netbanking.dao.BankUserRolesDAO;
import com.monisoni.netbanking.entity.BankUser;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private final BankUserDAO bankUserDAO;
	private final BankUserRolesDAO bankUserRolesDAO;

	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Autowired
	public CustomUserDetailsService(BankUserDAO bankUserDAO, BankUserRolesDAO bankUserRolesDAO) {
		this.bankUserDAO = bankUserDAO;
		this.bankUserRolesDAO = bankUserRolesDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(">>> Entered username: " + username);
		BankUser user = bankUserDAO.findByUserName(username);
				
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			logger.info(">>> Found user with username: " + user.getUserName());
			
			List<String> userRoles = bankUserRolesDAO.findRoleByUserId(user.getUserid());
			return new CustomUserDetails(user, userRoles);
		}
	}

}
