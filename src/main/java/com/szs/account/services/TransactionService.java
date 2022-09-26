package com.szs.account.services;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.interfaces.rest.dto.Money;
import com.szs.account.models.AccountSyncLogs;
import com.szs.account.models.Accounts;
import com.szs.account.models.Transactions;
import com.szs.account.models.Type;
import com.szs.account.repositories.AccountRepository;
import com.szs.account.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.List;

import static com.szs.account.models.Type.DEPOSIT;
import static com.szs.account.models.Type.WITHDRAW;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transactions getTransaction(Long userId) throws Exception {
        return transactionRepository.findByUserId(userId);
    }

    public Transactions save(Long userId, Long accountId, Long amount, Type type) throws Exception {
        switch (type) {
            case DEPOSIT:
                return transactionRepository
                        .save(Transactions
                                .builder()
                                .accountId(accountId)
                                .userId(userId)
                                .amount(amount)
                                .type(type)
                                .createdAt(LocalDateTime.now())
                                .build());
            case WITHDRAW:
                if (accoutMoney(userId) < amount) return null;
                else transactionRepository
                        .save(Transactions
                                .builder()
                                .accountId(accountId)
                                .userId(userId)
                                .amount(amount)
                                .type(type)
                                .createdAt(LocalDateTime.now())
                                .build());
        }

        return null;
    }

    /*
    - `id`: 계좌 ID
    - `userId`: 사용자 ID
    - `name`: 계좌 명칭
    - `balance`: 계좌 잔액
    - `interestDue`: 지급 예정 이자
    - `createdAt`: 계좌 생성일시
    * */


    public Long accoutMoney(Long userId) {
        List<Transactions> transactionsList = transactionRepository.findAllByUserId(userId);
        Long money = 0L;
        for (Transactions transactions : transactionsList) {
            if (transactions.getType() == DEPOSIT) money += transactions.getAmount();
            else money -= transactions.getAmount();
        }
        return money;
    }

//    public Optional<Account> getAccount(long id) {
//        return accountRepository.findById(id);
//    }

}