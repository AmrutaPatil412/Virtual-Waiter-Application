package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class desserts extends AppCompatActivity {
    static int chocolate_ice_cream;
    static int vanilla_ice_cream;
    static int strawberry_ice_cream;
    static int falooda;
    static int brownie_fudge;
    static int dessert_total;
    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);
        total_cal();
        orders_list_init();
    }


    public void chocolate_ice_cream_inc(View view) {
        chocolate_ice_cream = inc(chocolate_ice_cream);
        TextView tv = (TextView) findViewById(R.id.choco_ice_cream_order);
        tv.setText("" + chocolate_ice_cream);
        total_cal();
    }

    public void chocolate_ice_cream_dec(View view) {
        if (chocolate_ice_cream >= 0) {
            chocolate_ice_cream = dec(chocolate_ice_cream);
            TextView tv = (TextView) findViewById(R.id.choco_ice_cream_order);
            if (chocolate_ice_cream > 0) tv.setText("" + chocolate_ice_cream);
            else tv.setText("__");
            total_cal();
        }
    }

    public void vanilla_ice_cream_inc(View view) {
        vanilla_ice_cream = inc(vanilla_ice_cream);
        TextView tv = (TextView) findViewById(R.id.vannila_ice_cream_order);
        tv.setText("" + vanilla_ice_cream);
        total_cal();
    }

    public void vanilla_ice_cream_dec(View view) {
        if (vanilla_ice_cream >= 0) {
            vanilla_ice_cream = dec(vanilla_ice_cream);
            TextView tv = (TextView) findViewById(R.id.vannila_ice_cream_order);
            if (vanilla_ice_cream > 0) tv.setText("" + vanilla_ice_cream);
            else tv.setText("__");
            total_cal();
        }

    }

    public void strawberry_ice_cream_inc(View view) {
        strawberry_ice_cream = inc(strawberry_ice_cream);
        TextView tv = (TextView) findViewById(R.id.Strawberry_ice_cream_order);
        tv.setText("" + strawberry_ice_cream);
        total_cal();
    }

    public void strawberry_ice_cream_dec(View view) {
        if (strawberry_ice_cream >= 0) {
            strawberry_ice_cream = dec(strawberry_ice_cream);
            TextView tv = (TextView) findViewById(R.id.Strawberry_ice_cream_order);
            if (strawberry_ice_cream > 0) tv.setText("" + strawberry_ice_cream);
            else tv.setText("__");
            total_cal();
        }

    }

    public void falooda_inc(View view) {
        falooda = inc(falooda);
        TextView tv = (TextView) findViewById(R.id.falooda_order);
        tv.setText("" + falooda);
        total_cal();
    }

    public void falooda_dec(View view) {
        if (falooda >= 0) {
            falooda = dec(falooda);
            TextView tv = (TextView) findViewById(R.id.falooda_order);
            if (falooda > 0) tv.setText("" + falooda);
            else tv.setText("__");
            total_cal();

        }

    }

    public void brownie_fudge_inc(View view) {
        brownie_fudge = inc(brownie_fudge);
        TextView tv = (TextView) findViewById(R.id.brownie_fudge_order);
        tv.setText("" + brownie_fudge);
        total_cal();
    }

    public void brownie_fudge_dec(View view) {
        if (brownie_fudge >= 0) {
            brownie_fudge = dec(brownie_fudge);
            TextView tv = (TextView) findViewById(R.id.brownie_fudge_order);
            if (brownie_fudge > 0) tv.setText("" + brownie_fudge);
            else tv.setText("__");
            total_cal();
        }

    }


    //onclick to main menu button
    public void main_menu(View view)
    {
        Intent i = new Intent(desserts.this,Menu.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void total_cal()
    {
        dessert_total = chocolate_ice_cream * (80) + vanilla_ice_cream * (70) + strawberry_ice_cream * (75) + falooda * (150) + brownie_fudge * (120);
        recipt.all_total=startars.startars_total+veg.total_veg+nonveg.n_veg_total+desserts.dessert_total;

        if (recipt.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.dessert_tot_id);
            tv.setText(""+"₹"+(recipt.all_total));
        }
        else
        {
            TextView tv = (TextView) findViewById(R.id.dessert_tot_id);
            tv.setText("");

        }

    }


    public int dec(int x) {
        if (x > 0) {
            x--;
            return x;
        }
        else return 0;
    }


    public int inc(int x)
    {
        x++;
        return (x);
    }



    public void orders_list_init() {


        if (chocolate_ice_cream > 0) {
            TextView tv = (TextView) findViewById(R.id.choco_ice_cream_order);
            tv.setText("" + chocolate_ice_cream);
        }
        if (vanilla_ice_cream > 0) {
            TextView tv = (TextView) findViewById(R.id.vannila_ice_cream_order);
            tv.setText("" + vanilla_ice_cream);
        }
        if (strawberry_ice_cream > 0) {
            TextView tv = (TextView) findViewById(R.id.Strawberry_ice_cream_order);
            tv.setText("" + strawberry_ice_cream);
        }

        if (falooda > 0) {
            TextView tv = (TextView) findViewById(R.id.falooda_order);
            tv.setText("" + falooda);
        }

        if (brownie_fudge > 0) {
            TextView tv = (TextView) findViewById(R.id.brownie_fudge_order);
            tv.setText("" + brownie_fudge);
        }

    }


    public void fin_ord(View view)
    {
        final Object o = this;
        if(recipt.all_total>0) {
            Intent fin = new Intent(this, recipt.class);
            startActivity(fin);
            overridePendingTransition(R.anim.fadin, R.anim.fadout);
        }
        else{
                Toast.makeText(getApplicationContext(),
                        "Please select your order", Toast.LENGTH_SHORT).show();
            }
        }
    }



