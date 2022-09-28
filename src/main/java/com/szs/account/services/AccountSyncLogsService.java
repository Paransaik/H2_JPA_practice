package com.szs.account.services;

import com.szs.account.interfaces.rest.dto.RequestAccountSyncDto;
import com.szs.account.interfaces.rest.dto.ResponseAccountSyncDto;
import com.szs.account.models.AccountSyncLogs;
import com.szs.account.repositories.AccountSyncLogsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
public class AccountSyncLogsService {

    private final AccountSyncLogsRepository accountSyncLogsRepository;

    public AccountSyncLogsService(AccountSyncLogsRepository accountSyncLogsRepository) {
        this.accountSyncLogsRepository = accountSyncLogsRepository;
    }

    /*
    * @return
    - `id`: 동기화 로그 ID
    - `accountId`: 계좌 ID
    - `lastTransactionId`: 계좌의 가장 마지막 거래 ID
    - `balance`: 계좌 현재 잔액
    - `uuid`: 동기화 완료 UUID
    - `createdAt`: 동기화 처리 일시
    * */
    public AccountSyncLogs save(Long userId, Long accountId, Long lastTransactiondId, Long balance, String uuid) throws Exception {
        return accountSyncLogsRepository
                .save(AccountSyncLogs
                        .builder()
                        .id(userId)
                        .accountId(accountId)
                        .lastTransactionId(lastTransactiondId)
                        .balance(balance)
                        .uuid(uuid)
                        .createdAt(LocalDateTime.now())
                        .build());
    }

    /*
    * 2.2.5. 계좌 동기화 처리
    * @RequestBody Long accountId,
    * @RequestBody Long lastTransactionId
    * @RequestBody Long balance
    *
    * @return
    - `accountId`: 계좌 ID
    - `lastTransactionId`: 마지막 거래 ID
    - `balance`: 계좌 잔액
    - `uuid`: 동기화 완료 UUID
    * */
    public ResponseAccountSyncDto getResponseAccountSyncDto(Long accountId, Long lastTransactiondId, Long balance) {
        String url = "https://codetest.3o3.co.kr/api/account/sync";
        RequestAccountSyncDto dto = new RequestAccountSyncDto(accountId, lastTransactiondId, balance);
        WebClient client = WebClient
                .builder()
                .baseUrl(url)
                .build();
        return client
                .post()
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(ResponseAccountSyncDto.class)
                .block();
    }

}