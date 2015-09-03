package com.sgworks.mobile.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MOBILE_MODEL")
public class MobileModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOBILE_ID", nullable = false)
    private int mobileId;

    @Column(name = "MODEL_NAME")
    private String modelName;

    @Column(name = "IMEI_NUMBER")
    private String imeiNumber;

    @Column(name = "SIM")
    private String sim;

    @Column(name = "BATTERY")
    private String battery;

    @Column(name = "CHARGER")
    private String charger;

    @Column(name = "MMC")
    private String mmc;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID_FK")
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public String getMmc() {
        return mmc;
    }

    public void setMmc(String mmc) {
        this.mmc = mmc;
    }

    @Override
    public String toString() {
        return ("MOBILE_ID = " + this.getMobileId() + " : MODEL_NAME = " + this.getModelName() +
                " : IMEI_NUMBER = " + this.getImeiNumber() + " : SIM = " +
                this.getSim() + " : BATTERY = " + this.getBattery() + " : CHARGER = " + this.getCharger() +
                " : MMC = " + this.getMmc());
    }
}
