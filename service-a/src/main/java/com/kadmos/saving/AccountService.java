package com.kadmos.saving;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public BigDecimal updateBalance(BigDecimal amount) {
        return BigDecimal.ZERO;

    }

    public BigDecimal getBalance(BigDecimal amount) {
        return BigDecimal.ZERO;

    }
}
