package com.szs.account.repositories;

import com.szs.account.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    Transactions findByUserId(Long userId);

    List<Transactions> findAllByUserId(Long userId);

}
