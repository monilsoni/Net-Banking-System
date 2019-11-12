package com.monisoni.netbanking.security;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monisoni.netbanking.dao.UserDAO;
import com.monisoni.netbanking.dao.UserRolesDAO;
import com.monisoni.netbanking.entity.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private final UserDAO userDAO;
	private final UserRolesDAO userRolesDAO;

	private Logger logger = Logger.getLogger(getClass().getName());

	
	@Autowired
	public CustomUserDetailsService(UserDAO userDAO, UserRolesDAO userRolesDAO) {
		this.userDAO = userDAO;
		this.userRolesDAO = userRolesDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(">>> Entered username: " + username);
		User user = userDAO.findByUserName(username);
				
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			logger.info(">>> Found user with username: " + user.getUsername());
			
			List<String> userRoles = userRolesDAO.findRoleByUserId(user.getUserId());
			return new CustomUserDetails(user, userRoles);
		}
	}

}
