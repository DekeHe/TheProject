package com.example.acccountmanagementsystem.controller;

import com.example.acccountmanagementsystem.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController
{
    //
    @Autowired
    private GeneralService generalService;

    @DeleteMapping(value="/delete/all/things")
    public String deleteAllThings()
    {
        return generalService.deleteAllThings();
    }
}
