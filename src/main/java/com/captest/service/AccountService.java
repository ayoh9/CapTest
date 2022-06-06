package com.captest.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captest.model.Account;
import com.captest.model.Customer;
import com.captest.model.CustomerView;
import com.captest.model.Transaction;
import com.captest.repository.AccountRepository;
import com.captest.repository.CustomerRepository;
import com.captest.util.Utility;

@Service
public class AccountService {

	// Inject Account Repository
	@Autowired
	AccountRepository accountRepository;

	// Inject Customer Repository
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TransactionService transactionService;

	public Account createAccount(Account account) {

		Account createdAccount = new Account();

		try {
			// Confirm that the customer exists
			// using the customer id
			Customer customer = customerRepository.findById(account.getCustomerID()).get();
			// Check if the customer object is not null
			if (customer != null) {

				// customer exists, create current account for this customer
				// STEP 1: GENERATE Current Account Number
				String accountNumber = Utility.generateAccountNumber();
				account.setCustomerID(account.getCustomerID());
				account.setAccountNumber(accountNumber);
				account.setCurrentBalance(account.getInitialCredit());
				// Set Account Type: CU for current; SA for savings
				account.setAccountType("CU");
				account.setAccountStatus("ACTIVE");
				account.setAccountCurrency("NGN");

				createdAccount = accountRepository.save(account);
				System.out.println("Initial Credit: "+account.getInitialCredit());
				//The initial credit is greater than 0
				//create a new transaction on the account
				if (account.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
					//Since the Initial value is greater than zero,
					//create a transaction entry for the account
					Transaction transaction = new Transaction();
					transaction.setTransactionDate((new Date()).toString());
					transaction.setTransactionValue(account.getInitialCredit());
					transaction.setAccountNumber(createdAccount.getAccountNumber());
					
					transactionService.createTransaction(transaction);
				}
			}
		} catch (NoSuchElementException e) {
			createdAccount.setAccountStatus("NOT CREATED");
			return createdAccount;
		}

		return accountRepository.save(account);
	}

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	public CustomerView showCustomerView(String accountNumber) {
		CustomerView customerView = new CustomerView();
		Account account = accountRepository.findById(accountNumber).get();
		if(account != null) {
			Customer customer = customerRepository.findById(account.getCustomerID()).get();
			customerView.setAccountNumber(accountNumber);
			customerView.setBalance(account.getCurrentBalance());
			customerView.setFirstName(customer.getFirstName() == null ? "" : customer.getFirstName());
			customerView.setLastName(customer.getLastName() == null ? "" : customer.getLastName());
		}
		return customerView;
	}
}
