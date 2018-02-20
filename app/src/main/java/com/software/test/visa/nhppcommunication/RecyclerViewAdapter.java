package com.software.test.visa.nhppcommunication;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.software.test.visa.nhppcommunication.model.CreditCard;
import com.software.test.visa.nhppcommunication.model.CreditCardEncryption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiwic on 2/15/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "RecyclerViewAdapter";
    List<CreditCard> creditCardList = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(Context context, List<CreditCard> creditCardList) {
        this.context = context;
        this.creditCardList = creditCardList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCardHolderName;
        private CardView cvCreditCard;


        public ViewHolder(View itemView) {
            super(itemView);
            tvCardHolderName = itemView.findViewById(R.id.tvCardHolderName);
            cvCreditCard = itemView.findViewById(R.id.cvCreditCard);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rv_creditcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder position: " + position);
        CreditCard creditCard = creditCardList.get(position);

        holder.cvCreditCard.setId(creditCard.getId());
        holder.tvCardHolderName.setText(creditCard.getCustomerName());

        holder.cvCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Work to get token
                long encryption = 1234567890123456l;
                customPopup(encryption);
                Toast.makeText(context, "Credit Wallet ID: " + holder.cvCreditCard.getId(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        //    Log.d(TAG, "getItemCount: "+ personList.size());
        return creditCardList.size();
    }


    public void customPopup(final long encryption) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_pop_up);
        dialog.setTitle("Title...");


        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Android custom dialog example!");
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        // image.setImageResource(R.drawable.boa_icon);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

/*
                //1st way
                Bundle bundle = new Bundle();
                bundle.putLong("key", encryption);
                Intent launchWalletPay = new Intent("com.software.test.visa.walletpay.Main2Activity");
                launchWalletPay.putExtras(bundle);
                if (launchWalletPay != null) {
                    context.startActivity(launchWalletPay);
                }
*/

//mponday
                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);

               i.setAction("com.software.test.visa.walletpay.Main2Activity");

                i.setData(Uri.parse("http://www.amazon.com"));
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.setType("text/plain");


                context.startActivity(i);

/*
//testing no luck yet
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setData(Uri.parse("54321"));
                sendIntent.putExtra("key","12344");
                sendIntent.setType("text/plain");
               context.startActivity(sendIntent);

*/
                /*
                //monday 2
                String uriText =
                        "mailto:youremail@gmail.com" +
                                "?subject=" + Uri.encode("some subject text here") +
                                "&body=" + Uri.encode("some text here");

                Uri uri = Uri.parse(uriText);

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                //sendIntent.setData(uri);
                sendIntent.setData(Uri.parse("mailto:youremail@gmail.com?subject=kiwichito"));
                sendIntent.addCategory(Intent.CATEGORY_DEFAULT);

                context.startActivity(Intent.createChooser(sendIntent, "Send email"));
*/
      /*
                //second way
                CreditCardEncryption creditCardToken1 = new CreditCardEncryption();
                creditCardToken1.setEncryptedPAN(encryption);

                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("key", creditCardToken1);
                Intent launchWalletPay1 = new Intent("com.software.test.visa.walletpay.Main2Activity");
                launchWalletPay1.putExtras(bundle1);
                if (launchWalletPay1 != null) {
                    context.startActivity(launchWalletPay1);
                }
*/

                // My way



/*
                //third
                CreditCardEncryption creditCardTokenS = new CreditCardEncryption();
                creditCardTokenS.setEncryptedPAN(encryption);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("key",creditCardTokenS);
                Intent launchWalletPay1 = new Intent("com.software.test.visa.walletpay.Main2Activity");
                launchWalletPay1.putExtras( bundle1);
                if (launchWalletPay1 != null) {
                    context.startActivity(launchWalletPay1);
                }
*/
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
