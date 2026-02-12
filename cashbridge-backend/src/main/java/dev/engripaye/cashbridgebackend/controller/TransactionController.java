package dev.engripaye.cashbridgebackend.controller;

import dev.engripaye.cashbridgebackend.dto.SendRequest;
import dev.engripaye.cashbridgebackend.dto.TransactionResponse;
import dev.engripaye.cashbridgebackend.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/send")
    public ResponseEntity<TransactionResponse> sendMonet(@RequestBody SendRequest request,
                                                         Authentication authentication){
        TransactionResponse response = transactionService.sendMoney(request);

        // Risk flag: block if amount > 5000
        if(request.getAmount().doubleValue() > 50000){
            response.setStatus("RISK FLAGGED");
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<List<TransactionResponse>> getTransactions(@PathVariable Long accountId){

    return ResponseEntity.ok(transactionService.getTransactions(accountId));
    }
}
