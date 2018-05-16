package com.shahn.user.connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chat extends AppCompatActivity {

    private Button send;
    private EditText msg;
    private FirebaseDatabase mRef;
    private DatabaseReference mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mRef = FirebaseDatabase.getInstance();
        mRoot = mRef.getReference();
        send = findViewById(R.id.send);
        msg = findViewById(R.id.message);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String text = msg.getText().toString();
                sendMessage(text);
            }
        });
    }

    private void sendMessage(String text) {
        String message = msg.getText().toString();
        DatabaseReference mHeading = mRoot.child(text).child("First Name");
        mHeading.setValue("Neet");
    }
}
