package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Set 1 : Declaration
    EditText etLogin, etPassword;
    Button etButton;
    TextView etRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set 2 : Recuperation des Id
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etButton = (Button) findViewById(R.id.etButton);
        etRegister = (TextView) findViewById(R.id.etRegister);

        //Set 3 : Association des listeners

        etButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set 4 : Treatment
                if(etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this,Quizz_1.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set 4 : Treatment
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
    }
}