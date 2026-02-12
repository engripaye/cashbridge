package dev.engripaye.cashbridgebackend.service;

import dev.engripaye.cashbridgebackend.dto.AuthResponse;
import dev.engripaye.cashbridgebackend.dto.LoginRequest;
import dev.engripaye.cashbridgebackend.dto.RegisterRequest;
import dev.engripaye.cashbridgebackend.entity.Account;
import dev.engripaye.cashbridgebackend.entity.User;
import dev.engripaye.cashbridgebackend.repository.AccountRepository;
import dev.engripaye.cashbridgebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request){

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .bvn(request.getBvn())
                .nin(request.getNin())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        Account account = Account.builder()
                .accountNumber(generateAccountNumber())
                .balance(BigDecimal.ZERO)
                .user(user)
                .build();

        accountRepository.save(account);

        return AuthResponse.builder()
                .message("User Registered Successfully")
                .accountNumber(account.getAccountNumber())
                .build();
    }

    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
    }
}
