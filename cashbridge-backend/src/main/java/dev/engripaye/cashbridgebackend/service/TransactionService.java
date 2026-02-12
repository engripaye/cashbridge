package dev.engripaye.cashbridgebackend.service;

import dev.engripaye.cashbridgebackend.dto.SendRequest;
import dev.engripaye.cashbridgebackend.dto.TransactionResponse;
import dev.engripaye.cashbridgebackend.entity.Account;
import dev.engripaye.cashbridgebackend.entity.Transaction;
import dev.engripaye.cashbridgebackend.repository.AccountRepository;
import dev.engripaye.cashbridgebackend.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionResponse sendMoney(SendRequest request){

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if(account.getBalance().compareTo(request.getAmount()) < 0){
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(request.getAmount()));
        accountRepository.save(account);

        Transaction transaction = Transaction.builder()
                .recipient(request.getRecipient())
                .amount(request.getAmount())
                .timestamp(java.time.LocalDateTime.now())
                .status("SUCCESS")
                .account(account)
                .build();

        transactionRepository.save(transaction);

        return TransactionResponse.builder()
                .recipient(transaction.getRecipient())
                .amount(transaction.getAmount())
                .timeStamp(transaction.getTimestamp())
                .status(transaction.getStatus())
                .build();
    }

    public List<TransactionResponse> getTransactions(Long accountId){

        return transactionRepository.findByAccountId(accountId)
                .stream()
                .map(tx -> TransactionResponse.builder()
                        .recipient(tx.getRecipient())
                        .amount(tx.getAmount())
                        .timeStamp(tx.getTimestamp())
                        .status(tx.getStatus())
                        .build())
                .toList();

    }
}
