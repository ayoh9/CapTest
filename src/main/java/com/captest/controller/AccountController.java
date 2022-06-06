package com.captest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.captest.model.Account;
import com.captest.model.CustomerView;
import com.captest.model.Transaction;
import com.captest.service.AccountService;
import com.captest.service.TransactionService;


@Controller
@RequestMapping("/accounts/")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("createCurrentAccount")
    public String showCreateAccountForm(Account account) {
        return "add-account";
    }
	
	
	@PostMapping("add")
    public String addAccount(@Valid Account account, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-account";
        }
        accountService.createAccount(account);
        return "redirect:list";
    }
	
	@GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "index";
    }
	
	@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") String accountNumber, Model model) {
        CustomerView customerView = accountService.showCustomerView(accountNumber);
            
        model.addAttribute("customerView", customerView);
        return "show-customer";
    }
	
	@PostMapping("transactions/{id}")
    public String showTransactionsForm(@PathVariable("id") String accountNumber, Model model) {
        List<Transaction> transList = transactionService.showTransactions(accountNumber);
            
        model.addAttribute("transList", transList);
        return "transactions";
    }
}
