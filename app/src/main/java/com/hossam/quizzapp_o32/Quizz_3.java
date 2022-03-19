package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Quizz_3 extends AppCompatActivity {
    //Set 1 : Declaration
    Button etQbutton5, etQbutton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz3);

        //Set 2 : Recuperation des Id
        etQbutton5 = (Button) findViewById(R.id.etQbutton5);
        etQbutton6 = (Button) findViewById(R.id.etQbutton6);

        //Set 3 : Association des listeners
        etQbutton5.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                Toast.makeText(Quizz_3.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_3.this,Quizz_4.class));
            }
        });

        etQbutton6.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                GlobalVariable.count+=5;
                Toast.makeText(Quizz_3.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_3.this,Quizz_4.class));
            }
        });
    }
}