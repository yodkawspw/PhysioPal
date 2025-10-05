package com.example.physiopal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecommendForm extends AppCompatActivity {

    TextView painLevelText, resultText;
    SeekBar painSeekBar;
    RadioGroup bodyPartGroup;
    Button recommendButton,viewExerciseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recommend_form);

        bodyPartGroup = findViewById(R.id.bodyPartGroup);
        painSeekBar = findViewById(R.id.painSeekBar);
        painLevelText = findViewById(R.id.painLevel);
        recommendButton = findViewById(R.id.recommendButton);
        resultText = findViewById(R.id.resultText);
        viewExerciseButton = findViewById(R.id.viewExerciseButton);

        // อัปเดตค่าความเจ็บปวดแบบ Real-time
        painSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                painLevelText.setText("ระดับ: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // เมื่อกดปุ่ม "ดูคำแนะนำ"
        recommendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = bodyPartGroup.getCheckedRadioButtonId();
                int painLevel = painSeekBar.getProgress();

                String recommendation = "กรุณาเลือกบริเวณที่ต้องการฝึก";
                boolean showExerciseButton = false;

                if (selectedId != -1) {
                    RadioButton selectedButton = findViewById(selectedId);
                    String selectedBodyPart = selectedButton.getText().toString();

                    recommendation = getRecommendation(selectedBodyPart, painLevel);
                    showExerciseButton = !recommendation.startsWith("⚠️") && !recommendation.contains("หลีกเลี่ยง");
                }

                resultText.setText(recommendation);
                resultText.setVisibility(View.VISIBLE);

                // แสดงปุ่มเฉพาะเมื่อมีคำแนะนำท่าออกกำลังกาย
                viewExerciseButton.setVisibility(showExerciseButton ? View.VISIBLE : View.GONE);
            }
        });

        viewExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = bodyPartGroup.getCheckedRadioButtonId();
                int painLevel = painSeekBar.getProgress();

                if (selectedId != -1) {
                    RadioButton selectedButton = findViewById(selectedId);
                    String selectedBodyPart = selectedButton.getText().toString();

                    Intent intent = null;
                    switch (selectedBodyPart) {
                        case "หัวเข่า":
                            intent = getExerciseIntent(getKneeExercise(painLevel));
                            break;
                        case "ข้อไหล่":
                            intent = getExerciseIntent(getShoulderExercise(painLevel));
                            break;
                        case "หลัง":
                            intent = getExerciseIntent(getBackExercise(painLevel));
                            break;
                    }

                    if (intent != null) {
                        startActivity(intent);
                    }
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // ฟังก์ชันคืนค่า Intent ตามคำแนะนำ
    private Intent getExerciseIntent(String recommendation) {
        if (recommendation.contains("Quad Set")) {
            return new Intent(getApplicationContext(), QuadSet.class);
        } else if (recommendation.contains("Leg Raise")) {
            return new Intent(getApplicationContext(), StraightLegRaise.class);
        } else if (recommendation.contains("Shoulder Roll")) {
            return new Intent(getApplicationContext(), ShoulderRoll.class);
        } else if (recommendation.contains("Wall Walk")) {
            return new Intent(getApplicationContext(), WallWalk.class);
        } else if (recommendation.contains("Cat-Cow Stretch")) {
            return new Intent(getApplicationContext(), CatCow.class);
        } else if (recommendation.contains("Bridge Exercise")) {
            return new Intent(getApplicationContext(), Bridge.class);
        }
        return null;
    }

    // ฟังก์ชันแนะนำท่ากายภาพตามบริเวณที่เลือก
    private String getRecommendation(String bodyPart, int painLevel) {
        switch (bodyPart) {
            case "หัวเข่า":
                return getKneeExercise(painLevel);
            case "ข้อไหล่":
                return getShoulderExercise(painLevel);
            case "หลัง":
                return getBackExercise(painLevel);
            default:
                return "ไม่พบคำแนะนำ กรุณาเลือกบริเวณที่ต้องการฝึก";
        }
    }

    private String getKneeExercise(int painLevel) {
        if (painLevel <= 3) {
            return "✅ ท่า Quad Set เบาๆ เพื่อเพิ่มความแข็งแรง";
        } else if (painLevel <= 6) {
            return "🔹 ท่า Leg Raise เพื่อเสริมสร้างกล้ามเนื้อรอบเข่า";
        } else {
            return "⚠️ หลีกเลี่ยงการออกแรงมาก อาจลองนวดหรือประคบเย็น";
        }
    }

    private String getShoulderExercise(int painLevel) {
        if (painLevel <= 3) {
            return "✅ ท่า Shoulder Roll เพื่อเพิ่มความยืดหยุ่น";
        } else if (painLevel <= 6) {
            return "🔹 ท่า Wall Walk เพื่อฟื้นฟูการเคลื่อนไหว";
        } else {
            return "⚠️ หลีกเลี่ยงการยกของหนัก และลองประคบอุ่น";
        }
    }

    private String getBackExercise(int painLevel) {
        if (painLevel <= 3) {
            return "✅ ท่า Cat-Cow Stretch เพื่อผ่อนคลายกระดูกสันหลัง";
        } else if (painLevel <= 6) {
            return "🔹 ท่า Bridge Exercise เพื่อเสริมสร้างกล้ามเนื้อหลัง";
        } else {
            return "⚠️ หลีกเลี่ยงการก้มตัวมากเกินไป ควรนอนพักและยืดเบาๆ";
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        resultText.setVisibility(View.GONE);
        viewExerciseButton.setVisibility(View.GONE);
    }
}