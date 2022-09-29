package com.szs.account.repositories;

import com.szs.account.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

    Accounts findByUserIdAndId(Long userId, Long id);

    List<Accounts> findAllByUserIdOrderByIdDesc(Long userId);

}
