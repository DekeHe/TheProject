package com.example.acccountmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Account")
@NoArgsConstructor
@AllArgsConstructor
public class Account
{
    //
    @Id @Column(name="id") @Getter @Setter private String id;
    @Column(name="status") @Getter @Setter private String status;
    @Column(name="name") @Getter @Setter private String name;
    @Column(name="cardType") @Getter @Setter private String cardType;
    @Column(name="cardNumber") @Getter @Setter private String cardNumber;
    @Column(name="token") @Getter @Setter private String token;

}
