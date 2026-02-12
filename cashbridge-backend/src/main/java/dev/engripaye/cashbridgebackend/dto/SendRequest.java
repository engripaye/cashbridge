package dev.engripaye.cashbridgebackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SendRequest {

    private Long accountId;
    private String recipient;
    private BigDecimal amount;
}
