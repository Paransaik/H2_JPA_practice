package com.szs.account.interfaces.rest;

import com.szs.account.auth.AuthorizedUser;
import com.szs.account.interfaces.rest.dto.ApiResult;
import com.szs.account.models.Greeting;
import com.szs.account.services.GreetingService;
import com.szs.account.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Apis {

    private final GreetingService greetingService;
    private final AccountService accountService;

    public Apis(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting/{greetingId}")
    public ApiResult<String> greeting(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @PathVariable long greetingId
    ) {
        return ApiResult.succeed(
                greetingService.getMessage(greetingId)
                        .map(Greeting::getMessage)
                        .orElse("fallback greeting message!")
        );
    }

    @GetMapping("/account")
    public ApiResult<String> account(
            @RequestAttribute(required = false) AuthorizedUser authorizedUser,
            @PathVariable String name
    ) {
        return ApiResult.succeed(
                greetingService.getMessage(name)
                        .map(Account::getMessage)
                        .orElse("fallback greeting message!")
        );
    }

}
