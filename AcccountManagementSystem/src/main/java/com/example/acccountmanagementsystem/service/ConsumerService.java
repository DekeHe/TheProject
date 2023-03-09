package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.Enum.Pos_Status;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.repository.JpaAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConsumerService
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private PosStatusService posStatusService;

    @Autowired
    private ProducerService producerService;

    private static Logger logger= LoggerFactory.getLogger("ConsumerService");


    //
    @KafkaListener(topics={"MasterToAccount"})
    public void savePosStatus(String token)
    {
        logger.info("token received is: "+token);
        Account account=jpaAccountRepository.readAccountByToken(token);
        if(account!=null)
        {
            String status=account.getStatus();

            boolean good=false;
            for(All_Status a:All_Status.values())
            {
                if(status.equals(a.name()))
                {
                    good=true;
                    break;
                }
            }

            if(good)
            {
                String finalStatus=status;
                if(!status.equals(All_Status.ACTIVE.name()))
                {
                    finalStatus=Pos_Status.INACTIVE.name();
                }

                posStatusService.savePosStatus(token,finalStatus);

                producerService.sendStatus(token);

                logger.info("save posStatus by token: "+token);

            }
            else
            {
                logger.warn("status of account is not valid! ");
            }
        }
        else
        {
            logger.warn("account id is not valid! ");
        }

    }
}
