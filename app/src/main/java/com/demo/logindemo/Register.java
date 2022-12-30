package com.demo.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class Register extends AppCompatActivity {
    EditText FName, LName, Email, Pass;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FName = findViewById(R.id.etFName);
        LName = findViewById(R.id.etLName);
        Email = findViewById(R.id.etRegisterEmail);
        Pass = findViewById(R.id.etRegisterPass);
        Register = findViewById(R.id.register);

        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkDataEntered();
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

    private void checkDataEntered() {
        if (isEmpty(FName)) {
            Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(LName)) {
            LName.setError("Last name is required!");
        }

        if (isEmail(Email) == false) {
            Email.setError("Enter valid email!");
        }
        else{
            Intent i = new Intent(Register.this, Login.class);
            startActivity(i);
            this.finish();
        }
    }
}
