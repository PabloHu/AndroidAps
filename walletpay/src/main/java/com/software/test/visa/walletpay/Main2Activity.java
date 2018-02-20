package com.software.test.visa.walletpay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.software.test.visa.walletpay.model.CreditCardEncryption;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    TextView tvCreditCardToken;
    private static final String TAG = "Main2ActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvCreditCardToken = (TextView) findViewById(R.id.tvCreditCardToken);

        Uri data = this.getIntent().getData();
      //  Uri uri = getIntent().getData();
        WebView webView = (WebView) findViewById(R.id.WebView01);
        webView.setWebViewClient(new Callback());
        try {
            Log.d(TAG, "onCreate: " + data.toString());
        }catch (Exception e) {
            Log.d(TAG, "onCreate: " + e.toString());
        }
//        webView.loadUrl(url.toString());

        //handle incoming
        incoming();
/*
        //first
        Long encryption = null;
        Bundle bundle1 = getIntent().getExtras();
        if(bundle1 != null) {
            encryption= bundle1.getLong("key");
            Log.d(TAG, "onCreate: "+encryption);
        }
        //work encryption to token
        long token = encryption;
        tvCreditCardToken.setText(""+token);

       */

//Intent intent = getIntent();
  //      Uri uri = intent.getData();
  //      String a = uri.getQuery();///.getQueryParameter("key");
        //second way
        CreditCardEncryption creditCardToken = getIntent().getParcelableExtra("key");
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }
    }
    private void incoming() {
        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(action.equals(Intent.ACTION_SEND)){
            //content is being shared
           // Toast.makeText(this, "ACTIONSEND", Toast.LENGTH_SHORT).show();
        }
        if(type.startsWith("text/")){
            //handle sent text
           // Toast.makeText(this, "text!!!", Toast.LENGTH_SHORT).show();

        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
// get data via the key
        String value1 = extras.getString("key");

        //-------
      //  Uri uri1 = getIntent().getData();
       // uri1.toString();

        if (value1 != null) {
            // do something with the data
            Toast.makeText(this, "receivedText"+value1, Toast.LENGTH_SHORT).show();
        }
        String receivedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        //check we have a string
        if (receivedText != null)
            Toast.makeText(this, "receivedText", Toast.LENGTH_SHORT).show();

            if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            } else if (type.startsWith("image/")) {
                handleSendImage(intent); // Handle single image being sent
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                handleSendMultipleImages(intent); // Handle multiple images being sent
            }
        } else {
            // Handle other intents, such as being started from the home screen
        }
    }


    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            Toast.makeText(this, "got something", Toast.LENGTH_SHORT).show();
            // Update UI to reflect text being shared
        }


    }

    void handleSendImage(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            // Update UI to reflect image being shared
            Toast.makeText(this, "got something", Toast.LENGTH_SHORT).show();
        }
    }

    void handleSendMultipleImages(Intent intent) {
        ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if (imageUris != null) {
            Toast.makeText(this, "got something", Toast.LENGTH_SHORT).show();
            // Update UI to reflect multiple images being shared
        }
    }
}
