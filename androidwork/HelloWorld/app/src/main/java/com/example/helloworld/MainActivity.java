package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view로 정의된 Button을 찾아와서 코드를 연결
        //이벤트 연결
        //1. 이벤트가 발생했을 때 처리할 기능을 명시해 놓은 클래스가 필요
        //2. 이벤트를 발생시킬 위젯을 find(fundViewById)
        //3. 2번에서 찾아온 위젯과 이벤트처리 기능을 연결(setOnXXXListener)

        //역명이너클래스 - 클래스안에 정의된 또다른 클래스(이름이 없는 클래스)
        //new 인터페이스명() => View.OnClickListener()의 이름없는 하위클래스를 바로 정의하고
        //                    객체를 생성해서 쓰겠다.(일회용)
        Button mybtn = findViewById(R.id.mybtn);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼이 클릭될 때, 처리하고 싶은 기능
                Toast.makeText(MainActivity.this,
                        "익명이너클래스 활용해서 이벤트 처리하기", Toast.LENGTH_LONG).show();
            }
        });
    }
    //버튼에 대해서 편하게 이벤트를 연결할 수 있는 방법을 제공
    //버튼을 클릭했을 때 실행할 메소드를 정의
    //메소드의 매개변수가 View타입으로 정의되어 있어야한다.
    public void myclickMethod(View v){
        Log.d("test", "버튼 클릭");
    }
}