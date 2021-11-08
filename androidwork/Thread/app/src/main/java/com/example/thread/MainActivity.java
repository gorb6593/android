package com.example.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int progressVal; //progressVal에 값을 저장할 변수
    //쓰레드 작업을 처리할 핸들러객체를 정의
    Handler handler1;
    Handler handler2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        progressBar =  findViewById(R.id.progressBar);
        textView =   findViewById(R.id.textView);

        /*
           worker쓰레드의 요청을 처리할 핸들러객체를 정의
           Looper는 쓰레드의 메시지를 관리하는 안드로이드 객체
           Looper는 쓰레드로부터 메시지가 도착하면 핸들러에게 해당 메시지를 전달하는 역할
           Looper가 작업 요청을 기다리고 있다가 작업에 대한 요청이 들어오면 처리
         */
        handler1 = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                //Log.d("kim","handleMessage()");
                progressBar.incrementProgressBy(1);
                textView.setText("progressbar진행률:"+progressVal+"%");
            }
        };
    }

    /*
        [화면을 변경하는 작업을 다른 메소드에서 처리]
        긴 시간 동안 실행하면서 view를 변경하려고 하는 경우
        실행되는 동안 다른 작업을 할 수 없다. 실행되는 동안 안드로이드 내부에서 이벤트가 발생하고
        발생한 이벤트에 대하여 5초동안 반응하지 않으면
        안드로이드 OS는 어플리케이션을 강제 종료한다.
        ANR(Application Not Responding)
        *시간이 오래 걸리는 작업은 UI쓰레드에서 처리하면 안된다.
        UI쓰레드=> 기본 쓰레드(이벤트를 리스닝하면서 작업처리하는 쓰레드)를 의미
     */
    public void btnNoThread(View view){
        for(progressVal=1; progressVal<100; progressVal++){
            progressBar.setProgress(progressVal);
            SystemClock.sleep(1000);//1초동안 쉼
        }
    }
    /*
        개발자가 만든 쓰레드 내부에서 UI를 변경
        => 잠정적인 문제점을 갖고 있는 방법(UI의 변경 UI쓰레드에서만 작업)
        => 기본쓰레드에서만 작업!
     */

    public void useThread(View view){
        //사용자가 만드는 작업쓰레드 - Worker쓰레드
        //프로그래스바에 진행상태가 출력되도록록
      new Thread(new Runnable() {
           @Override
           public void run() {
               for(progressVal=1; progressVal<100; progressVal++){
                   progressBar.setProgress(progressVal);
                   textView.setText("progressbar의 진행률:"+progressVal+"%");
                   SystemClock.sleep(1000);
               }
           }
       }).start();
    }
    /*
        핸들러객체를 통해 view에 대한 변경을 요청하기
        핸들러객체는 작업쓰레드로부터 받은 요청을 꺼내서 뷰를 변경
     */
    public void useHandler(View view){
        //오래걸리는 작업을 쓰레드로 구현
        //핸들러에게 의뢰
        //쓰레드시작
        new Thread(new MyThread()).start();
    }
   
    public void useMessageHandler(View view){
        
    }
    class MyThread implements Runnable{

        @Override
        public void run() {
            for (progressVal = 1; progressVal < 100; progressVal++) {
                //handler가 갖고 있는 메시지객체를 매개변수로 전달하면서 작업
                //handler가 갖고 있는 기본 메시지객체를 전달할 수 있다.
                //handler의 sendMessage를 호출하면 핸들러에게 메시지를 전송
                //메시지가 전송되면 핸들러객체의 handleMessage메소드가 호출된다.
                handler1.sendMessage(handler1.obtainMessage());
                SystemClock.sleep(1000);
            }
        }
    }
}







