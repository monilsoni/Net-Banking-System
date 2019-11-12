package com.monisoni.netbanking.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "account_no")
	private String accountNo;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "cr_db")
	private String CrDb;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "closing_balance")
	private long closingBalance;
	
	@Column(name = "date")
	private Date date;
	
	public Transaction() {
		
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCrDb() {
		return CrDb;
	}

	public void setCrDb(String crDb) {
		CrDb = crDb;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(long closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
