package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quizz_2 extends AppCompatActivity {
    //Set 1 : Declaration
    Button etQbutton3, etQbutton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz2);

        //Set 2 : Recuperation des Id
        etQbutton3 = (Button) findViewById(R.id.etQbutton3);
        etQbutton4 = (Button) findViewById(R.id.etQbutton4);

        //Set 3 : Association des listeners
        etQbutton3.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                Toast.makeText(Quizz_2.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_2.this,Quizz_3.class));
            }
        });

        etQbutton4.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                GlobalVariable.count+=5;
                Toast.makeText(Quizz_2.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_2.this,Quizz_3.class));
            }
        });
    }
}