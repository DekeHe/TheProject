package com.example.acccountmanagementsystem.config;

import com.example.acccountmanagementsystem.entity.Account;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Resource
{
    public final static List<Account> accounts=new LinkedList<>(Arrays.asList(
            new Account("00a1","ACTIVE","Aaron","bank","12345678","00t1"),
            new Account("00a2","DELETED","Aaron","bank","12345678","00t2"),
            new Account("00a3","DEACTIVATED","Aaron","bank","12345678","00t3"),
            new Account("00a4","SUSPENDED","Aaron","bank","12345678","00t4"),
            new Account("00a5","ACTIVE","Aaron","bank","12345678","00t5"),
            new Account("00a6","DELETED","Aaron","bank","12345678","00t6"),
            new Account("00a7","DEACTIVATED","Aaron","bank","12345678","00t7"),
            new Account("00a8","SUSPENDED","Aaron","bank","12345678","00t8"),
            new Account("00a9","ACTIVE","Aaron","bank","12345678","00t9"),
            new Account("00a10","DELETED","Aaron","bank","12345678","00t10"),
            new Account("00a11","DEACTIVATED","Bob","bank","12345678","00t11"),
            new Account("00a12","SUSPENDED","Bob","bank","12345678","00t12"),
            new Account("00a13","ACTIVE","Bob","bank","12345678","00t13"),
            new Account("00a14","DELETED","Bob","bank","12345678","00t14"),
            new Account("00a15","DEACTIVATED","Bob","bank","12345678","00t15"),
            new Account("00a16","SUSPENDED","Bob","bank","12345678","00t16"),
            new Account("00a17","ACTIVE","Bob","bank","12345678","00t17"),
            new Account("00a18","DELETED","Bob","bank","12345678","00t18"),
            new Account("00a19","DEACTIVATED","Bob","bank","12345678","00t19"),
            new Account("00a20","SUSPENDED","Bob","bank","12345678","00t20")
    ));
}
