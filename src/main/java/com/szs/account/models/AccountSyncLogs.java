package com.szs.account.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_sync_logs")
@Getter
@ToString
@NoArgsConstructor
public class AccountSyncLogs {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "last_transaction_id")
    private Long lastTransactionId;

    @Column(name = "balance")
    private String balance;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public AccountSyncLogs(Long id, Long accountId, Long lastTransactionId, String balance, String uuid, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.lastTransactionId = lastTransactionId;
        this.balance = balance;
        this.uuid = uuid;
        this.createdAt = createdAt;
    }
}
