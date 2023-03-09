package com.example.acccountmanagementsystem.controller;

import com.example.acccountmanagementsystem.entity.PosStatus;
import com.example.acccountmanagementsystem.service.PosStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PosStatusController
{
    //
    @Autowired
    private PosStatusService posStatusService;

    //
    @GetMapping(value="/read/status/by/token")
    public String readStatusByToken(@RequestParam(value="token")String token)
    {
        return posStatusService.readStatusByToken(token);
    }

    @GetMapping(value="/read/all/status")
    public List<PosStatus> readAllPosStatus()
    {
        return posStatusService.readAllStatus();
    }
}
