package com.ibm.eeba.wealthmanager.api.model.accounts;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AccountList {

   private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
