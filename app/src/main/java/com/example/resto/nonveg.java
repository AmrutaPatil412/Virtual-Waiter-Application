package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class nonveg extends AppCompatActivity {
    static int chicken_burger;
    static int chicken_bbq_pizza;
    static int chicken_tikka;
    static int fried_fish_rice;
    static int kolhapuri_chicken;
    static int n_veg_total;

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonveg);
        total_cal();
        orders_list_init();
    }


    public void chicken_bbq_pizza_inc(View view){
        chicken_bbq_pizza=inc(chicken_bbq_pizza);
        TextView tv = (TextView) findViewById(R.id.chicken_BBQ_pizza_order);
        tv.setText("" + chicken_bbq_pizza);
        total_cal();
    }
    public void chicken_bbq_pizza_dec(View view) {
        if (chicken_bbq_pizza >= 0) {
            chicken_bbq_pizza= dec(chicken_bbq_pizza);
            TextView tv = (TextView) findViewById(R.id.chicken_BBQ_pizza_order);
            if(chicken_bbq_pizza>0) tv.setText("" + chicken_bbq_pizza);
            else tv.setText("__");
            total_cal();

        }
    }

    public void chicken_burger_inc(View view){
        chicken_burger=inc(chicken_burger);
        TextView tv = (TextView) findViewById(R.id.chickburger_order);
        tv.setText("" + chicken_burger);
        total_cal();
    }
    public void chicken_burger_dec(View view) {
        if (chicken_burger >= 0) {
            chicken_burger = dec(chicken_burger);
            TextView tv = (TextView) findViewById(R.id.chickburger_order);
            if(chicken_burger>0) tv.setText("" + chicken_burger);
            else tv.setText("__");
            total_cal();
        }
    }


    public void chicken_tikka_inc(View view){
        chicken_tikka=inc(chicken_tikka);
        TextView tv = (TextView) findViewById(R.id.chicken_tikka_order);
        tv.setText("" + chicken_tikka);
        total_cal();
    }
    public void chicken_tikka_dec(View view) {
        if (chicken_tikka>= 0) {
            chicken_tikka = dec(chicken_tikka);
            TextView tv = (TextView) findViewById(R.id.chicken_tikka_order);
            if(chicken_tikka>0) tv.setText("" + chicken_tikka);
            else tv.setText("__");
            total_cal();
        }
    }

    public void fried_fish_rice_inc(View view){
        fried_fish_rice=inc(fried_fish_rice);
        TextView tv = (TextView) findViewById(R.id.fried_fish_rice_order);
        tv.setText("" + fried_fish_rice);
        total_cal();
    }
    public void fried_fish_rice_dec(View view) {
        if (fried_fish_rice>= 0) {
            fried_fish_rice= dec(fried_fish_rice);
            TextView tv = (TextView) findViewById(R.id.fried_fish_rice_order);
            if(fried_fish_rice>0) tv.setText("" + fried_fish_rice);
            else tv.setText("__");
            total_cal();
        }
    }
    public void kolhapuri_chicken_inc(View view){
        kolhapuri_chicken=inc(kolhapuri_chicken);
        TextView tv = (TextView) findViewById(R.id.kolhapuri_chicken_order);
        tv.setText("" + kolhapuri_chicken);
        total_cal();
    }
    public void kolhapuri_chicken_dec(View view) {
        if (kolhapuri_chicken>= 0) {
            kolhapuri_chicken= dec(kolhapuri_chicken);
            TextView tv = (TextView) findViewById(R.id.kolhapuri_chicken_order);
            if(kolhapuri_chicken>0) tv.setText("" + kolhapuri_chicken);
            else tv.setText("__");
            total_cal();
        }
    }

    //onclick to main menu button
    public void main_menu(View view)
    {
        Intent i = new Intent(nonveg.this,Menu.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void total_cal()
    {
        n_veg_total = chicken_burger * (120) + chicken_bbq_pizza * (200) + chicken_tikka * (300) + fried_fish_rice * (250) + kolhapuri_chicken * (120);
        recipt.all_total=startars.startars_total+veg.total_veg+nonveg.n_veg_total+desserts.dessert_total;

        if (recipt.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText(""+"₹"+(recipt.all_total));
        }
        else
        {
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
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

        if (chicken_burger > 0) {
            TextView tv = (TextView) findViewById(R.id.chickburger_order);
            tv.setText("" + chicken_burger);
        }

        if (chicken_bbq_pizza > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_BBQ_pizza_order);
            tv.setText("" + chicken_bbq_pizza);
        }
        if (chicken_tikka > 0) {
            TextView tv = (TextView) findViewById(R.id.chickburger_order);
            tv.setText("" + chicken_tikka);
        }
        if (fried_fish_rice > 0) {
            TextView tv = (TextView) findViewById(R.id.fried_fish_rice_order);
            tv.setText("" + fried_fish_rice);
        }


        if (kolhapuri_chicken > 0) {
            TextView tv = (TextView) findViewById(R.id.kolhapuri_chicken_order);
            tv.setText("" + kolhapuri_chicken);
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



