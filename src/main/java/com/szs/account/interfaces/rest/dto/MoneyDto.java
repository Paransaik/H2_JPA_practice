package com.szs.account.interfaces.rest.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MoneyDto {
    Long id;
    Long userId;
    String name;
    Long balance;
    Double interestDue;
    private LocalDateTime createdAt;

    @Builder
    public MoneyDto(Long id, Long userId, String name, Long balance, Double interestDue, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.balance = balance;
        this.interestDue = interestDue;
        this.createdAt = createdAt;
    }
}
