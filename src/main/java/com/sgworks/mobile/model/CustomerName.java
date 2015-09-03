package com.sgworks.mobile.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerName {

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return ("FIRST_NAME = " + this.getFirstName() + " : MIDDLE_NAME = " + this.getMiddleName() +
                " : LAST_NAME = " + this.getLastName());
    }
}
