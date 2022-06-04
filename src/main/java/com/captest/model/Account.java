package com.captest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
	//The lowest amount that the account cannot go below
	private BigDecimal minimumBalance;
	//The balance on the account at any particular time
	private BigDecimal currentBalance;
	//The name of the account holder
	private String accountName;
	//The id of the account holder
	private long customerID;
	//The class of the account
	private String accountClass;
	//The currency of the account - USD, GBP, NGN
	private String currency;
}
