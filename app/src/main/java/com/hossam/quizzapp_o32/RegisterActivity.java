package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    //Set 1 : Declaration
    Button etButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Set 2 : Recuperation des Id
        etButton2 = (Button) findViewById(R.id.etButton2);

        etButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set 4 : Treatment
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });
    }
}