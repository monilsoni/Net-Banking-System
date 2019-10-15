package com.monisoni.netbanking.dao;

import com.monisoni.netbanking.entity.BankUser;

public interface BankUserDAO {
	
	public BankUser findByUserName(String username);
	
}
