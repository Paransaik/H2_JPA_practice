package com.szs.account.interfaces.rest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseAccountSyncDto {
    Long accountId;
    Long lastTransactionId;
    Long balance;
    String uuid;

    @Builder
    public ResponseAccountSyncDto(Long accountId, Long lastTransactionId, Long balance, String uuid) {
        this.accountId = accountId;
        this.lastTransactionId = lastTransactionId;
        this.balance = balance;
        this.uuid = uuid;
    }
}
