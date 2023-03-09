package com.example.acccountmanagementsystem.repository;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.service.AccountService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@SpringBootTest
public class JpaAccountRepositoryTest
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private AccountService accountService;

    @Test
    void readAccountByToken()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));

        Account account=jpaAccountRepository.readAccountByToken("00t1");
        assertNotNull(account);

        Account account2=jpaAccountRepository.readAccountByToken("00t21");
        assertNull(account2);

        String deleted=accountService.deleteAccount("00a1");
    }


}
