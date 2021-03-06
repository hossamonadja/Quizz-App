package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quizz_1 extends AppCompatActivity {
    //Set 1 : Declaration
    Button bNext;
    RadioGroup rg;
    RadioButton rb;
    int score=0;
    String RepCorrect="Non";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz1);

        //Set 2 : Recuperation des Id
        rg = (RadioGroup) findViewById(R.id.rg);
        bNext=(Button) findViewById(R.id.bNext);

        //Set 3 : Association des listeners

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse svp !", Toast.LENGTH_SHORT).show();
                }

                else {
                    //Set 3 : Association des listeners
                    rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    if (rb.getText().toString().equals(RepCorrect)){
                        score+=1;
                    }
                    Intent intent = new Intent(Quizz_1.this,Quizz_2.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();
                }
            }
        });
    }
}