package com.monisoni.netbanking.dao;

import java.sql.Date;

public interface TransactionDAO {

	public void addTransaction(String from, String to, String amount, String details, Date date,
									long currentBalanceFrom, long currentBalanceTo);
	
}
