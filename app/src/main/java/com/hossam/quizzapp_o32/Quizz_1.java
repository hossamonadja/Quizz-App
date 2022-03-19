package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quizz_1 extends AppCompatActivity {
    //Set 1 : Declaration
    Button etQbutton, etQbutton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz1);

        //Set 2 : Recuperation des Id
        etQbutton = (Button) findViewById(R.id.etQbutton);
        etQbutton2 = (Button) findViewById(R.id.etQbutton2);

        //Set 3 : Association des listeners
        etQbutton.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                Toast.makeText(Quizz_1.this, "Mauvaise réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_1.this,Quizz_2.class));
            }
        });

        etQbutton2.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                GlobalVariable.count+=5;
                Toast.makeText(Quizz_1.this, "Bonne réponse", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Quizz_1.this,Quizz_2.class));
            }
        });
    }
}