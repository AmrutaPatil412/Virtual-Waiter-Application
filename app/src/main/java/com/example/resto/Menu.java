package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    static int new_ord_flag=0;
    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recipt.all_total=startars.startars_total+veg.total_veg+nonveg.n_veg_total+desserts.dessert_total;
        TextView tv = (TextView) findViewById(R.id.total_on_mm);
        if(recipt.all_total >0){
            tv.setText(""+"₹" + recipt.all_total);}
    }

    public void start(View v) {
        Intent i = new Intent(this, startars.class);
        startActivity(i);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        }

    public void veg(View v) {
        Intent i = new Intent(this, veg.class);
        startActivity(i);
        overridePendingTransition(R.anim.right_left, R.anim.left_right);
    }

    public void non_veg(View v) {
        Intent i = new Intent(this, nonveg.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

    }

    public void dessert(View v) {
        Intent i = new Intent(this, desserts.class);
        startActivity(i);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

    }

    public void fin_ord(View v){
        final Object o = this;
        if(recipt.all_total>0){
            Intent i =new Intent(Menu.this,recipt.class);
            startActivity(i);
            overridePendingTransition(R.anim.fadin, R.anim.fadout);

        }

            else{
                Toast.makeText(getApplicationContext(),
                        "Please select your order", Toast.LENGTH_SHORT).show();
            }

        }
        }




