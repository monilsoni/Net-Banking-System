package com.monisoni.netbanking.dao;

import java.util.List;

import com.monisoni.netbanking.entity.Account;

public interface UserAccountDetailsDAO {

	List<Account> getAccounts(long userId); 
	
}
