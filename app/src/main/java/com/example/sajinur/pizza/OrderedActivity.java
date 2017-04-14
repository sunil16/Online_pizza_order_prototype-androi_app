package com.example.sajinur.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sajinur on 14/3/16.
 */
public class OrderedActivity extends Activity
{
    TextView name, total;
    int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordered_layout);
        name = (TextView)findViewById(R.id.textView);
        total=(TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        int i = b.getInt("count");
        for (int k=0; k<i;k++)
        {
            String nm = b.getString("name"+k);
            int p = b.getInt("value" + k);
            name.append("\n"+nm);
            name.append("\n"+"Price : "+p);
            name.append("\n");
        }
        t= b.getInt("total");
        total.setText("Total  :  "+t);
    }
    public void payClick(View v)
    {
        Intent i = new Intent(this, PayActivity.class);
        i.putExtra("total", t);
        startActivity(i);
    }
}
