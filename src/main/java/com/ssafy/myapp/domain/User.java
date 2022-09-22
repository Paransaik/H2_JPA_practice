package com.ssafy.myapp.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@ToString
//@Table(name = "USERS")  // 테이블 지정
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "recommendFlag")
    private int recommendFlag;

    @Builder
    public User(Long id, String password, String email, int recommendFlag) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.recommendFlag = recommendFlag;
    }
}
