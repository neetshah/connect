package com.shahn.user.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shahn.user.connect.firebase.firebaseAuth;

public class createAccount extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private String email_string;
    private String pass_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button createacc1;

        createacc1 = findViewById(R.id.button_createacc);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        createacc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_string = email.getText().toString();
                pass_string = pass.getText().toString();
                firebaseAuth.createNewAccount(email_string, pass_string);
            }
        });
    }
}
