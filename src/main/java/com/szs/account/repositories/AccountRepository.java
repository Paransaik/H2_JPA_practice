package com.szs.account.repositories;

import com.szs.account.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

    @Modifying
    @Query("UPDATE Question q set q.showCount = q.showCount + 1 where q.questionId = :questionId")
    void updateShowCount(@Param("questionId") Long questionId);


    List<Accounts> findAllByUserIdAscId(long id);
}
