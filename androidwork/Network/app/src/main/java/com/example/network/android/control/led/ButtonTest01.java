package com.example.network.android.control.led;

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

public class ButtonTest01 extends AppCompatActivity {
    BufferedReader serverIn;
    PrintWriter serverOut;
    Socket server;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butten_test01);
        new ledThread().start();
    }
    public void sending_msg(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message = "";
                if (view.getId()==R.id.led1){
                    message = "led1_on";
                }
                if (view.getId()==R.id.led2){
                    message = "led2_on";
                }
                if (view.getId()==R.id.led3){
                    message = "led3_on";
                }
                serverOut.println(message);
            }
        }).start();
    }
    class ledThread extends Thread{
        public void run(){
            try {
                server = new Socket("192.168.0.58",12345);
                if(server!=null){
                    io_init();
                }
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while ((true)){
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