package com.ssafy.myapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface JPAUserRepository extends JpaRepository<User, Long> {

}