package com.example.physiopal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TherapyExercise extends AppCompatActivity {

    //Step 1
    Button mysubmitBT;
    Spinner mybodypartSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_therapy_exercise);

        //Step 2
        mysubmitBT = findViewById(R.id.submitBT);
        mybodypartSP = findViewById(R.id.bodypartSP);

        //Step 3
        mysubmitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Step 4
                if (mybodypartSP.getSelectedItem().equals("\uD83E\uDDE0 ศีรษะและคอ")){
                    Intent myintent = new Intent(getApplicationContext(), HeadandNeck.class);
                    startActivity(myintent);
                } else if (mybodypartSP.getSelectedItem().equals("\uD83E\uDEC1 หน้าอกและหลัง")) {
                    Intent myintent = new Intent(getApplicationContext(), ChestandBack.class);
                    startActivity(myintent);
                } else if (mybodypartSP.getSelectedItem().equals("\uD83E\uDE7B ไหล่และแขน")) {
                    Intent myintent = new Intent(getApplicationContext(), ShoulderandArm.class);
                    startActivity(myintent);
                }else if (mybodypartSP.getSelectedItem().equals("✋ ข้อศอก มือ และข้อมือ")) {
                    Intent myintent = new Intent(getApplicationContext(), EWH.class);
                    startActivity(myintent);
                }else if (mybodypartSP.getSelectedItem().equals("\uD83E\uDDB4 สะโพกและกระดูกเชิงกราน")) {
                    Intent myintent = new Intent(getApplicationContext(), HipandPelvis.class);
                    startActivity(myintent);
                }else if (mybodypartSP.getSelectedItem().equals("\uD83E\uDDB5 ขาและเข่า")) {
                    Intent myintent = new Intent(getApplicationContext(), LegandKnee.class);
                    startActivity(myintent);
                }else if (mybodypartSP.getSelectedItem().equals("\uD83E\uDDB6 ข้อเท้าและเท้า")) {
                    Intent myintent = new Intent(getApplicationContext(), AnkleandFoot.class);
                    startActivity(myintent);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}