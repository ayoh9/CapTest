package com.captest.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captest.model.Account;
import com.captest.model.Customer;
import com.captest.repository.AccountRepository;
import com.captest.repository.CustomerRepository;
import com.captest.util.Utility;


@Service
public class AccountService {

	//Inject Account Repository
	@Autowired
	AccountRepository accountRepository;
	
	//Inject Customer Repository
	@Autowired
	CustomerRepository customerRepository;
	
	public Account createAccount(Account account) {
		
		Account createdAccount = new Account();
		
		try {
			//Confirm that the customer exists
			//using the customer id
			Customer customer = customerRepository.findById(account.getCustomerID()).get();
			//Check if the customer object is not null
			if(customer != null) {
				//customer exists, create current account for this customer
				//STEP 1: GENERATE Current Account Number
				String accountNumber = Utility.generateAccountNumber();
				account.setCustomerID(account.getCustomerID());
				account.setAccountNumber(accountNumber);
				account.setCurrentBalance(account.getInitialCredit());
				//Set Account Type: CU for current; SA for savings
				account.setAccountType("CU");
				account.setAccountStatus("ACTIVE");
				account.setAccountCurrency("NGN");
				
				createdAccount = accountRepository.save(account);
			}
		}catch(NoSuchElementException e) {
			createdAccount.setAccountStatus("NOT CREATED");
			return createdAccount;
		}
		
		return accountRepository.save(account);
	}
	
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
}
