package com.monisoni.netbanking.service;

public interface TransactionService {
	
	public int performTransaction(String from, String to, String amount, String details);
	
}
