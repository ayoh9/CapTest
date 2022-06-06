package com.captest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.captest.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query("SELECT d FROM Transaction d where d.accountNumber = :accountNumber")
	List<Transaction> findTransactions(@Param("accountNumber") String  accountNumber);
}
