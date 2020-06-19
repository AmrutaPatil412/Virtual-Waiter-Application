package com.example.resto;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tableno extends AppCompatActivity {
    EditText entertable;
    static int num;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableno);
        entertable = (EditText) findViewById(R.id.entertable);

    }

    public void proceed(View v) {
        if (entertable.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Please,enter your table number", Toast.LENGTH_SHORT).show();
        } else {
            Editable newtxt = (Editable) entertable.getText();
            String table_no = newtxt.toString();
            num = Integer.parseInt(table_no);
            if (num <= 20 && num != 0) {
                Intent intent = new Intent(tableno.this, Menu.class);
                startActivity(intent);
            } else {
                Toast.makeText(tableno.this, "Enter valid Table Number", Toast.LENGTH_SHORT).show();
            }


        }
    }
}












   /* public void proceed(View view)
    {
        int no_table = Integer.parseInt(entertable.getText().toString());
        if(no_table < 20)
        {


                }
            });
        }


    }
}
*/