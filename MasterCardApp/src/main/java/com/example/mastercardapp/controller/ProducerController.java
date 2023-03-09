package com.example.mastercardapp.controller;

import com.example.mastercardapp.service.ProducerService;
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
    @PutMapping(value="/send/token")
    public String sendToken(@RequestParam(value="token")String token)
    {
        return producerService.sendToken(token);
    }
}
