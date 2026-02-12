package dev.engripaye.cashbridgebackend.entity;

import dev.engripaye.cashbridgebackend.wallet.Wallet;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    private Wallet sender;

    @ManyToOne
    private Wallet receiver;

    private Double amount;

    private String status; // PENDING, SUCCESS, BLOCKED

    private Double riskScore;

    private LocalDateTime createdAt;

}
