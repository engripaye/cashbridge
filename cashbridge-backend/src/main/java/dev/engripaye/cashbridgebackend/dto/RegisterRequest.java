package dev.engripaye.cashbridgebackend.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String fullName;
    private String email;
    private String phone;
    private String nin;
    private String password;

}
