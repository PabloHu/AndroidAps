package com.software.test.visa.walletpay.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kiwic on 2/15/2018.
 */

public class CreditCardEncryption implements Parcelable {
    long encryptedPAN;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.encryptedPAN);
    }

    public CreditCardEncryption() {
    }

    protected CreditCardEncryption(Parcel in) {
        this.encryptedPAN = in.readLong();
    }

    public static final Parcelable.Creator<CreditCardEncryption> CREATOR = new Parcelable.Creator<CreditCardEncryption>() {
        @Override
        public CreditCardEncryption createFromParcel(Parcel source) {
            return new CreditCardEncryption(source);
        }

        @Override
        public CreditCardEncryption[] newArray(int size) {
            return new CreditCardEncryption[size];
        }
    };

    public long getEncryptedPAN() {
        return encryptedPAN;
    }

    public void setEncryptedPAN(long encryptedPAN) {
        this.encryptedPAN = encryptedPAN;
    }
}
