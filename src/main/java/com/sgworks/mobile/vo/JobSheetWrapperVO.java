package com.sgworks.mobile.vo;

import com.sgworks.mobile.model.Address;
import com.sgworks.mobile.model.Customer;
import com.sgworks.mobile.model.DefectFixDetails;
import com.sgworks.mobile.model.Job;
import com.sgworks.mobile.model.MobileModel;
import com.sgworks.mobile.model.Payment;

import java.util.List;

public class JobSheetWrapperVO {

    private Customer customer;
    private Address address;
    private Job job;
    private MobileModel mobileModel;
    private DefectFixDetails defectFixDetails;
    private List<Payment> payments;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public MobileModel getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(MobileModel mobileModel) {
        this.mobileModel = mobileModel;
    }

    public DefectFixDetails getDefectFixDetails() {
        return defectFixDetails;
    }

    public void setDefectFixDetails(DefectFixDetails defectFixDetails) {
        this.defectFixDetails = defectFixDetails;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
