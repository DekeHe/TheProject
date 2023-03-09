package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.entity.PosStatus;
import com.example.acccountmanagementsystem.repository.JpaPosStatusRepository;
import com.example.acccountmanagementsystem.repository.JpaPosStatusRepositoryTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PosStatusServiceTest
{
    //
    @Autowired
    private JpaPosStatusRepository jpaPosStatusRepository;

    @Autowired
    private PosStatusService posStatusService;

    private static Logger logger= LoggerFactory.getLogger("PosStatusService");

    //
    //read
    @Test
    public void readStatusByToken()
    {
        jpaPosStatusRepository.save(new PosStatus("00t1", All_Status.ACTIVE.name()));

        String status=posStatusService.readStatusByToken("00t1");
        assertEquals(status,All_Status.ACTIVE.name());

        String status2=posStatusService.readStatusByToken("00t2");
        assertEquals(status2,"token not existed, cannot read status by token. ");

        String deleted=posStatusService.deletePosStatus("00t1");
    }


    //create

    //update
//    savePosStatus



}
