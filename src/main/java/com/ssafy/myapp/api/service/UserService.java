package com.ssafy.myapp.api.service;

import com.ssafy.myapp.domain.User;
import com.ssafy.myapp.api.repository.JPAUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final JPAUserRepository userRepository;

//    @Transactional
    public User createMember(User user) {
        // JpaRepository에서 제공하는 save() 함수
        System.out.println(userRepository);
        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        return savedUser;
    }

    public Optional<User> fbp() {
        return userRepository.findByPassword("1234");
    }
}
