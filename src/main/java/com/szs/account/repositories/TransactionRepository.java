package com.szs.account.repositories;

import com.szs.account.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    List<Transactions> findAllByUserId(Long userId);

    Transactions findFirstByUserIdOrderByUserIdDesc(Long userId);

}
