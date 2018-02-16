package com.software.test.visa.nhppcommunication.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kiwic on 2/15/2018.
 */

public class CreditCard {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id;
    long number;
    String customerName;
    int expirationDay;
    int expirationMonth;
    int CVCNumber;

    public CreditCard(long number, String customerName, int expirationDay, int expirationMonth, int CVCNumber) {
        this.number = number;
        this.customerName = customerName;
        this.expirationDay = expirationDay;
        this.expirationMonth = expirationMonth;
        this.CVCNumber = CVCNumber;
        id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCVCNumber() {
        return CVCNumber;
    }

    public void setCVCNumber(int CVCNumber) {
        this.CVCNumber = CVCNumber;
    }
}
