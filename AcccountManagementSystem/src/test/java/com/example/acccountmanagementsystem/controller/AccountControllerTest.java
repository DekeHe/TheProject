package com.example.acccountmanagementsystem.controller;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.repository.JpaAccountRepository;
import com.example.acccountmanagementsystem.service.AccountService;
import com.example.acccountmanagementsystem.service.AccountServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class AccountControllerTest
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private AccountService accountService;


    //
    //read

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
    @Test
    @DeleteMapping(value="/deactivate/account")
    public void deactivateAccount()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));

        String updated=accountService.updateAccount("00t1",All_Status.DEACTIVATED.name());
        assertEquals(updated,"account updated. ");

        String updated2=accountService.updateAccount("00t21",All_Status.ACTIVE.name());
        assertEquals(updated2,"account by token not existed or status not valid, cannot update! ");

        String deleted=accountService.deleteAccount("00a1");
    }

    @Test
    @DeleteMapping(value="/delete/account")
    public void deleteAccount()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));

        String updated=accountService.updateAccount("00t1",All_Status.DELETED.name());
        assertEquals(updated,"account updated. ");

        String updated2=accountService.updateAccount("00t21",All_Status.ACTIVE.name());
        assertEquals(updated2,"account by token not existed or status not valid, cannot update! ");

        String deleted=accountService.deleteAccount("00a1");
    }


    //update
    @Test
    @PutMapping(value="/update/account")
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

    //other
    @Test
    @GetMapping(value="/check/valid/token/status")
    public  void checkValidTokenStatus()
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
