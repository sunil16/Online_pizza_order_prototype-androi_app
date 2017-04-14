package com.example.sajinur.pizza;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by sajinur on 15/3/16.
 */
public class PayActivity extends Activity
{
    TextView total, vat, st, gt;
    int totalCost;
    float vatCost, stCost, grandTotal;
    RadioGroup pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_layout);
        total = (TextView)findViewById(R.id.textView3);
        vat = (TextView)findViewById(R.id.textView4);
        st = (TextView)findViewById(R.id.textView5);
        gt = (TextView)findViewById(R.id.textView6);
        pay = (RadioGroup)findViewById(R.id.pay);
        Bundle b = getIntent().getExtras();
        totalCost = b.getInt("total");
        vatCost = (0.14f)*totalCost;
        stCost = (0.08f)*totalCost;
        grandTotal = totalCost + vatCost + stCost;
        total.append(" "+totalCost);
        vat.append(" "+vatCost);
        st.append(" "+stCost);
        gt.append(" "+grandTotal);
    }
    public void cost(View v)
    {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        int selected = pay.getCheckedRadioButtonId();
        RadioButton check= (RadioButton)findViewById(selected);
        switch (selected)
        {
            case R.id.card:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("Please provide card details");
                EditText et1 = new EditText(this);
                et1.setHint("Card No");
                ll.addView(et1);
                EditText et2 = new EditText(this);
                et2.setHint("CVV");
                ll.addView(et2);
                ad.setView(ll);
                ad.setCancelable(false);
                ad.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                ad.setPositiveButton("Pay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                ad.show();
                break;
            case R.id.online:
                AlertDialog.Builder ad2 = new AlertDialog.Builder(this);
                ad2.setTitle("Please provide Bank name");
                String bank[] = {"State Bank of India","Bank of Baroda","Allahabad Bank","Central Bank of India","Andhra Bank","Punjab National Bank","Canara Bank"};
                ad2.setCancelable(false);
                ad2.setSingleChoiceItems(bank, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://retail.onlinesbi.com/retail/login.htm"));
                                startActivity(i);
                                break;
                            case 1:
                                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bobibanking.com/"));
                                startActivity(i1);
                                break;
                            case 2:
                                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.allbankonline.in/"));
                                startActivity(i2);
                                break;
                            case 3:
                                Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.centralbankofindia.co.in/site/indexcbi.aspx"));
                                startActivity(i3);
                                break;
                            case 4:
                                Intent i4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.onlineandhrabank.net.in/"));
                                startActivity(i4);
                                break;
                            case 5:
                                Intent i5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netpnb.com/"));
                                startActivity(i5);
                                break;
                            case 6:
                                Intent i6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.canarabank.in/"));
                                startActivity(i6);
                                break;
                        }
                    }
                });
                ad2.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                ad2.show();
                break;
            case R.id.cod:
                AlertDialog.Builder ad3 = new AlertDialog.Builder(this);
                ad3.setIcon(R.drawable.alert);
                ad3.setTitle("Please note");
                ad3.setMessage("For COD charge Rs. 50/- extra");
                ad3.setCancelable(false);
                ad3.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                ad3.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ad3.show();
        }
    }
}
