package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.Enum.Pos_Status;
import com.example.acccountmanagementsystem.config.Resource;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.repository.JpaAccountRepository;
import com.example.acccountmanagementsystem.repository.JpaAccountRepositoryTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class AccountServiceTest
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private AccountService accountService;



    //
    //read
    @Test
    public void readAccount()
    {

        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));

        Account account=accountService.readAccount("00a1");
        assertNotNull(account);

        Account account2=accountService.readAccount("00a21");
        assertNull(account2);

        String deleted=accountService.deleteAccount("00a1");
    }

    //create
    @Test
    public void createAccount()
    {

        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));
        assertEquals(saved,"account saved. ");

        String saved2=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));
        assertEquals(saved2,"account id already existed, cannot create! ");

        String deleted=accountService.deleteAccount("00a1");
    }


    //delete

    //update
    @Test
    public void updateAccount()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));

        String updated=accountService.updateAccount("00t1",All_Status.ACTIVE.name());
        assertEquals(updated,"account updated. ");

        String updated2=accountService.updateAccount("00t21",All_Status.ACTIVE.name());
        assertEquals(updated2,"account by token not existed or status not valid, cannot update! ");

        String deleted=accountService.deleteAccount("00a1");
    }
    //
    @Test
    public void checkValidTokenStatus()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));


        boolean bool=accountService.checkValidTokenStatus("00t1",All_Status.ACTIVE.name());
        assertEquals(bool,true);
        boolean bool2=accountService.checkValidTokenStatus("00t21",All_Status.ACTIVE.name());
        assertEquals(bool2,false);

        String deleted=accountService.deleteAccount("00a1");
    }
}
