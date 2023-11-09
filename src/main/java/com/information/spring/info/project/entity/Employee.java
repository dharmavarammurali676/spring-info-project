package com.information.spring.info.project.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String employeeFullName;
    private String employeeEmail;
    private String employeePhoneNumber;
    private String employeePosition;
    private String employeeAddress;

    public Employee(long employeeId, String employeeFullName, String employeeEmail, String employeePhoneNumber, String employeePosition, String employeeAddress) {
        super();
        this.employeeId = employeeId;
        this.employeeFullName = employeeFullName;
        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeePosition = employeePosition;
        this.employeeAddress = employeeAddress;
    }

    public Employee() {
        super();
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeFullName='" + employeeFullName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                '}';
    }
}
