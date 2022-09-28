package com.szs.account.interfaces.rest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestAccountSyncDto {
    Long accountId;
    Long lastTransactionId;
    Long balance;

    @Builder
    public RequestAccountSyncDto(Long accountId, Long lastTransactionId, Long balance) {
        this.accountId = accountId;
        this.lastTransactionId = lastTransactionId;
        this.balance = balance;
    }
}
