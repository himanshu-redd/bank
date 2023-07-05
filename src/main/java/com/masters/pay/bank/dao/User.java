package com.masters.pay.bank.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name = "bank_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    Instant createdTime;
    @UpdateTimestamp
    Instant updatedTime;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailId;
    private String phoneNo;
    private String vpa;
}
