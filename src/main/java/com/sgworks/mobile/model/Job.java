package com.sgworks.mobile.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sgworks.mobile.util.JsonDateSerializerUtil;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@JsonAutoDetect
@Entity
@Table(name = "JOB")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_ID", nullable = false)
    private int jobId;

    @Column(name = "JOB_TYPE")
    private String jobType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOB_RECEIVED_DATE")
    private Date jobReceivedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOB_ESTIMATED_DATE")
    private Date jobEstimatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOB_COMPLETION_DATE")
    private Date jobCompletionDate;

    @Column(name = "ENGINEER_NAME")
    private String engineerName;

    @Column(name = "TOTAL_ESTIMATED_AMOUNT", columnDefinition = "Decimal(10,2)")
    private BigDecimal totalEstimatedAmount;

    @Column(name = "TOTAL_PAYMENT_AMOUNT", columnDefinition = "Decimal(10,2)")
    private BigDecimal totalPaymentAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PAYMENT_DUE_DATE")
    private Date paymentDueDate;

    @Column(name = "JOB_STATUS")
    private String jobStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
    private Set<Payment> payments;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID_FK")
    private Customer customer;

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @JsonSerialize(using=JsonDateSerializerUtil.class)
    public Date getJobCompletionDate() {
        return jobCompletionDate;
    }

    public void setJobCompletionDate(Date jobCompletionDate) {
        this.jobCompletionDate = jobCompletionDate;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public BigDecimal getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @JsonSerialize(using=JsonDateSerializerUtil.class)
    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    @JsonSerialize(using=JsonDateSerializerUtil.class)
    public Date getJobReceivedDate() {
        return jobReceivedDate;
    }

    public void setJobReceivedDate(Date jobReceivedDate) {
        this.jobReceivedDate = jobReceivedDate;
    }

    @JsonSerialize(using=JsonDateSerializerUtil.class)
    public Date getJobEstimatedDate() {
        return jobEstimatedDate;
    }

    public void setJobEstimatedDate(Date jobEstimatedDate) {
        this.jobEstimatedDate = jobEstimatedDate;
    }

    public BigDecimal getTotalEstimatedAmount() {
        return totalEstimatedAmount;
    }

    public void setTotalEstimatedAmount(BigDecimal totalEstimatedAmount) {
        this.totalEstimatedAmount = totalEstimatedAmount;
    }

    @Override
    public String toString() {
        return ("JOB_ID = " + this.getJobId() + " : JOB_TYPE = " + this.getJobType() + " : JOB_RECEIVED_DATE = " + this.getJobReceivedDate() + " : JOB_ESTIMATED_DATE = " +
                this.getJobEstimatedDate() + " : JOB_COMPLETION_DATE = " + this.getJobCompletionDate() + " : ENGINEER_NAME = " + this.getEngineerName() + " : TOTAL_ESTIMATED_TIME = " +
                this.getTotalEstimatedAmount() + " : TOTAL_PAYMENT_AMOUNT = " + this.getTotalPaymentAmount() + " : PAYMENT_DUE_DATE = " +
                this.getPaymentDueDate() + " : JOB_STATUS = " + this.getJobStatus());
    }
}
