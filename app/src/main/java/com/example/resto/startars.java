package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class startars extends AppCompatActivity {
    static int veg_crispy;
    static int chicken_crispy;
    static int paneer_chilly;
    static int masala_papad;
    static int veg_soup;
    static int startars_total;
    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startars);
        total_cal();
        orders_list_init();

    }

    public void veg_crispy_inc(View view) {
        veg_crispy = inc(veg_crispy);
        TextView tv = (TextView) findViewById(R.id.veg_crispy_order);
        tv.setText("" + veg_crispy);
        total_cal();
    }

    public void veg_crispy_dec(View view) {
        if (veg_crispy >= 0) {
            veg_crispy = dec(veg_crispy);
            TextView tv = (TextView) findViewById(R.id.veg_crispy_order);
            if (veg_crispy > 0) tv.setText("" + veg_crispy);
            else tv.setText("__");
            total_cal();
        }
    }

    public void chicken_crispy_inc(View view) {
        chicken_crispy = inc(chicken_crispy);
        TextView tv = (TextView) findViewById(R.id.chicken_crispy_order);
        tv.setText("" + chicken_crispy);
        total_cal();
    }

    public void chicken_crispy_dec(View view) {
        if (chicken_crispy >= 0) {
            chicken_crispy = dec(chicken_crispy);
            TextView tv = (TextView) findViewById(R.id.chicken_crispy_order);
            if (chicken_crispy > 0) tv.setText("" + chicken_crispy);
            else tv.setText("__");
            total_cal();
        }
    }

    public void paneer_chilly_inc(View view) {
        paneer_chilly = inc(paneer_chilly);
        TextView tv = (TextView) findViewById(R.id.paneer_chilly_order);
        tv.setText("" + paneer_chilly);
        total_cal();
    }

    public void paneer_chilly_dec(View view) {
        if (paneer_chilly >= 0) {
            paneer_chilly = dec(paneer_chilly);
            TextView tv = (TextView) findViewById(R.id.paneer_chilly_order);
            if (paneer_chilly > 0) tv.setText("" + paneer_chilly);
            else tv.setText("__");
            total_cal();
        }
    }
    public void masala_papad_inc(View view) {
        masala_papad = inc(masala_papad);
        TextView tv = (TextView) findViewById(R.id.masala_papad_order);
        tv.setText("" + masala_papad);
        total_cal();
    }

    public void masala_papad_dec(View view) {
        if (masala_papad >= 0) {
            masala_papad = dec(masala_papad);
            TextView tv = (TextView) findViewById(R.id.masala_papad_order);
            if (masala_papad > 0) tv.setText("" + masala_papad);
            else tv.setText("__");
            total_cal();
        }
    }
    public void veg_soup_inc(View view) {
        veg_soup = inc(veg_soup);
        TextView tv = (TextView) findViewById(R.id.veg_soup_order);
        tv.setText("" + veg_soup);
        total_cal();
    }

    public void veg_soup_dec(View view) {
        if (veg_soup >= 0) {
            veg_soup = dec(veg_soup);
            TextView tv = (TextView) findViewById(R.id.veg_soup_order);
            if (veg_soup > 0) tv.setText("" + veg_soup);
            else tv.setText("__");
            total_cal();

        }
    }

    //onclick to main menu button
    public void main_menu(View view)
    {
        Intent i = new Intent(startars.this,Menu.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }
    public void total_cal()
    {
        startars_total=veg_crispy*(150)+chicken_crispy*(170)+paneer_chilly*(120)+masala_papad*(30)+veg_soup*(80);
        recipt.all_total=startars.startars_total+veg.total_veg+nonveg.n_veg_total+desserts.dessert_total;

        if (recipt.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.starters_tot_id);
            tv.setText(""+"₹"+(recipt.all_total));
        }
        else
        {
            TextView tv = (TextView) findViewById(R.id.starters_tot_id);
            tv.setText("");

        }

        orders_list_init();
    }

    public int dec(int x) {
        if (x > 0) {
            x--;
            return x;
        } else return 0;
    }

    public int inc(int x) {
        x++;
        return (x);
    }

    public void orders_list_init() {
        if (veg_crispy > 0) {
            TextView tv = (TextView) findViewById(R.id.veg_crispy_order);
            tv.setText("" + veg_crispy);
        }
        if (chicken_crispy > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_crispy_order);
            tv.setText("" + chicken_crispy);
        }

        if (paneer_chilly > 0) {
            TextView tv = (TextView) findViewById(R.id.paneer_chilly_order);
            tv.setText("" + paneer_chilly);
        }

        if (masala_papad > 0) {
            TextView tv = (TextView) findViewById(R.id.masala_papad_order);
            tv.setText("" + masala_papad);
        }


        if (veg_soup > 0) {
            TextView tv = (TextView) findViewById(R.id.veg_soup_order);
            tv.setText("" + veg_soup);
        }
    }
    public void fin_ord(View view)
    {
        final Object o= this;
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


