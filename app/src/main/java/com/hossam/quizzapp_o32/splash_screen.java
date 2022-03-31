package com.hossam.quizzapp_o32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);

        Thread screen = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(splash_screen.this,MainActivity.class));
                    finish();
                }
            }
        };
        screen.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}