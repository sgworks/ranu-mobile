package com.sgworks.mobile.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "JOB")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="JOB_ID", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID_FK")
    private Customer customer;

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
}
