package com.captest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id", nullable = false)
	private Long id;
	@Column(name = "transaction_date", nullable = false)
	private String transactionDate;
	@Column(name = "transaction_value", nullable = false)
	private BigDecimal transactionValue;
	@Column(name = "account_number", nullable = false)
	private String accountNumber;
}
