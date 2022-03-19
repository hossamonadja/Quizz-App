package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    //Set 1 : Declaration
    Button etRetry, etQuit;
    TextView etscore;

    //int score = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Set 2 : Recuperation des Id
        etRetry = (Button) findViewById(R.id.etRetry);
        etQuit = (Button) findViewById(R.id.etQuit);
        etscore = (TextView) findViewById(R.id.etscore);

        etscore.setText("Score : " +GlobalVariable.count + "/20");

        //Set 3 : Association des listeners
        etRetry.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                GlobalVariable.count = 0;
                startActivity(new Intent(Score.this,Quizz_1.class));
            }
        });

        etQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });


    }
}