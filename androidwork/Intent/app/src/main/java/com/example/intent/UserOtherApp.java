package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserOtherApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_other_app);
    }
    public void callActivity(View v){
        /*
            다른 앱의 액티비티를 호출
            암시적인텐트 = 정확한 액티비티명을 모르고 등록된 액션명만 아는 경우
            보통은 안드로이드에 미리 등록된 이름으로 설정
        */
        Intent intent = new Intent("com.exam.myview");
        startActivity(intent);
    }
}