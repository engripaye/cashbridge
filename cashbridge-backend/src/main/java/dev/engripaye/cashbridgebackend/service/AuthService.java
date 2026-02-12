package dev.engripaye.cashbridgebackend.service;

import dev.engripaye.cashbridgebackend.repository.AccountRepository;
import dev.engripaye.cashbridgebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
}
