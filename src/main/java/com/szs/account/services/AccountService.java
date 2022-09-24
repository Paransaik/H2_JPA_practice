package com.szs.account.services;

import com.szs.account.models.Account;
import com.szs.account.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> getAccount(long id) {
        return accountRepository.findById(id);
    }

}


}
