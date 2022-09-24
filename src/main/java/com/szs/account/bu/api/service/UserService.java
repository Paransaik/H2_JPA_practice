package com.szs.account.bu.api.service;

import com.szs.account.bu.api.repository.JPAUserRepository;
import com.szs.account.bu.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final JPAUserRepository userRepository;

    public User save(User user) throws Exception {
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }


    public void validateDuplicateUser(User user) throws Exception {
        String userId = user.getId();
        if (userRepository.existsByRegistNum(userId)) {
            throw new Exception("이미 등록된 회원번호가 있습니다.");
        }
    }

    public String randomGenerateString(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedString;
    }

}
