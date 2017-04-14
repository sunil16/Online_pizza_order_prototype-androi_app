package com.example.sajinur.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by sajinur on 14/3/16.
 */
public class VegActivity extends Activity
{
    CheckBox checkBox[]= new CheckBox[10];
    int price[] = {199, 199, 265, 230, 170, 170, 230, 109, 265, 230};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veg_layout);
        checkBox[0]= (CheckBox)findViewById(R.id.checkBox);
        checkBox[1]= (CheckBox)findViewById(R.id.checkBox2);
        checkBox[2]= (CheckBox)findViewById(R.id.checkBox3);
        checkBox[3]= (CheckBox)findViewById(R.id.checkBox4);
        checkBox[4]= (CheckBox)findViewById(R.id.checkBox5);
        checkBox[5]= (CheckBox)findViewById(R.id.checkBox6);
        checkBox[6]= (CheckBox)findViewById(R.id.checkBox7);
        checkBox[7]= (CheckBox)findViewById(R.id.checkBox8);
        checkBox[8]= (CheckBox)findViewById(R.id.checkBox9);
        checkBox[9]= (CheckBox)findViewById(R.id.checkBox10);
    }
    public void cancelPage(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }
    public void orderPizza(View v)
    {
        String va = "value";
        String n= "name";
        int c = 0;
        int total= 0;
        String name[] = {"Paneer overloaded : Peppy Paneer, Onion, Tomato, Green Chillies, Corn, Italian Sprinkle","Cheese overloaded : Cheese, Mozzarella Cheese","Veggie Supreme : Mushroom, capsicum, onion, tomato, baby corn and olives.","Country Feast : Sweet corn, mushroom, tomato, onion and capsicum","Simply Veg : Tomato and onion","Exotica : Red capsicum, baby corn, capsicum, olives and jalapenos.","Tandoori Paneer : Paneer, onion, capsicum, red paprika and tomato.","Kurkure Pizza : Onion, Tomato, Jalapenos, Kurkure","Fiery Ride : Tomato, Onion, Capsicum, Sweet Corn , Olives , Jalapenos and Green Chillies","Panner Makhani : Paneer, capsicum, onion, and red paprika."};
        Intent in = new Intent(this, OrderedActivity.class);
        for (int i=0; i<checkBox.length; i++)
        {
               if(checkBox[i].isChecked())
               {
                   total += price[i];
                   in.putExtra(va+c, price[i]);
                   in.putExtra(n+c, name[i]);
                   c++;
               }
        }
        in.putExtra("total", total);
        in.putExtra("count", c);
        startActivity(in);
    }
}
