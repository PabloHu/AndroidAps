package com.software.test.visa.walletpay.model;

import java.io.Serializable;

/**
 * Created by kiwic on 2/15/2018.
 */

public class CreditCardEncryptionS implements Serializable {
    long token;

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }
}
