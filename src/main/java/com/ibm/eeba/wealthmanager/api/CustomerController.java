package com.ibm.eeba.wealthmanager.api;

import com.ibm.eeba.wealthmanager.api.model.customer.Customer;
import com.ibm.eeba.wealthmanager.api.model.customer.CustomerList;
import com.ibm.eeba.wealthmanager.api.model.RespMessage;
import com.ibm.eeba.wealthmanager.api.model.customer.Offer;
import com.ibm.eeba.wealthmanager.api.repository.CustomerRepository;
import com.ibm.eeba.wealthmanager.api.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @Autowired
    private RespMessage respMessage;
    @Autowired
    private CustomerList customers;

    @Autowired
    private Offer offer;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public RespMessage createCustomer(@RequestBody Customer customer){

        String customerID= "WB00"+customer.getPersonalInfo().getContactNumber();
        customer.setCustomerID(customerID);
        customerServiceImpl.create(customer);
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
//        for(Offer offer:offers){
//            if(offer.getStatus().equals("New"));{
//                return offer;
//            }
//        }
        return offers;
    }

    @GetMapping (value = "/check/{customerID}")
    public Boolean checkCustomer(@PathVariable("customerID") String  customerID){

        return customerServiceImpl.findById(customerID).isPresent();
    }

    @GetMapping (value = "/")
    public CustomerList getAllCustoer(){

        customers.setCustomers(customerServiceImpl.findAll());
        return customers;
    }

}
