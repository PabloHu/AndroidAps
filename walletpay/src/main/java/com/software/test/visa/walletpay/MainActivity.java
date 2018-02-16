package com.software.test.visa.walletpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.software.test.visa.walletpay.model.CreditCardEncryption;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/* //test passing parcellable
        CreditCardEncryption creditCardEncryption = new CreditCardEncryption();
        creditCardEncryption.setEncryptedPAN(1234567890123456l);
        Intent myIntent = new Intent(this, Main2Activity.class);
        myIntent.putExtra("key", creditCardEncryption); //Optional parameters
        this.startActivity(myIntent);
        */
    }
}
