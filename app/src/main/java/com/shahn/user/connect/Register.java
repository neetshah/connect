package com.shahn.user.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private EditText text;
    private Button register;
    private String username, pass, confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        text = findViewById(R.id.username);
        username = text.getText().toString();
        text = findViewById(R.id.password);
        pass = text.getText().toString();
        text = findViewById(R.id.confirmpass);
        confirmpass = text.getText().toString();

        if(username.length() != 0 && pass.length() != 0 && confirmpass.length() != 0 &&
                pass.equals(confirmpass)) {
            ;
        }
    }

}
