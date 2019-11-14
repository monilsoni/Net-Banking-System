package com.monisoni.netbanking.dao;

import java.sql.Date;
import java.util.List;

import com.monisoni.netbanking.entity.Transaction;



public interface TransactionDAO {

	public void addTransaction(String from, String to, String amount, String details, Date date,
									long currentBalanceFrom, long currentBalanceTo);
	
	public List<Transaction> getMiniStatement(String account);
	
}
