package com.monisoni.netbanking.service;

import java.util.List;

import com.monisoni.netbanking.entity.Transaction;



public interface TransactionService {
	
	public int performTransaction(String from, String to, String amount, String details);
	
	public List<Transaction> generateMiniStatement(String accountNo);
	
}
