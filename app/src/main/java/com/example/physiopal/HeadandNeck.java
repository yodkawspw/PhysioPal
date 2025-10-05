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

public class HeadandNeck extends AppCompatActivity {

    //Step 1
    Button myctBT, mynssBT, mynrBT, myssBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_headand_neck);
        //Step 2
        myctBT = findViewById(R.id.ctBT);
        mynssBT = findViewById(R.id.nssBT);
        mynrBT = findViewById(R.id.nrBT);
        myssBT = findViewById(R.id.ssBT);

        //Step 3 for myctBT
        myctBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), ChinTuck.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mynssBT
        mynssBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), NeckSideStretch.class);
                startActivity(myintent);
            }
        });

        //Step 3 for mynrBT
        mynrBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), NeckRotation.class);
                startActivity(myintent);
            }
        });

        //Step 3 for myssBT
        myssBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), SuboccipitalStretch.class);
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