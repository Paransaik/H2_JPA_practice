package com.szs.account.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
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
