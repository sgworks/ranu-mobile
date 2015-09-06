package com.sgworks.mobile.model;

import javax.persistence.*;

@Entity
@Table(name = "DEFECT_FIX_DETAILS")
public class DefectFixDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEFECT_FIX_ID", nullable = false)
    private int defectFixId;

    @Column(name = "DEFECT_LIST")
    private String defectList;

    @Column(name = "DEFECT_DESCRIPTION")
    private String defectDescription;

    @Column(name = "FIX_ACTION_TAKEN")
    private String fixActionTaken;

    @Column(name = "FIX_ACTION_REASON")
    private String fixActionReason;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID_FK")
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getDefectFixId() {
        return defectFixId;
    }

    public void setDefectFixId(int defectFixId) {
        this.defectFixId = defectFixId;
    }

    public String getDefectList() {
        return defectList;
    }

    public void setDefectList(String defectList) {
        this.defectList = defectList;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public String getFixActionTaken() {
        return fixActionTaken;
    }

    public void setFixActionTaken(String fixActionTaken) {
        this.fixActionTaken = fixActionTaken;
    }

    public String getFixActionReason() {
        return fixActionReason;
    }

    public void setFixActionReason(String fixActionReason) {
        this.fixActionReason = fixActionReason;
    }

    @Override
    public String toString() {
        return ("DEFECT_FIX_ID = " + this.getDefectFixId() + " : DEFECT_LIST = " + this.getDefectList() +
                " : DEFECT_DESCRIPTION = " + this.getDefectDescription() + " : FIX_ACTION_TAKEN = " + this.getFixActionTaken() +
                " : FIX_ACTION_REASON = " + this.getFixActionReason());
    }
}
