package com.szs.account.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@ToString
@NoArgsConstructor
public class Accounts {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Accounts(Long id, Long userId, String name, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.createdAt = createdAt;
    }

}
