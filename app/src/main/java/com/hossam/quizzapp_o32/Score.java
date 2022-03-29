package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {
    //Set 1 : Declaration
    Button bLogout, bTry;
    ProgressBar progressBar;
    TextView tvScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Set 2 : Recuperation des Id
        bTry = (Button) findViewById(R.id.bTry);
        bLogout = (Button) findViewById(R.id.bLogout);
        tvScore = (TextView) findViewById(R.id.tvScore);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Intent intent=getIntent();

        score=intent.getIntExtra("score",0) ;
        progressBar.setProgress(100*score/4);
        tvScore.setText(100*score/4+" %");

        //Set 3 : Association des listeners
        bTry.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,Quizz_1.class));
                finish();
            }
        });

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,MainActivity.class));
                finish();
            }
        });


    }
}