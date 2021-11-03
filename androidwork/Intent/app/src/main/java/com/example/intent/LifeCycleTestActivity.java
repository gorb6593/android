package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
/*
  앱이 처음 실행 될 때 : 생성자 -> onCreate() -> onStart() -> onResume()
  일시정지 : onPause() -> onStop()
  일시정지에서 빠져나올 때 : onRestart() -> onStart() -> onResume()
  앱이 종료될 때 : onPause() -> onStop() -> onDestroy()
 */
public class LifeCycleTestActivity extends AppCompatActivity {
    public LifeCycleTestActivity(){
        Log.d("life","생성자");
    }
    //Activity가 생성될 대 자동으로 호출 - (액티비티가 실행:1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("life","onCreate()호출...");
        setContentView(R.layout.activity_life_cycle_test);
    }

    //onCreate다음으로 호출되는 메소드 - (액티비티가 실행:2 단, pause상태에서 빠져나올때는 onCreate가 아니라
    //onStart가 호출
    //일시정지 상태에서 빠져나올 때
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","onStart()호출...");
    }
    //onStart다음으로 호출되는 메소드(액티비티 실행:3)
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life","onResume()호출...");
    }
    //
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life","onPause()호출...");
    }
    //일시정지나 종료상태로 바뀔 때 onPause다음으로 호출되는 메소드
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","onStop()호출...");
    }
    //
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life","onRestart()호출...");
    }
    //앱이 종료될 때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","onDestroy()호출...");
    }




}