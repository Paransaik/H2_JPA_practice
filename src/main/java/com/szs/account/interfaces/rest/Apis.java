package com.szs.account.interfaces.rest;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.interfaces.rest.dto.ApiResult;
import com.szs.account.interfaces.rest.dto.MoneyDto;
import com.szs.account.interfaces.rest.dto.ResponseAccountSyncDto;
import com.szs.account.models.Accounts;
import com.szs.account.models.Transactions;
import com.szs.account.models.Type;
import com.szs.account.services.AccountService;
import com.szs.account.services.AccountSyncLogsService;
import com.szs.account.services.TransactionService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Apis {

    private final AccountService accountService;
    private final TransactionService transactionService;
    private final AccountSyncLogsService accountSyncLogsService;

    @Autowired
    public Apis(AccountService accountService, TransactionService transactionService, AccountSyncLogsService accountSyncLogsService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.accountSyncLogsService = accountSyncLogsService;
    }

    @GetMapping("health_check")
    public String check() {
        System.out.println("TEST");
        return "Succeed";
    }
    /*public ApiResult<?> checked() throws Exception {
        System.out.println("test");
        return ApiResult.succeed("Succeed");
    }*/

    /*
     * 2.2.1 계좌 생성
     * @RequestBody String name
     *
     * return
     - `id`: 계좌 ID
     - `userId`: 사용자 ID
     - `name`: 계좌 명칭
     - `createdAt`: 계좌 생성일시
     * */
    @PostMapping("/account")
    public ApiResult<?> account(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @RequestBody Map<String, String> map
    ) throws Exception {
        String name = String.valueOf(map.get("name"));

        // Test 05::
        if (name.equals("")) return ApiResult.failed("name 파라미터 누락되었습니다.");
        int accountsSize = accountService.findAllByUserIdOrderByIdDesc(authorizedUser.getId()).size();
        return (accountsSize < 3) ?
                ApiResult.succeed(accountService.save(authorizedUser.getId(), name)) :
                ApiResult.failed("계좌 최대 갯수 초과");
    }

    /*
     * 2.2.2 계좌 목록 조회
     *
     * return
      "data": [
        {
          "id": 9,
          "userId": 1,
          "name": "세 번째 저금통",
          "createdAt": "2022-08-04 00:23:10"
        },
        {
          "id": 2,
          "userId": 1,
          "name": "두 번째 저금통",
          "createdAt": "2022-08-04 00:22:53"
        },
        {
          "id": 1,
          "userId": 1,
          "name": "첫 번째 저금통",
          "createdAt": "2022-08-04 00:22:53"
        }
      ],
      "error": null
     * */
    @GetMapping("/accounts")
    public ApiResult<?> findAllByUserIdOrderByIdAsc(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser
    ) {
        return ApiResult.succeed(
                accountService.findAllByUserIdOrderByIdDesc(authorizedUser.getId())
        );
    }

    /*
    * 2.2.3. 계좌 입출금 기록
    * @PathVariable Long accountId,
    * @RequestBody Long amount,
    * @RequestBody String type
    *
    * @return
    - `id`: 거래 ID
    - `accountId`: 계좌 ID
    - `userId`: 사용자 ID
    - `amount`: 거래 금액
    - `type`: 거래 구분
    - `createdAt`: 거래 생성일시
    * */
    @PostMapping("/account/{accountId}/transaction")
    public ApiResult<?> transaction(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @PathVariable Long accountId,
            @RequestBody Map<String, Object> map
    ) {
        Long amount = Long.valueOf(String.valueOf(map.get("amount")));
        String type = String.valueOf(map.get("type"));
        long userId = authorizedUser.getId();

        // Test 11::
        if (amount < 1) return ApiResult.failed("거래 금액이 1원보다 작습니다.");

        // Test 12::
        if (!EnumUtils.isValidEnum(Type.class, type)) return ApiResult.failed("거래 금액이 1원보다 작습니다.");

        // Test 13::
        if (Type.valueOf(type).equals(Type.WITHDRAW) &&
                transactionService.getAccoutMoney(userId) < amount)
            return ApiResult.failed("출금 금액이 잔액보다 큽니다.");
        return ApiResult.succeed(transactionService.save(
                userId,
                accountId,
                amount,
                Type.valueOf(type)));
    }

    /*
    * 2.2.4. 단일 계좌 조회
    *
    * @return
    - `id`: 계좌 ID
    - `userId`: 사용자 ID
    - `name`: 계좌 명칭
    - `balance`: 계좌 잔액
    - `interestDue`: 지급 예정 이자
    - `createdAt`: 계좌 생성일시
    * */
    @GetMapping("/account/{accountId}")
    public ApiResult<?> printAccount(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @PathVariable Long accountId
    ) {
        Accounts account = accountService.getAccount(authorizedUser.getId(), accountId);

        // Test 16::
        if (account == null) return ApiResult.failed("존재하지 않는 계좌입니다.");
        Long balance = transactionService.getAccoutMoney(authorizedUser.getId());
        Double interestDue = accountService.getInterestDue(balance);
        return ApiResult.succeed(
                MoneyDto
                        .builder()
                        .id(accountId)
                        .userId(authorizedUser.getId())
                        .name(account.getName())
                        .balance(balance)
                        .interestDue(interestDue)
                        .createdAt(account.getCreatedAt())
                        .build());
    }

    /*
    * 2.2.5. 계좌 동기화 처리
    *
    * @return
    - `id`: 동기화 로그 ID
    - `accountId`: 계좌 ID
    - `lastTransactionId`: 계좌의 가장 마지막 거래 ID
    - `balance`: 계좌 현재 잔액
    - `uuid`: 동기화 완료 UUID
    - `createdAt`: 동기화 처리 일시
    * */
    @PutMapping("/account/{accountId}/sync")
    public ApiResult<?> sync(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @PathVariable Long accountId
    ) {
        long userId = authorizedUser.getId();
        Accounts account = accountService.getAccount(userId, accountId);

        // Test 21::
        if (account == null) return ApiResult.failed("존재하지 않는 계좌입니다.");
        Optional<Transactions> lastTransactiondId = transactionService.getLastTransactiondId(userId, accountId);
        Long balance = transactionService.getAccoutMoney(userId);

        // Test 23:: userId 1, accontid 1
        ResponseAccountSyncDto rasd = (lastTransactiondId.isPresent()) ?
                accountSyncLogsService.getResponseAccountSyncDto(accountId, lastTransactiondId.get().getId(), balance) :
                accountSyncLogsService.getResponseAccountSyncDto(accountId, 0L, balance);
        return ApiResult.succeed(accountSyncLogsService.save(userId, rasd.getAccountId(), rasd.getLastTransactionId(), rasd.getBalance(), rasd.getUuid()));
    }

}
