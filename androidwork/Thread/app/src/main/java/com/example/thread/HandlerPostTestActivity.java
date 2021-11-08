package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
//handler 객체를 재 정의하면서 handleMessage를 오버라이딩해서 처리하지 않고 Handler객체의

public class HandlerPostTestActivity extends AppCompatActivity {
    ImageView iv;
    Button btn1;
    Button btn2;
    TextView tv;
    Handler handler;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_exam_post);
        init();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NumThread().start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImageThread().start();
            }
        });
        handler = new Handler(Looper.myLooper());
    }
    //btn2를 누르면 이미지가 교차되어 보여지도록(홀수 짝수) 쓰레드적용
    //숫자를 만드는 쓰레드를 생성
    //ImageThread -> post메소드를 이용해서
    class ImageThread extends Thread{
        public void run(){
            for(int i=1;i<=100;i++){
                num=i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(num%2==0){
                            iv.setImageResource(R.drawable.d1);
                        }else {
                            iv.setImageResource(R.drawable.d2);
                        }
                    }
                });
                SystemClock.sleep(1000);
            }
        }
    }
    class NumThread extends Thread{
        public void run(){
            for(int i=1; i<=10; i++){
                //핸들러에게 UI를 변경하는 쓰레드를 전달하면서 요청
                num = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //TextView를 변경하는 작업
                        tv.setText(num+"");
                    }
                });
                SystemClock.sleep(1000);
            }
        }
    }
    public void init() {
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        iv = findViewById(R.id.imageView);
        tv = findViewById(R.id.numView);
    }
}