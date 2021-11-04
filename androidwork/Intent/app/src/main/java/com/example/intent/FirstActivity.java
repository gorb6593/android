package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    //버튼을 누르면 SecondActivity가 실행되도록
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        Log.d("life","onCreate()...");
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. 실행하려는 액티비티의 정보를 담아 Intent객체 생성
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //2. 새로 호출되는 액티비티에 데이터를 전달하기
                intent.putExtra("info", "첫 번째 액티비티가 넘기는 메시지");
                intent.putExtra("num",100000);
                //3. startActivity메소드를 호출하여 intent를 전달달
               startActivity(intent);
            }
        });
    }
}
