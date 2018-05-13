package com.shahn.user.connect.firebase;


import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class firebaseAuth {

    private FirebaseAuth mAuth;

    public static void createNewAccount(String email, String pass) {
        FirebaseAuth mAuth1;
        mAuth1 = FirebaseAuth.getInstance();
        //mAuth1.createUserWithEmailAndPassword(); //add to this
    }

}
