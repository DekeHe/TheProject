package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.entity.PosStatus;
import com.example.acccountmanagementsystem.repository.JpaPosStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosStatusService
{
    //
    @Autowired
    private JpaPosStatusRepository jpaPosStatusRepository;

    private static Logger logger= LoggerFactory.getLogger("PosStatusService");

    //
    //read
    @CachePut(cacheNames="posStatus",key="#posStatus.token")
    public String readStatusByToken(String token)
    {
        if(jpaPosStatusRepository.findById(token).orElse(null)!=null)
        {
            logger.info("read status by token "+token+" is:"+jpaPosStatusRepository.readStatusByToken(token));
            return jpaPosStatusRepository.readStatusByToken(token);
        }
        else
        {
            logger.warn("token not existed, cannot read status by token. ");
            return "token not existed, cannot read status by token. ";
        }

    }

    @Cacheable(cacheNames="allStatus")
    public List<PosStatus> readAllStatus()
    {
        logger.info("read all status is: "+jpaPosStatusRepository.findAll());
        return jpaPosStatusRepository.findAll();
    }

    //create
    @CachePut(cacheNames="posStatus",key="#posStatus.token")
    public void savePosStatus(String token,String status)
    {
        PosStatus posStatus=new PosStatus(token,status);
        jpaPosStatusRepository.save(posStatus);

        logger.info("posStatus saved. token is: "+token+", status is: "+status+". ");
    }

    //delete
    @CacheEvict(cacheNames="posStatus",key="#id")
    public String deletePosStatus(String id)
    {
        jpaPosStatusRepository.deleteById(id);

        logger.info("delete posstatus by id: "+id);
        return "deleted. ";
    }

    //update
//    savePosStatus



}
