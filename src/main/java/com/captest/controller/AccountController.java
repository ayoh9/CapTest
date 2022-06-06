package com.captest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.captest.model.Account;
import com.captest.service.AccountService;


@Controller
@RequestMapping("/accounts/")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
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
}
