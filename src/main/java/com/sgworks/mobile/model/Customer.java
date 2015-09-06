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

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "GENDER")
    private String gender;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Address> customerAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<ContactDetails> customerContactDetails;

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

    @Override
    public String toString() {
        return ("CUSTOMER_ID = " + this.getCustomerId() + " : CUSTOMER_NAME = " + this.getCustomerName() +
                " : DATE_OF_BIRTH = " + this.getDateOfBirth() + " : GENDER = " + this.getGender());
    }
}
