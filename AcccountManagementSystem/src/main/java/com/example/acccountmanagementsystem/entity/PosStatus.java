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
@Table(name="PosStatus")
@NoArgsConstructor
@AllArgsConstructor
public class PosStatus
{
    //
    @Id @Column(name="token") @Getter @Setter private String token;
    @Column(name="status") @Getter @Setter private String status;
}
