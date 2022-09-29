package com.szs.account.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "account_id")
    private Long accountId;

    @NotNull
    @Column(name = "last_transaction_id")
    private Long lastTransactionId;

    @NotNull
    @Column(name = "balance")
    private Long balance;

    @NotNull
    @Column(name = "uuid")
    private String uuid;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public AccountSyncLogs(Long id, Long accountId, Long lastTransactionId, Long balance, String uuid, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.lastTransactionId = lastTransactionId;
        this.balance = balance;
        this.uuid = uuid;
        this.createdAt = createdAt;
    }

}
