package com.szs.account.repositories;

import com.szs.account.models.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Greeting, Long> {
}
