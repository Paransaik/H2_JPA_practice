package com.szs.account.interfaces.rest;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.interfaces.rest.dto.ApiResult;
import com.szs.account.models.Transactions;
import com.szs.account.models.Type;
import com.szs.account.services.AccountService;
import com.szs.account.services.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Apis {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public Apis(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    /*
     * 2.2.1 계좌 생성
     * @RequestBody String name
     *
     * return
        id: 계좌 ID
        userId: 사용자 ID
        name: 계좌 명칭
        createdAt: 계좌 생성일시
     * */
    @PostMapping("/account")
    public ApiResult<?> account(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @RequestBody String name
    ) throws Exception {
        return ApiResult.succeed(
                accountService.save(name)
        );
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
    public ApiResult<?> findAllByUserIdAscId(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser
    ) throws Exception {
        return ApiResult.succeed(
                accountService.findAllByUserIdAscId()
//                        .orElse("fallback greeting message!")
        );
    }

    /*
    * 2.2.3. 계좌 입출금 기록
    * @PathVariable long greetingId,
    * @RequestBody Long amount,
    * @RequestBody String type
    *
    * @return
        id: 거래 ID
        accountId: 계좌 ID
        userId: 사용자 ID
        amount: 거래 금액
        type: 거래 구분
        createdAt: 거래 생성일시
    * */
    @PostMapping("/account/{accountId}/transaction")
    public ApiResult<?> transaction(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @PathVariable long accountId,
            @RequestBody long amount,
            @RequestBody Type type
    ) throws Exception {
        Transactions savedTransactions = transactionService.save(accountId, amount, type);
        return ApiResult.succeed(
                transactionService.transaction(savedTransactions)
        );
    }

}
