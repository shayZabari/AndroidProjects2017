package com.example.toshiba.firebase20171128;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
Button btnFire;
EditText etUniversityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFire = findViewById(R.id.btnFire);
        etUniversityName = findViewById(R.id.etUniversityName);
        // Write a message to the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message1").child("shay");

        myRef.setValue("Hello, World123123!");
        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String universityName = etUniversityName.getText().toString();
                DatabaseReference universities = database.getReference(universityName);
                universities.setValue("urltest");
            }
        });
    }
}
