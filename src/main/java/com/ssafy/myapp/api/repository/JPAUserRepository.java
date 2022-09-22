package com.ssafy.myapp.api.repository;

import com.ssafy.myapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface JPAUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPassword(String password);


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