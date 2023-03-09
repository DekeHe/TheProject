package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.repository.JpaAccountRepository;
import com.example.acccountmanagementsystem.repository.JpaPosStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralService
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private JpaPosStatusRepository jpaPosStatusRepository;

    private static Logger logger= LoggerFactory.getLogger("ConsumerService");


    //
    @CacheEvict(cacheNames="allThings",key="#id")
    public String deleteAllThings()
    {
        jpaAccountRepository.deleteAll();
        jpaPosStatusRepository.deleteAll();

        logger.info("delete all things. ");
        return "deleted. ";
    }
}
