package com.sgworks.mobile.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "JOB")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_ID", nullable = false)
    private int jobId;

    @Column(name = "JOB_TYPE")
    private String jobType;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOB_DATE")
    private Date jobDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "JOB_COMPLETION_DATE")
    private Date jobCompletionDate;

    @Column(name = "ENGINEER_NAME")
    private String engineerName;

    @Column(name = "JOB_ACTION_TAKEN")
    private String jobActionTaken;

    @Column(name = "JOB_ACTION_REASON")
    private String jobActionReason;

    @Column(name = "TOTAL_PAYMENT_AMOUNT")
    private double totalPaymentAmount;

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

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

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

    public String getJobActionTaken() {

        return jobActionTaken;
    }

    public void setJobActionTaken(String jobActionTaken) {
        this.jobActionTaken = jobActionTaken;
    }

    public String getJobActionReason() {
        return jobActionReason;
    }

    public void setJobActionReason(String jobActionReason) {
        this.jobActionReason = jobActionReason;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    @Override
    public String toString() {
        return ("JOB_ID = " + this.getJobId() + " : JOB_TYPE = " + this.getJobType() + " : JOB_DATE = " + this.getJobDate() + " : JOB_DESCRIPTION = " +
                this.getJobDescription() + " : JOB_COMPLETION_DATE = " + this.getJobCompletionDate() + " : ENGINEER_NAME = " + this.getEngineerName() + " : JOB_ACTION_TAKEN = " +
                this.getJobActionTaken() + " : JOB_ACTION_REASON = " + this.getJobActionReason() + " : TOTAL_PAYMENT_AMOUNT = " + this.getTotalPaymentAmount() + " : PAYMENT_DUE_DATE = " +
                this.getPaymentDueDate() + " : JOB_STATUS = " + this.getJobStatus());
    }
}
