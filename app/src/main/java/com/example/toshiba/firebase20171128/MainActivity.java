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
    EditText etUniversityName, etUniversityUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFire = findViewById(R.id.btnFire);
        etUniversityName = findViewById(R.id.etUniversityName);
        etUniversityUrl = findViewById(R.id.etUniversityUrl);
        // Write a message to the database

        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mRootReference = firebaseDatabase.getReference();
        final DatabaseReference mUniversities = mRootReference.child("universities");
//        final DatabaseReference mUniversityColor = mRootReference.child("color");


//        myRef.setValue("Hello, World123123!");
        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String universityName = etUniversityName.getText().toString();
                String url = etUniversityUrl.getText().toString();
                final DatabaseReference mUniversityName = mUniversities.child(universityName);
                final DatabaseReference mUniversityUrl = mUniversityName.child("url");
//                mUniversityName.setValue("test");
                mUniversityUrl.setValue(url);

//                mUniversityName.setValue(universityName);
//
//                DatabaseReference universities = mRef.getReference("Universities");
//                DatabaseReference urlDb = universities.child("url");
//                DatabaseReference logoDb = universities.child("logo");
//                universities.(universityName);
            }
        });
    }
}
