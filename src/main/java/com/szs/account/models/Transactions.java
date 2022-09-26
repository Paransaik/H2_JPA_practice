package com.szs.account.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@ToString
@NoArgsConstructor
public class Transactions {

@Id
    @Column(name = "id")
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "type")
    private Type type;

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
