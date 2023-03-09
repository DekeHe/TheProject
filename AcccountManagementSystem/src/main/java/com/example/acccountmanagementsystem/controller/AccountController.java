package com.example.acccountmanagementsystem.controller;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController
{
    //
    @Autowired
    private AccountService accountService;


    //
    //read

    @GetMapping(value="/read/all/accounts")
    public List<Account> readAllAccounts()
    {
        return accountService.readAllAccounts();
    }
    //create
    @PostMapping(value="/create/account")
    public String createAccount(@RequestBody Account account)
    {
        return accountService.createAccount(account);
    }

    @PostMapping(value="/create/twenty/accounts")
    public String createTwentyAccounts()
    {
        return accountService.createTwentyAccounts();
    }
    //delete
    @DeleteMapping(value="/deactivate/account")
    public String deactivateAccount(@RequestParam(value="token")String token)
    {
        return accountService.updateAccount(token,All_Status.DEACTIVATED.name());
    }
    @DeleteMapping(value="/delete/account")
    public String deleteAccount(@RequestParam(value="token")String token)
    {
        return accountService.updateAccount(token, All_Status.DELETED.name());
    }
    @DeleteMapping(value="/delete/all/accounts")
    public String deleteAllAccounts()
    {
        return accountService.deleteAllAccounts();
    }

    //update


    @PutMapping(value="/update/account")
    public String updateAccount(@RequestParam(value="token")String token,
                             @RequestParam(value="status")String status)
    {
        return accountService.updateAccount(token,status);
    }

    //other
    @GetMapping(value="/check/valid/token/status")
    public  boolean checkValidTokenStatus(@RequestParam(value="token")String token,
                                        @RequestParam(value="status")String status)
    {
        return accountService.checkValidTokenStatus(token,status);
    }
}
