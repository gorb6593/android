package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class FrameExamActivity extends AppCompatActivity {
    LinearLayout login_linear;
    LinearLayout register_linear;
    LinearLayout info_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout_exam_01);
        login_linear = findViewById(R.id.linear1);
        register_linear = findViewById(R.id.linear2);
        info_linear = findViewById(R.id.linear3);
    }
    public void run_click(View v){
        Log.d("view",v.toString());
        if(v.getId()==R.id.button){//로그인
            login_linear.setVisibility(View.VISIBLE);
            register_linear.setVisibility(View.INVISIBLE);
            info_linear.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.button2){//회원가입
            login_linear.setVisibility(View.INVISIBLE);
            register_linear.setVisibility(View.VISIBLE);
            info_linear.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.button3){//상세정보
            login_linear.setVisibility(View.INVISIBLE);
            register_linear.setVisibility(View.INVISIBLE);
            info_linear.setVisibility(View.VISIBLE);
        }
    }
}