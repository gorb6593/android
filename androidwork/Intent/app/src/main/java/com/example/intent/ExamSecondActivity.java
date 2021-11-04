package com.example.intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ExamSecondActivity extends AppCompatActivity {
    Button ok;
    TextView result;
    CheckBox memberState;
    Button btn_close ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);
        result = findViewById(R.id.exam_result_txt);
        ok  = findViewById(R.id.exam_close);
        memberState = findViewById(R.id.member_state);
        btn_close= findViewById(R.id.exam_close);
        Intent intent = getIntent();
        String id = intent.getStringExtra("name");

        if(id!=null) {//null이 아니면
            String tel = intent.getStringExtra("tel");
            result.setText("입력한 id:" + id + ",입력한 전화번호:" + tel);
        }
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("chkVal", memberState.isChecked());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
