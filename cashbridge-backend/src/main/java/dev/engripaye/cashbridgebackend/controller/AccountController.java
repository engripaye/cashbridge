package dev.engripaye.cashbridgebackend.controller;

import dev.engripaye.cashbridgebackend.entity.Account;
import dev.engripaye.cashbridgebackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {


    private final AccountService accountService;

    @GetMapping("/{userId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long userId){
        return ResponseEntity.ok(accountService.getAccount(userId));
    }
}
