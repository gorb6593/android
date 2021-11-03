package com.example.advancedview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeekBarActivity extends AppCompatActivity
                implements View.OnClickListener,SeekBar.OnSeekBarChangeListener{

    // 뷰의 주소 값을 담을 참조변수
    SeekBar seek1, seek2;
    TextView text1, text2;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_main);

        seek1 = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        btn1 = findViewById(R.id.seekBtn1);
        btn2 = findViewById(R.id.seekBtn2);
        btn3 = findViewById(R.id.seekBtn3);
        btn4 = findViewById(R.id.seekBtn4);

        //리스너연결 - 이벤트연결(위젯이 이벤트에 반응할 수 있도록 연결)
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seekBtn1:
                //값 증가시키기
                seek1.incrementProgressBy(1);
                seek2.incrementProgressBy(1);
                break;
            case R.id.seekBtn2:
                //값 감소시키기
                seek1.incrementProgressBy(-1);
                seek2.incrementProgressBy(-1);
                break;
            case R.id.seekBtn3:
                //값 설정하기
                seek1.setProgress(5);
                seek2.setProgress(7);
                break;
            case R.id.seekBtn4:
                //값 가져오기
                int val1 = seek1.getProgress();
                text1.setText("seek1:"+val1);
                text2.setText(seek2.getProgress());
                break;

        }
    }
    //SeekBar의 값이 변경되었을 때 호출되는 메소드
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int id = seekBar.getId();
        switch (id){
            case R.id.seekBar:
                text1.setText("첫 번째seekbar:"+progress);
                break;
            case R.id.seekBar2:
                text1.setText("두 번째seekbar:"+progress);
                break;
        }
        //fromUser값 => true: 사용자, false: 코드
        if (fromUser) {
            text2.setText("사용자가 변경");
        }else {
            text2.setText("코드로 변경");
        }
    }
    //값을 변경하기 위해서 seekbar에 터치를 시작할 때 호출
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        switch (id){
            case R.id.seekBar:
                text1.setText("첫 번째seekbar터치시작:");
                break;
            case R.id.seekBar2:
                text1.setText("두 번째seekbar터치시작:");
                break;
        }
    }
    //값의 변경을 끝내고 seekbar에 터치를 끝낼 때
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        switch (id){
            case R.id.seekBar:
                text1.setText("첫 번째seekbar터치종료:");
                break;
            case R.id.seekBar2:
                text1.setText("두 번째seekbar터치종료:");
                break;
        }
    }
}









