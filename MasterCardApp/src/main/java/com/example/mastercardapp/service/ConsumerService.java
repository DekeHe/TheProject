package com.example.mastercardapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService
{
    private static Logger logger= LoggerFactory.getLogger("ConsumerService");

    @KafkaListener(topics="AccountToMaster")
    public void receiveStatus(String status)
    {
        logger.info("status received is: "+status);
    }
}
