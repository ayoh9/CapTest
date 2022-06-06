package com.captest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_id", nullable = false)
	private long customerID;
	// The name of the account holder
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "gender", nullable = false)
	private String gender;
	@Column(name = "kyc", nullable = false)
	private String kyc;
	@Column(name = "document_number", nullable = false)
	private String documentNumber;

}
