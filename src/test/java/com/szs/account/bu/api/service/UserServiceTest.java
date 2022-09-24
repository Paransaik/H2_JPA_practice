package com.szs.account.bu.api.service;

import com.szs.account.bu.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    UserService userService;

    @Test
    void createMember() throws Exception {
        // given
        User user = User
                .builder()
                .id("taeyeong")
                .password("1234")
                .build();

        // when
        User saveUser = userService.save(user);

        // then
        User u = userService.findById(saveUser.getId());
        System.out.println(u);
        assertThat(user.getId()).isEqualTo(u.getId());
    }

    @Test
    void delete() {
    }

    @Test
    void validateDuplicateUser() {
    }

    @Test
    void randomGenerateString() {
    }
}