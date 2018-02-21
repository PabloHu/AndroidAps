package com.software.test.visa.nhppcommunication.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kiwic on 2/15/2018.
 */

public class CreditCard {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id;
    String bankname;
    long number;
    String customerName;
    int expirationMonth;
    int expirationYear;
    int CVCNumber;

    public CreditCard(String bankname, long number, String customerName, int expirationMonth, int expirationYear, int CVCNumber) {
        this.bankname = bankname;
        this.number = number;
        this.customerName = customerName;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.CVCNumber = CVCNumber;
        id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getCVCNumber() {
        return CVCNumber;
    }

    public void setCVCNumber(int CVCNumber) {
        this.CVCNumber = CVCNumber;
    }
}
