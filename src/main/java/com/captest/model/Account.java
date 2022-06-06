package com.captest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "account_number", nullable = false)
	private String accountNumber;
	//The lowest amount that the account cannot go below
	@Column(name = "initial_credit")
	private BigDecimal initialCredit;
	//The balance on the account at any particular time
	@Column(name = "current_balance", nullable = false)
	private BigDecimal currentBalance;
	//The id of the account holder
	@Column(name = "customer_id", nullable = false)
	private long customerID;
	//The class of the account
	@Column(name = "account_class")
	private String accountClass;
	@Column(name = "account_type")
	private String accountType;
	@Column(name = "account_currency")
	//The currency of the account - USD, GBP, NGN
	private String accountCurrency;
	@Column(name = "account_status")
	//The currency of the account - USD, GBP, NGN
	private String accountStatus;
	
}
