package com.ibm.eeba.wealthmanager.api.service.customer;

import com.ibm.eeba.wealthmanager.api.model.customer.Customer;
import com.ibm.eeba.wealthmanager.api.model.customer.GovID;
import com.ibm.eeba.wealthmanager.api.model.customer.Offer;
import com.ibm.eeba.wealthmanager.api.model.customer.PersonalInfo;
import com.ibm.eeba.wealthmanager.api.repository.CustomerRepository;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    CustomerRepository repository;

    @Override
    public void create(Customer customer){
        repository.insert(customer);
    }

    @Override
    public Optional<Customer> findById(String id){
        return repository.findById(id);
    }

   // List<Customer> findCustomerByContactNumber(String contactNumber);
   @Override
   public  List<Customer> findAll(){
        return repository.findAll();
   }
    @Override
    public Customer findAndUpdateCustomerInvestmentByID(Customer customer){
        Query query = new Query().addCriteria(Criteria.where("_id").is(customer.getCustomerID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
        Update updateDefinition = new Update().set("investment",customer.getInvestment());
//        Update updateDefinition = new Update().set("currentStatus",opportunity.getCurrentStatus());
//        updateDefinition.set("income",customer.getIncome());
//        updateDefinition.set("expense",customer.getExpense());
//        updateDefinition.set("debt",customer.getDebt());
//        updateDefinition.set("investment",customer.getInvestment());
//        updateDefinition.set("creditRating",customer.getCreditRating());
//        updateDefinition.set("financialGoal",customer.getFinancialGoal());
        return mongoTemplate.findAndModify(query,updateDefinition,options,Customer.class);
    }

    @Override
    public Customer findAndUpdateCustomerPersonalInfoByID(Customer customer){

        Customer existingCustomer=findById(customer.getCustomerID()).get();
        PersonalInfo existingPersonalInfo = existingCustomer.getPersonalInfo();
        List<GovID> existingGovIDs = existingPersonalInfo.getGovID();
        List<GovID> newGovIDs = customer.getPersonalInfo().getGovID();
        if(existingGovIDs!=null) {
            for (GovID newID : newGovIDs) {
                boolean isExistingID = false;
                for (GovID existingID : existingGovIDs) {
                    if (existingID.getIdType().equalsIgnoreCase(newID.getIdType())) {
                        isExistingID = true;
                        System.out.println("Existing ID Type:" + existingID.getIdType());
                    }
                }
                if (!isExistingID)
                    existingGovIDs.add(newID);
            }
            // existingGovIDs.addAll(customer.getPersonalInfo().getGovID());
            if(newGovIDs!=null)
                newGovIDs.clear(); //Clear all Gov ID
            customer.getPersonalInfo().setGovID(existingGovIDs);
        }
        Query query = new Query().addCriteria(Criteria.where("_id").is(customer.getCustomerID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
        Update updateDefinition = new Update().set("personalInfo",customer.getPersonalInfo());
        updateDefinition.set("riskTolerance",customer.getRiskTolerance());
        updateDefinition.set("creditRating",customer.getCreditRating());



//        Update updateDefinition = new Update().set("currentStatus",opportunity.getCurrentStatus());
//        updateDefinition.set("income",customer.getIncome());
//        updateDefinition.set("expense",customer.getExpense());
//        updateDefinition.set("debt",customer.getDebt());
//        updateDefinition.set("investment",customer.getInvestment());
//        updateDefinition.set("creditRating",customer.getCreditRating());
//        updateDefinition.set("financialGoal",customer.getFinancialGoal());
        return mongoTemplate.findAndModify(query,updateDefinition,options,Customer.class);
    }
    @Override
    public Customer findAndUpdateCustomerGovIDByID(Customer customer){

        Customer existingCustomer=findById(customer.getCustomerID()).get();
        PersonalInfo existingPersonalInfo = existingCustomer.getPersonalInfo();
        List<GovID> existingGovIDs = existingPersonalInfo.getGovID();
        List<GovID> newGovIDs = customer.getPersonalInfo().getGovID();
        if(existingGovIDs!=null) {
            for (GovID newID : newGovIDs) {
                boolean isExistingID = false;
                for (GovID existingID : existingGovIDs) {
                    if (existingID.getIdType().equalsIgnoreCase(newID.getIdType())) {
                        isExistingID = true;
                        System.out.println("Existing ID Type:" + existingID.getIdType());
                    }
                }
                if (!isExistingID)
                    existingGovIDs.add(newID);
            }
            // existingGovIDs.addAll(customer.getPersonalInfo().getGovID());
            if(newGovIDs!=null)
                newGovIDs.clear(); //Clear all Gov ID
            customer.getPersonalInfo().setGovID(existingGovIDs);
        }else{
            existingPersonalInfo.setGovID(newGovIDs);

        }
        Query query = new Query().addCriteria(Criteria.where("_id").is(customer.getCustomerID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
        Update updateDefinition = new Update().set("personalInfo",existingCustomer.getPersonalInfo());
        updateDefinition.set("riskTolerance",existingCustomer.getRiskTolerance());
        updateDefinition.set("creditRating",existingCustomer.getCreditRating());



//        Update updateDefinition = new Update().set("currentStatus",opportunity.getCurrentStatus());
//        updateDefinition.set("income",customer.getIncome());
//        updateDefinition.set("expense",customer.getExpense());
//        updateDefinition.set("debt",customer.getDebt());
//        updateDefinition.set("investment",customer.getInvestment());
//        updateDefinition.set("creditRating",customer.getCreditRating());
//        updateDefinition.set("financialGoal",customer.getFinancialGoal());
        return mongoTemplate.findAndModify(query,updateDefinition,options,Customer.class);
    }

    @Override
    public Customer findAndUpdateCustomerOfferByID(Customer customer){
        Query query = new Query().addCriteria(Criteria.where("_id").is(customer.getCustomerID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
        Update updateDefinition = new Update().set("offers",customer.getOffers());
//        Update updateDefinition = new Update().set("currentStatus",opportunity.getCurrentStatus());
//        updateDefinition.set("income",customer.getIncome());
//        updateDefinition.set("expense",customer.getExpense());
//        updateDefinition.set("debt",customer.getDebt());
//        updateDefinition.set("investment",customer.getInvestment());
//        updateDefinition.set("creditRating",customer.getCreditRating());
//        updateDefinition.set("financialGoal",customer.getFinancialGoal());
        return mongoTemplate.findAndModify(query,updateDefinition,options,Customer.class);
    }



}
