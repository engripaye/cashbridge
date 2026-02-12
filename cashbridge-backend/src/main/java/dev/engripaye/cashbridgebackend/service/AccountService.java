package dev.engripaye.cashbridgebackend.service;

import dev.engripaye.cashbridgebackend.entity.Account;
import dev.engripaye.cashbridgebackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(Long userId){
        return accountRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
