package com.shahn.user.connect;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private static final String TAG = "Register";

    private EditText text;
    private Button register;
    private String username, pass, confirmpass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        register = findViewById(R.id.register);

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
            Log.e(TAG, "signUp, if statement");
            mAuth.createUserWithEmailAndPassword(username, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.e(TAG, "createUserWithEmail:success");
                                //FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(Register.this, "Account Registration Successful", Toast.LENGTH_LONG).show();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.e(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Register.this, "Account Registration Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
        else {
            Log.e(TAG, "createUserWithEmail:failure");
            Toast.makeText(Register.this, "Account Registration Failed", Toast.LENGTH_LONG).show();
        }
    }

}
