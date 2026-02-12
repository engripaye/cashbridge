package dev.engripaye.cashbridgebackend.entity;

import dev.engripaye.cashbridgebackend.wallet.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipient;

    private BigDecimal amount;

    private LocalDateTime timestamp;

    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
