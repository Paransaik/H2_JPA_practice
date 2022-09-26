package com.szs.account.repositories;

import com.szs.account.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

    //*************nativeQuery = true 추가
//    @Modifying
//    @Query(value = "UPDATE Question q set q.showCount = q.showCount + 1 where q.questionId = :questionId" , nativeQuery = true)
//    void updateShowCount(@Param("questionId") Long questionId);

    Accounts findByUserId(Long userId);

    List<Accounts> findAllByUserIdOrderByIdDesc(Long userId);
    //***************List<Accounts> findAllByUserIdAscId(long id); 에서 위와같이 orderby 문법 수정

}
