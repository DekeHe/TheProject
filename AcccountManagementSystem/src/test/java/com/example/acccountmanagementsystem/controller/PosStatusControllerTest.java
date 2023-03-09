package com.example.acccountmanagementsystem.controller;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.entity.PosStatus;
import com.example.acccountmanagementsystem.repository.JpaPosStatusRepository;
import com.example.acccountmanagementsystem.service.AccountService;
import com.example.acccountmanagementsystem.service.ConsumerService;
import com.example.acccountmanagementsystem.service.PosStatusService;
import com.example.acccountmanagementsystem.service.PosStatusServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PosStatusControllerTest
{
    //
    @Autowired
    private JpaPosStatusRepository jpaPosStatusRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private PosStatusService posStatusService;

    //
    @Test
    @GetMapping(value="/read/status/by/token")
    public void readStatusByToken()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.ACTIVE.name(),"Aaron","bank","12345678","00t1"));

        consumerService.savePosStatus(accountService.readAccount("00a1").getToken());
        String status=posStatusService.readStatusByToken("00t1");
        assertEquals(status,All_Status.ACTIVE.name());

        String status2=posStatusService.readStatusByToken("00t21");
        assertEquals(status2,"token not existed, cannot read status by token. ");

        String accountDeleted=accountService.deleteAccount("00a1");
        String posStatusDeleted=posStatusService.deletePosStatus("00t1");
    }
}
