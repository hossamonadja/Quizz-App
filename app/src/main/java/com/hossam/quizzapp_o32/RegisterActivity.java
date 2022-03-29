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

public class RegisterActivity extends AppCompatActivity {
    //Set 1 : Declaration
    EditText etName, etMail, etPassword, etConfirm;
    TextView etLogin;
    Button etSignUp;
    ProgressBar etprogressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Set 2 : Recuperation des Id
        etName = (EditText) findViewById(R.id.etName);
        etMail = (EditText) findViewById(R.id.etMail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirm = (EditText) findViewById(R.id.etConfirm);
        etSignUp = (Button) findViewById(R.id.etSignUp);
        etLogin = (TextView) findViewById(R.id.etLogin);
        etprogressbar = (ProgressBar) findViewById(R.id.etprogressbar);
        mAuth = FirebaseAuth.getInstance();

        /*if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            finish();
        }*/

        etSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString().trim();
                String mail=etMail.getText().toString().trim();
                String password=etPassword.getText().toString().trim();
                String password2=etConfirm.getText().toString().trim();

                if (TextUtils.isEmpty(name)){
                    etName.setError("Full name is required !");
                    etName.requestFocus();
                    return;

                }

                if (TextUtils.isEmpty(mail)){
                    etMail.setError("Email is required !");
                    etMail.requestFocus();
                    return;

                }

                if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    etMail.setError("Provide valid email !");
                    etMail.requestFocus();
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

                if (TextUtils.isEmpty(password2)){
                    etConfirm.setError("Please confirm the password !");
                    etConfirm.requestFocus();
                    return;
                }

                if (!password.equals(password2)){
                    etPassword.setError("not match");
                    etConfirm.setError("not match");
                    etPassword.requestFocus();
                    etConfirm.requestFocus();
                    return;
                }

                etprogressbar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Registration Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Registration failed !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            etprogressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        etLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set 4 : Treatment
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}