package com.example.acccountmanagementsystem.controller;

import com.example.acccountmanagementsystem.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController
{
    //
    @Autowired
    private ProducerService producerService;

    //
    @PutMapping(value="/send/status")
    public void sendStatus(@RequestParam(value="token")String token)
    {
        producerService.sendStatus(token);
    }
}
