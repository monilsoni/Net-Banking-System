package com.monisoni.netbanking.dao;

import java.util.List;

import com.monisoni.netbanking.entity.User;

public interface UserDAO {

	public User findByUserName(String username);

	List<User> getUserDetails(long userId);

}
