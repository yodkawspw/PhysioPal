package com.example.physiopal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChestandBack extends AppCompatActivity {

    //Step 1
    Button mycsBT, myccBT, mybBT, myshouldersBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chestand_back);
        //Step 2
        mycsBT = findViewById(R.id.csBT);
        myccBT = findViewById(R.id.ccBT);
        mybBT = findViewById(R.id.bBT);
        myshouldersBT = findViewById(R.id.shouldersBT);

        //Step 3 for mycsBT
        mycsBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ChestStretch.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myccBT
        myccBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), CatCow.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mybBT
        mybBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), Bridge.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myshouldersBT
        myshouldersBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ShoulderSqueeze.class);
                startActivity(myintent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}