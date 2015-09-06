package com.sgworks.mobile.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sgworks.mobile.util.JsonDateSerializerUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonAutoDetect
@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAYMENT_ID", nullable = false)
    private int paymentId;

    @Column(name = "AMOUNT_TYPE")
    private String amountType;

    @Column(name = "AMOUNT_PAID", columnDefinition = "Decimal(10,2)")
    private BigDecimal amountPaid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "JOB_ID_FK")
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    @JsonSerialize(using=JsonDateSerializerUtil.class)
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return ("PAYMENT_ID = " + this.getPaymentId()  + " : AMOUNT_TYPE = " + this.getAmountType() +
                " : AMOUNT_PAID = " + this.getAmountPaid() +
                " : PAYMENT_DATE = " + this.getPaymentDate());
    }
}
