package com.monisoni.netbanking.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.monisoni.netbanking.dao.UserAccountDetailsDAO;
import com.monisoni.netbanking.dao.UserDAO;
import com.monisoni.netbanking.entity.Account;
import com.monisoni.netbanking.entity.Transaction;
import com.monisoni.netbanking.entity.User;
import com.monisoni.netbanking.service.TransactionService;

@Controller
public class MainController {

	static final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private UserAccountDetailsDAO accountDetails;

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private UserDAO userDAO;

	private String from = "";
	
	@GetMapping("/")
	public String showHome(Model model, Authentication authentication, Principal principal) {
		
		BasicConfigurator.configure();
		
		if( authentication != null ) {
			
			User user = userDAO.findByUserName(principal.getName());
			
			List<Account> accountList = accountDetails.getAccounts(user.getUserId());

			for (Account account : accountList) {
				logger.debug(account.toString());
			}

			model.addAttribute("accountList", accountList);
		} 
		
		return "dashboard-page";
	}

	@RequestMapping(value = "transaction", method = RequestMethod.POST)
	public String transaction(@RequestParam("accountNoCred") String to, 
			@RequestParam("amount") String transferAmount,
			@RequestParam("details") String details) {

		BasicConfigurator.configure();
		logger.debug(">>> Value here: " + from);
		
		transactionService.performTransaction(from, to, transferAmount, details);

		return "redirect:/";

	}

	@RequestMapping("/transfer")
	public String transfer(@RequestParam("accountNo") String from, Model theModel) {

		BasicConfigurator.configure();

		this.from = from;

		return "transfer-page";
	}
	
	@RequestMapping(value = "/miniStatement")
	public String miniStatement(@RequestParam("accountNo") String accountNo,
								Model theModel){
		
		BasicConfigurator.configure();
		
		List<Transaction> result = transactionService.generateMiniStatement(accountNo);
		
		theModel.addAttribute("transactionList", result);
		theModel.addAttribute("accountNo", accountNo);
		return "mini-statement-page";
									
	}

	
}










