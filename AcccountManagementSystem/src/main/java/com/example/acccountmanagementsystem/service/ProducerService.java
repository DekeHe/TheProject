package com.example.acccountmanagementsystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService
{
    //
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private PosStatusService posStatusService;

    private static Logger logger= LoggerFactory.getLogger("ConsumerService");


    public void sendStatus(String token)
    {
        String status=posStatusService.readStatusByToken(token);

        kafkaTemplate.send("AccountToMaster",status);

        logger.info("send status by token: "+token);
    }
}
