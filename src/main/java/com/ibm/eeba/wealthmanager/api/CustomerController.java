package com.ibm.eeba.wealthmanager.api;

import com.ibm.eeba.wealthmanager.api.model.accounts.Account;
import com.ibm.eeba.wealthmanager.api.model.accounts.Transactions;
import com.ibm.eeba.wealthmanager.api.model.customer.*;
import com.ibm.eeba.wealthmanager.api.model.RespMessage;
import com.ibm.eeba.wealthmanager.api.repository.CustomerRepository;
import com.ibm.eeba.wealthmanager.api.service.accounts.AccountServiceImpl;
import com.ibm.eeba.wealthmanager.api.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private RespMessage respMessage;
    @Autowired
    private CustomerList customers;

    @Autowired
    private Account account;
    @Autowired
    private OfferList offerList;

    @Autowired
    private Offer offer;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public RespMessage createCustomer(@RequestBody Customer customer){

        String customerID= "WB00"+customer.getPersonalInfo().getContactNumber();
        customer.setCustomerID(customerID);
        customerServiceImpl.create(customer);

        //Create account
        account.setAccountID("MF00"+customer.getPersonalInfo().getContactNumber());
        account.setCustomerID(customerID);
        account.setPurchaseValue(0.0);
        account.setCurrentValue(0.0);
        account.setNominee(customer.getPersonalInfo().getNominee());
        account.setCag(18.0); // Setting default
        accountServiceImpl.create(account);

        respMessage.setRespMessage(customerID);
        return respMessage;
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/investment")
    public RespMessage updateCustomerInvestment(@RequestBody Customer customer){

        customerServiceImpl.findAndUpdateCustomerInvestmentByID(customer);
        respMessage.setRespMessage("Customer Updated");
        return respMessage;
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/personalinfo")
    public RespMessage updateCustomerPersonalInfo(@RequestBody Customer customer){

        customerServiceImpl.findAndUpdateCustomerPersonalInfoByID(customer);
        respMessage.setRespMessage("Customer Updated");
        return respMessage;
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/govid")
    public RespMessage updateCustomerGovID(@RequestBody Customer customer){

        customerServiceImpl.findAndUpdateCustomerGovIDByID(customer);
        respMessage.setRespMessage("Customer Updated");
        return respMessage;
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/offer")
    public RespMessage updateCustomerOffer(@RequestBody Customer customer){

        customerServiceImpl.findAndUpdateCustomerOfferByID(customer);
        respMessage.setRespMessage("Customer Updated");
        return respMessage;
    }



    @GetMapping (value = "/{customerID}")
    public Customer getCustomer(@PathVariable("customerID") String  customerID){

        return customerServiceImpl.findById(customerID).get();
    }

    @GetMapping (value = "/offer/{customerID}")
    public List<Offer> getCustomerOffer(@PathVariable("customerID") String  customerID){
        Customer customer= customerServiceImpl.findById(customerID).get();
        List<Offer> offers= customer.getOffers();
        return offers;
    }

    @GetMapping (value = "/check/{customerID}")
    public Boolean checkCustomer(@PathVariable("customerID") String  customerID){

        return customerServiceImpl.findById(customerID).isPresent();
    }

    @GetMapping (value = "/all")
    public CustomerList getAllCustoer(){

        customers.setCustomers(customerServiceImpl.findAll());
        return customers;
    }
    //**********************************************************************************************
    // *********************WWXO Specific*********************************8
    //************************************************************************************************
    @GetMapping (value = "/offers/{customerID}")
    public OfferList getCustomerOfferList(@PathVariable("customerID") String  customerID){
        Customer customer= customerServiceImpl.findById(customerID).get();
        List<Offer> offers= customer.getOffers();
        offerList.setInstances(offers);
        return offerList;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/buyoffer")
    public RespMessage buyOffer(@RequestBody RequestToBuy offerBuy){
        String customerID = offerBuy.getCustomerID();
        List<Account> accounts= accountServiceImpl.findAccountBycustomerID(customerID);
        Account acc = accounts.get(0);
       // System.out.println("Account Id "+acc.getAccountID());
        acc.setPurchaseValue(acc.getPurchaseValue()+offerBuy.getInvestmentAmount());
        acc.setCurrentValue(acc.getCurrentValue()+offerBuy.getInvestmentAmount());
        List<ServicePlan> servicePlans = offerBuy.getOffer().getServicePlans();
        List<Transactions> existingTxn = acc.getTransactions();
        if(existingTxn==null)
            existingTxn = new ArrayList<Transactions>();
        Transactions txn;
        for(ServicePlan sp:servicePlans){
            //System.out.println("Product Name "+sp.getProductName());
            txn = new Transactions();
            txn.setFundName(sp.getProductName());
            txn.setNav(25.0);
            txn.setTransactionDate(new Date());
            txn.setTransactionType("Lump sump");
            txn.setAmount((offerBuy.getInvestmentAmount()*sp.getAllocation())/100);
            existingTxn.add(txn);
        }
        acc.setTransactions(existingTxn);
        accountServiceImpl.findAndUpdateAccountsByID(acc);
        respMessage.setRespMessage("Products are added to your account");
        return respMessage;
    }


    @GetMapping (value = "/offers/{customerID}/{name}")
    public Offer getCustomerOfferList(@PathVariable("customerID") String  customerID,@PathVariable("name") String  name){
        Customer customer= customerServiceImpl.findById(customerID).get();
        List<Offer> offers= customer.getOffers();
        Offer selectedOffer=null;
        for(Offer offer:offers){
            if(name.equalsIgnoreCase(offer.getOfferName())) {
                selectedOffer = offer;
                break;
            }

        }
        return selectedOffer;
    }

}
