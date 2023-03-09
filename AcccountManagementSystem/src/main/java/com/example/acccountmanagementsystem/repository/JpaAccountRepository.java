package com.example.acccountmanagementsystem.repository;

import com.example.acccountmanagementsystem.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaAccountRepository extends JpaRepository<Account,String>
{
    //

    @Query(value="select a from Account as a where a.token=?1")
    Account readAccountByToken(String token);

}
