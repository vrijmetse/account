package com.kadmos.saving;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("balance")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal updateBalance(@RequestBody BigDecimal amount) {
        return accountService.updateBalance(amount);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getBalance() {
        return accountService.getBalance();
    }
}
