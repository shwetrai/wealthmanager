package com.ibm.eeba.wealthmanager.api.service.accounts;

import com.ibm.eeba.wealthmanager.api.model.accounts.Account;
import com.ibm.eeba.wealthmanager.api.model.accounts.Transactions;
import com.ibm.eeba.wealthmanager.api.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    AccountsRepository repository;


    @Override
    public void create(Account account){


        repository.insert(account);
    }

    @Override
    public Optional<Account> findById(String id){
        return repository.findById(id);
    }

    // List<Customer> findCustomerByContactNumber(String contactNumber);
    @Override
    public List<Account> findAll(){
        return repository.findAll();
    }


    @Override
    public Account findAndUpdateAccountsByID(Account account){
        Query query = new Query().addCriteria(Criteria.where("_id").is(account.getAccountID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        Update updateDefinition = new Update();
        Account exisitngAccount;
        Optional<Account> opACC= findById(account.getAccountID());
        Account a = opACC.get();
       // System.out.println(a.getAccountID()+ ":" + a.getNominee());
        if(opACC !=null){
            exisitngAccount = findById(account.getAccountID()).get();
           // System.out.println(exisitngAccount.getAccountID()+ ":" + exisitngAccount.getNominee());
            if(account.getCag()!=null )
                updateDefinition.set("cag",account.getCag());
            if(account.getCurrentValue()!=null)
                updateDefinition.set("currentValue",account.getCurrentValue());
            if(account.getPurchaseValue() !=null)
                updateDefinition.set("purchaseValue",account.getPurchaseValue());
            if(account.getNominee()!=null)
                updateDefinition.set("nominee",account.getNominee());

            List<Transactions> txn = exisitngAccount.getTransactions();

            if(account.getTransactions() !=null)
                txn.addAll(account.getTransactions());
            updateDefinition.set("transactions",txn);

            return mongoTemplate.findAndModify(query,updateDefinition,options,Account.class);
        }

        return null;
    }
}
