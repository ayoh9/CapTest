package com.captest.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerView {
	private String firstName;
	private String lastName;
	private String accountNumber;
	private BigDecimal balance;
	
}
