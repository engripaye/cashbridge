package dev.engripaye.cashbridgebackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String phone;

    private String bvn;

    private String nin;

    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;



}
