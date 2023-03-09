package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.Enum.Pos_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.repository.JpaAccountRepository;
import com.example.acccountmanagementsystem.repository.JpaAccountRepositoryTest;
import com.example.acccountmanagementsystem.repository.JpaPosStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ConsumerServiceTest
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

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
    public void savePosStatus()
    {
        String saved=accountService.createAccount(new Account("00a1",
                All_Status.DELETED.name(),"Aaron","bank","12345678","00t1"));

        consumerService.savePosStatus("00t1");

        String status=jpaPosStatusRepository.findById("00t1").get().getStatus();
        assertEquals(status,Pos_Status.INACTIVE.name());

        String posStatusDeleted=posStatusService.deletePosStatus("00t1");
    }
}
