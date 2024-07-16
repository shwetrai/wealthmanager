package com.ibm.eeba.wealthmanager.api;

import com.ibm.eeba.wealthmanager.api.model.RespMessage;
import com.ibm.eeba.wealthmanager.api.model.accounts.Account;
import com.ibm.eeba.wealthmanager.api.model.accounts.AccountList;
import com.ibm.eeba.wealthmanager.api.repository.AccountsRepository;
import com.ibm.eeba.wealthmanager.api.service.accounts.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private RespMessage respMessage;
    @Autowired
    private AccountsRepository repository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Autowired
    private AccountList accounts;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public RespMessage createAccount(@RequestBody Account account){

        accountServiceImpl.create(account);
        respMessage.setRespMessage("Account Created");
        return respMessage;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/account")
    public RespMessage updateAccount(@RequestBody Account account){

        Account a=accountServiceImpl.findAndUpdateAccountsByID(account);
        respMessage.setRespMessage("Account Updated");
        if(a==null)
            respMessage.setRespMessage("Account does not exist");
        return respMessage;
    }

    @GetMapping (value = "/{accountID}")
    public Account getAccount(@PathVariable("accountID") String  accountID){

        return accountServiceImpl.findById(accountID).get();
    }

    @GetMapping (value = "/")
    public AccountList getAllAccounts(){

        accounts.setAccountList(accountServiceImpl.findAll());
        return accounts;
    }
}
