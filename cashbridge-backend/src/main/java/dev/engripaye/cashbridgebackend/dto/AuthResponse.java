package dev.engripaye.cashbridgebackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    public String message;
    public String accountNumber;
}
