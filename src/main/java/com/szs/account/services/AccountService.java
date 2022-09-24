package com.szs.account.services;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.models.Accounts;
import com.szs.account.models.Transactions;
import com.szs.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    AuthorizedUser authorizedUser;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Accounts save(String name) throws Exception {
        return accountRepository
                .save(Accounts
                        .builder()
                        .userId(authorizedUser.getId())
                        .name(name)
                        .createdAt(LocalDateTime.now())
                        .build());
    }

    public List<Accounts> findAllByUserIdOrderByIdAsc() throws Exception {
        return accountRepository.findAllByUserIdOrderByIdAsc(authorizedUser.getId());
    }



}