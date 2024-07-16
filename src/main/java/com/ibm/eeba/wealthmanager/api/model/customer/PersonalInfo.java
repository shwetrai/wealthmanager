package com.ibm.eeba.wealthmanager.api.model.customer;

import java.util.List;

public class PersonalInfo {

    private String name;
    private String contactNumber;
    private String email;
    private String city;
    private String Country;
    private String organisation;
    private List<GovID> govID;

    private String age;
    private String nominee;
    private String noOfDependents;

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public String getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(String noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public List<GovID> getGovID() {
        return govID;
    }

    public void setGovID(List<GovID> govID) {
        this.govID = govID;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
