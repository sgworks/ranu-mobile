package com.sgworks.mobile.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_ID", nullable = false)
    private int contactId;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "ALTERNATE_MOBILE_NUMBER")
    private String alternateMobileNumber;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "ALTERNATE_EMAIL_ADDRESS")
    private String alternateEmailAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID_FK")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return ("CONTACT_ID = " + this.getContactId() + " : MOBILE_NUMBER = " + this.getMobileNumber() +
                " : ALTERNATE_MOBILE_NUMBER = " + this.getAlternateMobileNumber() + " : EMAIL_ADDRESS = " +
                this.getEmailAddress() + " : ALTERNATE_EMAIL_ADDRESS = " + this.getAlternateEmailAddress());
    }
}
