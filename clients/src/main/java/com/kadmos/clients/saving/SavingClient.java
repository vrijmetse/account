package com.kadmos.clients.saving;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@FeignClient(
        name = "saving",
        url = "${clients.saving.url}"
)
public interface SavingClient {

    @PostMapping("balance")
    BigDecimal updateBalance(BigDecimal amount);

    @GetMapping("balance")
    BigDecimal getBalance(BigDecimal amount);
}
