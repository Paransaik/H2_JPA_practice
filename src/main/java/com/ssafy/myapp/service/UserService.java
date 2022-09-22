package com.ssafy.myapp.service;

import com.ssafy.myapp.domain.User;
import com.ssafy.myapp.domain.JPAUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final JPAUserRepository userRepository;

    @Transactional
    public User createMember(User user) {
        // JpaRepository에서 제공하는 save() 함수
        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        return savedUser;
    }
}
