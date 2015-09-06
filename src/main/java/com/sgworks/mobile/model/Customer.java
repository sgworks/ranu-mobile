package com.sgworks.mobile.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@JsonAutoDetect
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "ALTERNATE_MOBILE_NUMBER")
    private String alternateMobileNumber;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "ALTERNATE_EMAIL_ADDRESS")
    private String alternateEmailAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Address> customerAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Job> jobs;

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set<Address> getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Set<Address> customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAlternateMobileNumber() {
        return alternateMobileNumber;
    }

    public void setAlternateMobileNumber(String alternateMobileNumber) {
        this.alternateMobileNumber = alternateMobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }

    public void setAlternateEmailAddress(String alternateEmailAddress) {
        this.alternateEmailAddress = alternateEmailAddress;
    }

    @Override
    public String toString() {
        return ("CUSTOMER_ID = " + this.getCustomerId() + " : CUSTOMER_NAME = " + this.getCustomerName() +
                " : MOBILE_NUMBER = " + this.getMobileNumber() + " : ALTERNATE_MOBILE_NUMBER = " + this.getAlternateMobileNumber() +
                " : EMAIL_ADDRESS = " + this.getEmailAddress() + " : ALTERNATE_EMAIL_ADDRESS = " + this.getAlternateEmailAddress());
    }
}
