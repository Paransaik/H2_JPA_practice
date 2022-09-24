package com.szs.account.services;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.models.Accounts;
import com.szs.account.models.Transactions;
import com.szs.account.models.Type;
import com.szs.account.repositories.AccountRepository;
import com.szs.account.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.time.LocalDateTime;

import static com.szs.account.models.Type.DEPOSIT;
import static com.szs.account.models.Type.WITHDRAW;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    AuthorizedUser authorizedUser;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transactions save(long accountId, long amount, Type type) throws Exception {
        return transactionRepository
                .save(Transactions
                        .builder()
                        .accountId(accountId)
                        .userId(authorizedUser.getId())
                        .amount(amount)
                        .type(type)
                        .createdAt(LocalDateTime.now())
                        .build());
    }

    public Transactions transaction(Transactions transactions) throws Exception {
        switch (transactions.getType()) {
            case DEPOSIT:
                /*
                 * 계좌 업데이트,
                 * return TransactionDTO
                 * */
                return null;
            case WITHDRAW:
                /*
                 * "출금 금액은 현재 잔액보다 클 수 없음"
                 * */
                return null;
            default:
                return null;
        }
    }
//    public Optional<Account> getAccount(long id) {
//        return accountRepository.findById(id);
//    }

}