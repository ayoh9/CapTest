package com.captest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.captest.model.Account;
import com.captest.model.Transaction;
import com.captest.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction createTransaction(Transaction transaction) {
		
		return transactionRepository.save(transaction);		
	}
	
	public List<Transaction> showTransactions(String accountNumber){
		return transactionRepository.findTransactions(accountNumber);
	}
}
