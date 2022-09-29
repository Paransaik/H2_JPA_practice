package com.szs.account.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@ToString
@NoArgsConstructor
public class Transactions {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "account_id")
    private Long accountId;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "amount")
    private Long amount;

    @NotNull
    @Column(name = "type")
    private Type type;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Transactions(Long id, Long accountId, Long userId, Long amount, Type type, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.createdAt = createdAt;
    }
}
