package com.powerup.user.users.infrastructure.entities;

import com.powerup.user.users.domain.utils.constants.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer identityDocument;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    }



