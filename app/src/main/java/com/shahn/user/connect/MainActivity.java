package com.shahn.user.connect;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email;
    private EditText pass;
    private Button login;
    private Button createacc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        createacc1 = findViewById(R.id.createacc);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });

        createacc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });

    }


    public void startSignIn() {
        String email_string = email.getText().toString();
        String pass_string = pass.getText().toString();

        mAuth.signInWithEmailAndPassword(email_string, pass_string)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Log In Successful", Toast.LENGTH_SHORT).show();
                            goToContact();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Log In Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void goToContact() {
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);

    }

    public void goToRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }
}
