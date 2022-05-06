package com.kadmos.saving;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    public BigDecimal updateBalance(BigDecimal amount) {
        Optional<Account> optionalAccount = accountRepository.findById(1);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            // check it this is a deduction process
            if (amount.compareTo(BigDecimal.ZERO) < 0 && account.getBalance().compareTo(amount) >= 0) {
                throw new IllegalStateException("insufficient balance");
            }
            account.setBalance(account.getBalance().add(amount));
            return account.getBalance();
        }
        throw new IllegalStateException("account does not exist");

    }

    public BigDecimal getBalance() {
        Optional<Account> optionalAccount = accountRepository.findById(1);
        if (optionalAccount.isPresent()){
            return optionalAccount.get().getBalance();
        }
        throw new IllegalStateException("account does not exist");

    }
}
