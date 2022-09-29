package com.szs.account.repositories;

import com.szs.account.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    List<Transactions> findAllByUserId(Long userId);

//    Optional<Transactions> findFirstByUserIdAndAccountIdOrderByCreatedAtDesc(Long userId, Long accountId);
    Optional<Transactions> findFirstByUserIdAndAccountIdOrderByIdDesc(Long userId, Long accountId);

}
