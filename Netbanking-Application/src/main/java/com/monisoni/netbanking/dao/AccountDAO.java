package com.monisoni.netbanking.dao;

public interface AccountDAO {
	
	public Long accountBalance(String accountNo);
	
	public boolean isValidAccount(String accountNo);
	
	public void updateAccount(String accountNo, long balance);

}
