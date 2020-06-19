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

public class veg extends AppCompatActivity {
    static int roti;
    static int butter_roti;
    static int paneer_tikka;
    static int veg_pulao;
    static int mutter_paneer;
    static int total_veg;
    static String order_veg;
    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);
        total_cal();
        orders_list_init();
    }

    public void roti_inc(View view){
        roti=inc(roti);
        TextView tv = (TextView) findViewById(R.id.roti_order);
        tv.setText("" + roti);
        total_cal();
    }
    public void roti_dec(View view) {
        if (roti>= 0) {
            roti= dec(roti);
            TextView tv = (TextView) findViewById(R.id.roti_order);
            if(roti>0) tv.setText("" + roti);
            else tv.setText("__");
            total_cal();
        }
    }


    public void butter_roti_inc(View view){
        butter_roti=inc(butter_roti);
        TextView tv = (TextView) findViewById(R.id.butter_roti_order);
        tv.setText("" + butter_roti);
        total_cal();
    }
    public void butter_roti_dec(View view) {
        if (butter_roti>= 0) {
            butter_roti= dec(butter_roti);
            TextView tv = (TextView) findViewById(R.id.butter_roti_order);
            if(butter_roti>0) tv.setText("" + butter_roti);
            else tv.setText("__");

            total_cal();
        }
    }


    public void paneer_tikka_inc(View view){
        paneer_tikka=inc(paneer_tikka);
        TextView tv = (TextView) findViewById(R.id.paneer_tikka_order);
        tv.setText("" + paneer_tikka);
        total_cal();
    }
    public void paneer_tikka_dec(View view) {
        if (paneer_tikka>= 0) {
            paneer_tikka= dec(paneer_tikka);
            TextView tv = (TextView) findViewById(R.id.paneer_tikka_order);
            if(paneer_tikka>0) tv.setText("" + paneer_tikka);
            else tv.setText("__");

            total_cal();
        }
    }

    public void veg_pulao_inc(View view){
        veg_pulao=inc(veg_pulao);
        TextView tv = (TextView) findViewById(R.id.veg_pulao_order);
        tv.setText("" + veg_pulao);
        total_cal();
    }
    public void veg_pulao_dec(View view) {
        if (veg_pulao>= 0) {
            veg_pulao= dec(veg_pulao);
            TextView tv = (TextView) findViewById(R.id.veg_pulao_order);
            if(veg_pulao>0) tv.setText("" + veg_pulao);
            else tv.setText("__");

            total_cal();
        }
    }

    public void mutter_paneer_inc(View view){
        mutter_paneer=inc(mutter_paneer);
        TextView tv = (TextView) findViewById(R.id.mutter_paneer_order);
        tv.setText("" + mutter_paneer);

        total_cal();
    }
    public void mutter_paneer_dec(View view) {
        if (mutter_paneer>= 0) {
            mutter_paneer= dec(mutter_paneer);
            TextView tv = (TextView) findViewById(R.id.mutter_paneer_order);
            if(mutter_paneer>0) tv.setText("" + mutter_paneer);
            else tv.setText("__");

            total_cal();
        }
    }

    //onclick to main menu button
    public void main_menu(View view)
    {
        Intent i = new Intent(veg.this,Menu.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }
    public void total_cal()
    {
        total_veg=roti*(20)+butter_roti*(25)+paneer_tikka*(180)+veg_pulao*(200)+mutter_paneer*(200);
        recipt.all_total=startars.startars_total+veg.total_veg+nonveg.n_veg_total+desserts.dessert_total;

        if (recipt.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.veg_total_id);
            tv.setText(""+"₹"+(recipt.all_total));
        }
        else
        {
            TextView tv = (TextView) findViewById(R.id.veg_total_id);
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
        if (roti > 0) {
            TextView tv = (TextView) findViewById(R.id.roti_order);
            tv.setText("" + roti);
        }
        if (butter_roti > 0) {
            TextView tv = (TextView) findViewById(R.id.butter_roti_order);
            tv.setText("" + butter_roti);
        }

        if (paneer_tikka > 0) {
            TextView tv = (TextView) findViewById(R.id.paneer_tikka_order);
            tv.setText("" + paneer_tikka);
        }
        if (veg_pulao > 0) {
            TextView tv = (TextView) findViewById(R.id.veg_pulao_order);
            tv.setText("" + veg_pulao);
        }
        if (mutter_paneer > 0) {
            TextView tv = (TextView) findViewById(R.id.mutter_paneer_order);
            tv.setText("" + mutter_paneer);
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


