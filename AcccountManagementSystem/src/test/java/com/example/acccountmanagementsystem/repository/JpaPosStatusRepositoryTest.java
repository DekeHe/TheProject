package com.example.acccountmanagementsystem.repository;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.entity.PosStatus;
import com.example.acccountmanagementsystem.service.PosStatusService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


@SpringBootTest
public class JpaPosStatusRepositoryTest
{
    //
    @Autowired
    private JpaPosStatusRepository jpaPosStatusRepository;

    @Autowired
    private PosStatusService posStatusService;
    //
    @Test
    void readStatusByToken()
    {
        int a=0;
        jpaPosStatusRepository.save(new PosStatus("00t1", All_Status.ACTIVE.name()));

        String status=posStatusService.readStatusByToken("00t1");
        assertEquals(status,All_Status.ACTIVE.name());

        String status2=posStatusService.readStatusByToken("00t2");
        assertEquals(status2,"token not existed, cannot read status by token. ");

        String posStatusDeleted=posStatusService.deletePosStatus("00t1");
    }

}
