package com.example.advancedview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleSwitchTestActivity extends AppCompatActivity {
    ToggleButton toggleBtn;
    Switch switch1;
    Switch switch2;
    Switch switch3;
    SwitchCompat switchCompat01;
    Button btn_switch1;
    Button btn_switch2;
    Button btn_switch3;
    Button btn_switch4;
    Button ts_button1;
    Button ts_button2;
    Button ts_button3;
    Button ts_button4;
    TextView ts_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch_test);
        toggleBtn = findViewById(R.id.toggleBtn);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        //switchCompat01 = findViewById(R.id.switchCompat01);
        ts_button1 = findViewById(R.id.ts_button1);
        ts_button2 = findViewById(R.id.ts_button2);
        ts_button3 = findViewById(R.id.ts_button3);
        ts_button4 = findViewById(R.id.ts_button4);
        btn_switch1 = findViewById(R.id.switch_button1);
        btn_switch2 = findViewById(R.id.switch_button2);
        btn_switch3 = findViewById(R.id.switch_button3);
        ts_info=findViewById(R.id.ts_info);

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ts_info.setText("토글버튼 클릭(토글상태:"+toggleBtn.isChecked()+")");
            }
        });
    }
}