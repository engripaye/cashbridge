package dev.engripaye.cashbridgebackend.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponse {

    private String recipient;
    private BigDecimal amount;
    private LocalDateTime timeStamp;
    private String status;
}
