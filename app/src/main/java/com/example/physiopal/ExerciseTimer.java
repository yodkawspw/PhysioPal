package com.example.physiopal;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class ExerciseTimer extends AppCompatActivity {

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis; // เวลาที่เหลือ
    private boolean isRunning = false;
    //Step 1
    TextView tvTimer;
    EditText etMinutes;
    Button btnStart, btnStop, btnPause, btnResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_timer);
        //Step2
        tvTimer = findViewById(R.id.tvTimer);
        etMinutes = findViewById(R.id.etMinutes);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnPause = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);


        btnStart.setOnClickListener(v -> startTimer());
        btnStop.setOnClickListener(v -> stopTimer());
        btnPause.setOnClickListener(v -> pauseTimer());
        btnResume.setOnClickListener(v -> resumeTimer());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void startTimer() {
        if (isRunning) return;

        String input = etMinutes.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "กรุณาใส่จำนวนนาทีที่ต้องการกายภาพ", Toast.LENGTH_SHORT).show();
            return;
        }

        int minutes = Integer.parseInt(input);
        timeLeftInMillis = minutes * 60 * 1000;

        startCountDown();
        btnStop.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.VISIBLE);
        btnStart.setVisibility(View.GONE);
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                tvTimer.setText("00:00");
                isRunning = false;
                btnStop.setVisibility(View.GONE);
                btnPause.setVisibility(View.GONE);
                btnResume.setVisibility(View.GONE);
                Toast.makeText(ExerciseTimer.this, "จับเวลาสำเร็จ!", Toast.LENGTH_SHORT).show();
            }
        }.start();

        isRunning = true;
        btnPause.setVisibility(View.VISIBLE);
        btnResume.setVisibility(View.GONE);
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            isRunning = false;
            btnPause.setVisibility(View.GONE);
            btnResume.setVisibility(View.VISIBLE);
        }
    }

    private void resumeTimer() {
        startCountDown();
        btnResume.setVisibility(View.GONE);
        btnPause.setVisibility(View.VISIBLE);
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            isRunning = false;
            timeLeftInMillis = 0;
            tvTimer.setText("00:00");
            btnPause.setVisibility(View.GONE);
            btnResume.setVisibility(View.GONE);
            btnStop.setVisibility(View.GONE);
            btnStart.setVisibility(View.VISIBLE);
        }
    }

    private void updateTimerText() {
        int minutesLeft = (int) (timeLeftInMillis / 1000) / 60;
        int secondsLeft = (int) (timeLeftInMillis / 1000) % 60;
        tvTimer.setText(String.format(Locale.getDefault(), "%02d:%02d", minutesLeft, secondsLeft));
    }
}