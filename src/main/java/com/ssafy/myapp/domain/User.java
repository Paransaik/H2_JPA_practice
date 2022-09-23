package com.ssafy.myapp.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
//@Table(name = "USER")  // 테이블 지정
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Builder
    public User(Long idx, String id, String password) {
        this.idx = idx;
        this.id = id;
        this.password = password;
    }
}
