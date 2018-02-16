package com.software.test.visa.walletpay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvCreditCardToken;
    private static final String TAG = "Main2ActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvCreditCardToken = (TextView) findViewById(R.id.tvCreditCardToken);

        //first
        /*
Long passData = null;
Bundle bundle = getIntent().getExtras();
if(bundle != null)
    passData = bundle.getLong("key");

        Log.d(TAG, "onCreate: "+passData);
*/
        //second
        Long encryption = null;
        Bundle bundle1 = getIntent().getExtras();




        if(bundle1 != null) {
            encryption= bundle1.getLong("key");
            Log.d(TAG, "onCreate: "+encryption);
        }
        //work encryption to token
        long token = encryption;
        tvCreditCardToken.setText(""+token);
        // long token = getIntent().getExtras().getLong("key");
        // CreditCardEncryption creditCardToken =getIntent().getParcelableExtra("key");
    }
}
