package com.szs.account.repositories;

import com.szs.account.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

    Accounts findByUserId(Long userId);

    List<Accounts> findAllByUserIdOrderByIdDesc(Long userId);

}
