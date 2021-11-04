package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button bt2 = findViewById(R.id.bt2);
        //1. SecondActivity정보를 담고 있는 Intent객체를 구하기
        Intent intent = getIntent();
        //2. intent에 공유된 값 꺼내기
        String msg= intent.getStringExtra("info");
        int data = intent.getIntExtra("num", 0);
        Toast.makeText(this,"추출한 값:"+msg+",num=>"+data,Toast.LENGTH_LONG).show();
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티 종료
                finish();
            }
        });
    }
}
