package com.example.resto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class recipt extends AppCompatActivity {
    recipt a=this;
    public static Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);
        show_Order();
        tot_v();
        oo=this;

    }
    public void show_Order() {
        if (desserts.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "chocolate ice cream-" + String.valueOf(desserts.chocolate_ice_cream) + ",";
        }
        if (desserts.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "vannila ice cream-" + String.valueOf(desserts.vanilla_ice_cream) + ",";
        }

        if (desserts.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "strawberry ice cream-" + String.valueOf(desserts.strawberry_ice_cream) + ",";
        }
        if (desserts.falooda > 0) {
            fin_order_string = fin_order_string + "falooda-" + String.valueOf(desserts.falooda) + ",";
        }
        if (desserts.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "brownie fudge-" + String.valueOf(desserts.brownie_fudge) + ",";
        }
        if (nonveg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "chicken burger-" + String.valueOf(nonveg.chicken_burger) + ",";
        }
        if (nonveg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "chicken bbq pizza-" + String.valueOf(nonveg.chicken_bbq_pizza) + ",";
        }
        if (nonveg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "chicken tikka-" + String.valueOf(nonveg.chicken_tikka) + ",";
        }
        if (nonveg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "fried fish rice-" + String.valueOf(nonveg.fried_fish_rice) + ",";
        }
        if (nonveg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "kolhapur chicken-" + String.valueOf(nonveg.kolhapuri_chicken) + ",";
        }
        if (veg.roti > 0) {
            fin_order_string = fin_order_string + "roti-" + String.valueOf(veg.roti) + ",";
        }
        if (veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "butter roti-" + String.valueOf(veg.butter_roti) + ",";
        }
        if (veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "paneer tikka-" + String.valueOf(veg.paneer_tikka) + ",";
        }

        if (veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "veg pulao-" + String.valueOf(veg.veg_pulao) + ",";
        }
        if (veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "mutter paneer-" + String.valueOf(veg.mutter_paneer) + ",";
        }

        if (startars.veg_crispy > 0) {
            fin_order_string = fin_order_string + "veg crispy-" + String.valueOf(startars.veg_crispy) + ",";
        }
        if (startars.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "chicken crispy-" + String.valueOf(startars.chicken_crispy) + ",";
        }
        if (startars.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "paneer chilly-" + String.valueOf(startars.paneer_chilly) + ",";
        }
        if (startars.masala_papad > 0) {
            fin_order_string = fin_order_string + "masala papad-" + String.valueOf(startars.masala_papad) + ",";
        }
        if (startars.veg_soup > 0) {
            fin_order_string = fin_order_string + "veg soup-" + String.valueOf(startars.veg_soup) + ",";
        }
        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

        public void main_menu(View view){
        Intent i = new Intent(recipt.this,Menu.class);
        startActivity(i);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "₹" +(recipt.all_total));
    }


    public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                //client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(recipt.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();

                bb.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
   public void send_ord(View v){
       Toast.makeText(recipt.this, "Your order is successfully accepted! serverd soon!!", Toast.LENGTH_SHORT).show();
   }

   public void exit(View v){
     this.finishAffinity();
   }

}
