package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quizz_4 extends AppCompatActivity {
    //Set 1 : Declaration
    Button etQbutton7, etQbutton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz4);

        //Set 2 : Recuperation des Id
        etQbutton7 = (Button) findViewById(R.id.etQbutton7);
        etQbutton8 = (Button) findViewById(R.id.etQbutton8);

        //Set 3 : Association des listeners
        etQbutton7.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                GlobalVariable.count+=5;
                Toast.makeText(Quizz_4.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_4.this,Score.class));
            }
        });

        etQbutton8.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                Toast.makeText(Quizz_4.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_4.this,Score.class));
            }
        });
    }
}