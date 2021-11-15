package com.example.network.arduino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.network.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LedControlActivity extends AppCompatActivity {
    BufferedReader serverIn;//서버에서 보내오는 메시지 읽기 위한 스트림
    PrintWriter serverOut;//서버로 메시지를 보내기 위한 스트림
    Socket server;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_control);
        new LedThread().start();
    }
    //버튼을 누를 때 호출되는 메소드
    public void send_msg(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message = "";
                if(view.getId()==R.id.led_on){
                    message = "led_on";
                }else {
                    message = "led_off";
                }
                serverOut.println(message);//서버로 메시지 보내기
            }
        }).start();
    }
    class LedThread extends Thread{
        public void run(){
            try {
                server = new Socket("192.168.0.58",12345);
                if (server!=null){
                    io_init();
                }
                //서버가 보내오는 메시지를 읽기 위한 쓰레드
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            String msg;
                            try {
                                msg = serverIn.readLine();
                                Log.d("network","서버로부터 수신된 메시지>>"+msg);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        void io_init(){
            try {
                serverIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
                serverOut = new PrintWriter(server.getOutputStream(), true);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}