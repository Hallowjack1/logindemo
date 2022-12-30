package com.demo.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity{
    EditText Email, Password;
    Button Login, Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setupListeners();
    }

    private void setupUI() {
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        Register = findViewById(R.id.register2);
        Login = findViewById(R.id.buttonlogin);
    }

    private void setupListeners() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmail();
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });
    }
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    private void checkEmail() {
        boolean isValid = true;
        if (isEmpty(Email)){
            Email.setError("You must enter Email to Login!");
            isValid = false;
        }
        else{
            if (!isEmail(Email)){
                Email.setError("Enter valid Email!");
                isValid = false;
            }
        }

        if (isEmpty(Password)){
            Password.setError("You must enter Password to Login!");
            isValid = false;
        }
        else{
            if (Password.getText().toString().length() < 1){
                Password.setError("Enter valid Password!");
            }
        }

        if(isValid) {
            String emailValue = Email.getText().toString();
            String passValue = Password.getText().toString();
            if (emailValue.equals("admin@gmail.com") && passValue.equals("123456")) {
                Intent i = new Intent(Login.this, Home.class);
                startActivity(i);
                this.finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
}
