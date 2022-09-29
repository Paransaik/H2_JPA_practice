package com.szs.account.services;

import com.szs.account.models.Transactions;
import com.szs.account.models.Type;
import com.szs.account.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.szs.account.models.Type.DEPOSIT;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transactions save(Long userId, Long accountId, Long amount, Type type) throws Exception {
        System.out.println(userId);
        System.out.println(accountId);
        System.out.println(amount);
        System.out.println(type);
        return transactionRepository
                .save(Transactions
                        .builder()
                        .accountId(accountId)
                        .userId(userId)
                        .amount(amount)
                        .type(type)
                        .createdAt(LocalDateTime.now())
                        .build());
    }

    /*
    - `id`: 계좌 ID
    - `userId`: 사용자 ID
    - `name`: 계좌 명칭
    - `balance`: 계좌 잔액
    - `interestDue`: 지급 예정 이자
    - `createdAt`: 계좌 생성일시
    * */
    public Long getAccoutMoney(Long userId) {
        List<Transactions> transactionsList = transactionRepository.findAllByUserId(userId);
        Long money = 0L;
        for (Transactions transactions : transactionsList) {
            if (transactions.getType() == DEPOSIT) money += transactions.getAmount();
            else money -= transactions.getAmount();
        }
        return money;
    }

//    public Optional<Transactions> getLastTransactiondId(Long userId, Long accountId) {
//        return transactionRepository.findFirstByUserIdAndAccountIdOrderByCreatedAtDesc(userId, accountId);
//    }

    public Optional<Transactions> getLastTransactiondId(Long userId, Long accountId) {
        return transactionRepository.findFirstByUserIdAndAccountIdOrderByIdDesc(userId, accountId);
    }
}