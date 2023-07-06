package com.masters.pay.bank.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long id;
    @CreationTimestamp
    @JsonIgnore
    Instant createdTime;
    @UpdateTimestamp
    @JsonIgnore
    Instant updatedTime;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String password;
    private String emailId;
    private String phoneNo;
    private String vpa;
    private Long balanceAmount;
}
