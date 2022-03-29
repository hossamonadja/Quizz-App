package com.hossam.quizzapp_o32;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    //Set 1 : Declaration
    EditText etLogin, etPassword;
    Button etButton;
    TextView etRegister, etexit;
    ProgressBar etprogressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set 2 : Recuperation des Id
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etButton = (Button) findViewById(R.id.etButton);
        etRegister = (TextView) findViewById(R.id.etRegister);
        etexit = (TextView) findViewById(R.id.etexit);
        etprogressbar = (ProgressBar) findViewById(R.id.etprogressbar);
        mAuth = FirebaseAuth.getInstance();

        //Set 3 : Association des listeners

        etButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set 4 : Treatment
                String mail=etLogin.getText().toString().trim();
                String password=etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(mail)){
                    etLogin.setError("Email is required !");
                    etLogin.requestFocus();
                    return;

                }

                if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    etLogin.setError("Provide valid email !");
                    etLogin.requestFocus();
                    return;
                }


                if (TextUtils.isEmpty(password)){
                    etPassword.setError("Password is required !");
                    etPassword.requestFocus();
                    return;

                }

                if (password.length()<6){
                    etPassword.setError("Min password length should be 6 characteres !");
                    etPassword.requestFocus();
                    return;
                }

                etprogressbar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,Quizz_1.class));
                            finish();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            etprogressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        etRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set 4 : Treatment
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                finish();
            }
        });

        etexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "M'winviel Studio", Toast.LENGTH_SHORT).show();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}