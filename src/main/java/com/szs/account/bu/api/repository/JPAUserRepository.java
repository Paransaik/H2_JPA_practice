package com.szs.account.bu.api.repository;

import com.szs.account.bu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface JPAUserRepository extends JpaRepository<User, Long> {

    User findById(String id);

    public boolean existsByRegistNum(String registNum);

    //    int checkById(String id);
//
//    void registUser(Map<String, String> map);
//
//    void updateUser(Map<String, String> map);
//
//    void deleteUser(String id);
//
//    User infoUser(String id);
//
//    User loginUser(String id, String password);
//
//    int checkPasswordFind(Map<String, String> map);
//
//    void updatePassword(Map<String, String> map);

}