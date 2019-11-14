package com.monisoni.netbanking.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.monisoni.netbanking.dao.AccountDAO;
import com.monisoni.netbanking.dao.TransactionDAO;
import com.monisoni.netbanking.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	public AccountDAO accountDAO;

	@Autowired
	public TransactionDAO transactionDAO;

	@Override
	public int performTransaction(String from, String to, String amount, String details) {

		/*
		 * Check if amount to be given is available in the current balance or not
		 */

		long currentBalanceFrom = accountDAO.accountBalance(from);

		long transferAmount = Long.parseLong(amount);

		if (currentBalanceFrom < transferAmount)
			return -1; // amount not sufficient

		/*
		 * Check if the transaction is for valid account or not
		 */

		if (!accountDAO.isValidAccount(to))
			return -2; // account ID doesn't exist

		long currentBalanceTo = accountDAO.accountBalance(to);

		/*
		 * updating the transaction table
		 */

		java.util.Date utilDate = new java.util.Date();

		Date date = new Date(utilDate.getTime());

		transactionDAO.addTransaction(from, to, amount, details, date, currentBalanceFrom, currentBalanceTo);

		accountDAO.updateAccount(to, transferAmount + currentBalanceTo);

		accountDAO.updateAccount(from, currentBalanceFrom - transferAmount);

		return 0;
	}
	
	@Override
	public List<Transaction> generateMiniStatement(String accountNo) {
		
		return transactionDAO.getMiniStatement(accountNo);
		
		
	}

}
