package com.sgworks.mobile.model;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Embedded
    private CustomerName customerName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Address> customerAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<ContactDetails> customerContactDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Payment> payments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<MobileModel> mobileModels;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Job> jobs;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "GENDER")
    private String gender;

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<MobileModel> getMobileModels() {
        return mobileModels;
    }

    public void setMobileModels(Set<MobileModel> mobileModels) {
        this.mobileModels = mobileModels;
    }

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

    public CustomerName getCustomerName() {
        return customerName;
    }

    public void setCustomerName(CustomerName customerName) {
        this.customerName = customerName;
    }

    public Set<Address> getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Set<Address> customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<ContactDetails> getCustomerContactDetails() {
        return customerContactDetails;
    }

    public void setCustomerContactDetails(Set<ContactDetails> customerContactDetails) {
        this.customerContactDetails = customerContactDetails;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
