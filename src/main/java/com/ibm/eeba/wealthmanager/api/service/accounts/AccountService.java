package com.ibm.eeba.wealthmanager.api.service.accounts;

import com.ibm.eeba.wealthmanager.api.model.accounts.Account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    void create(Account account);

    Optional<Account> findById(String id);

    List<Account> findAll();

    Account findAndUpdateAccountsByID(Account account);

}
