package com.example.acccountmanagementsystem.service;

import com.example.acccountmanagementsystem.Enum.All_Status;
import com.example.acccountmanagementsystem.Enum.Pos_Status;
import com.example.acccountmanagementsystem.config.Resource;
import com.example.acccountmanagementsystem.entity.Account;
import com.example.acccountmanagementsystem.repository.JpaAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService
{
    //
    @Autowired
    private JpaAccountRepository jpaAccountRepository;

    @Autowired
    private PosStatusService posStatusService;

    private Logger logger= LoggerFactory.getLogger("AccountService");


    //
    //read
    @Cacheable(cacheNames="account")
    public Account readAccount(String id)
    {
        logger.info("read account by id "+id+":"+jpaAccountRepository.findById(id).orElse(null));
        return jpaAccountRepository.findById(id).orElse(null);
    }

    @Cacheable(cacheNames="accounts")
    public List<Account> readAllAccounts()
    {
        logger.info("read all accounts");
        return jpaAccountRepository.findAll();
    }


    //create
    @Cacheable(cacheNames="account")
    public String createAccount(Account account)
    {
        if(this.readAccount(account.getId())==null && checkValidStatus(account.getStatus()))
        {
            jpaAccountRepository.save(account);

            logger.info("account "+account+" saved. ");
            return "account saved. ";
        }
        else
        {
            logger.info("account id already existed, cannot create! ");
            return "account id already existed, cannot create! ";
        }
    }

    @Cacheable(cacheNames="twentyaccounts")
    public String createTwentyAccounts()
    {
        jpaAccountRepository.saveAll(Resource.accounts);

        logger.info("twenty accounts created. ");
        return "twenty accounts created. ";
    }

    //delete

    @CacheEvict(cacheNames="account",key="#id")
    public String deleteAccount(String id)
    {
        jpaAccountRepository.deleteById(id);

        logger.info("delete account by id: "+id);
        return "account deleted. ";
    }

    @CacheEvict(cacheNames="accounts",key="#id")
    public String deleteAllAccounts()
    {
        jpaAccountRepository.deleteAll();

        logger.info("all accounts deleted. ");
        return "all accounts deleted. ";
    }
    //update
    @CachePut(cacheNames="account",key="#account.token")
    public String updateAccount(String token,String status)
    {
        Account account=jpaAccountRepository.readAccountByToken(token);
        if(account!=null && checkValidStatus(status))
        {
            account.setStatus(status);
            jpaAccountRepository.save(account);

            posStatusService.savePosStatus(token, Pos_Status.INACTIVE.name());

            logger.info("account "+account+" updated. ");
            return "account updated. ";
        }
        else
        {
            logger.warn("account by token not existed or status not valid, cannot update! ");
            return "account by token not existed or status not valid, cannot update! ";
        }
    }
    //
    @CachePut(cacheNames="tokenStatus")
    public boolean checkValidTokenStatus(String token,String status)
    {
        Account account=jpaAccountRepository.readAccountByToken(token);

        if(account!=null && checkValidStatus(status) && status.equals(account.getStatus()))
        {
            return true;
        }
        else
        {
            logger.warn("token status combination not valid! ");
            return false;
        }
    }

    @Cacheable(cacheNames="status")
    public boolean checkValidStatus(String status)
    {
        for(All_Status enum_status: All_Status.values())
        {
            if(status.equals(enum_status.name()))
            {
                logger.info("checkValidStatus("+status+") is: "+true);
                return true;
            }
        }
        logger.info("checkValidStatus("+status+") is: "+false);
        return false;
    }
}
