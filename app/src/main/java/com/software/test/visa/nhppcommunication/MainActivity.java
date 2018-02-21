package com.software.test.visa.nhppcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.software.test.visa.nhppcommunication.model.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag" ;

    RecyclerView rvPersonList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<CreditCard> creditCardList = new ArrayList<>();
        CreditCard creditCard = new CreditCard(
                 "Bank of America",1234567890123456l, "piru", 01,19,123);
        creditCardList.add(creditCard);
        creditCard = null;

        creditCard = new CreditCard(
                "Chase", 1234567890123456L, "champis", 01,19,123);
        creditCardList.add(creditCard);
        creditCard = null;

        creditCard = new CreditCard(
                "Wells Fargo", 1234567890123456L, "toby", 01,19,123);
        creditCardList.add(creditCard);
        creditCard = null;


        for (int i = 0; i <  creditCardList.size(); i++) {
            Log.d(TAG, "onCreate: "+ creditCardList.get(i).getCustomerName());
        }

        rvPersonList = (RecyclerView) findViewById(R.id.rvCardList);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, creditCardList);
        rvPersonList.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvPersonList.setLayoutManager(layoutManager);
        rvPersonList.setItemAnimator(itemAnimator);
    }
}
