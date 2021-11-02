package com.example.basicview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextViewTestActivity extends AppCompatActivity {
    //TextViewTestActivity에서 view에 코드를 연결하기 위해
    //리소스를 가져와야 한다.
    EditText txtinfo;
    TextView lblinfo;
    TextView lblinfo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_test);

        lblinfo=findViewById(R.id.myinfo);
        txtinfo=findViewById(R.id.mytext);

        Button btnset = findViewById(R.id.btnset1);
        Button btnget = findViewById(R.id.btnget1);

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = txtinfo.getText()+"";
                lblinfo.setText(msg);
            }
        });
        btnset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtinfo.setText("가져온 문자열:작업완료");
            }
        });

        //위젯과 리스너를 연결
        //EditText에서 문자를 입력할 때 이벤트를 발생
        TextWatcherListener listener = new TextWatcherListener();
        txtinfo.addTextChangedListener(listener);
    }
    //TextWatcher를 구현하는 이벤트 처리를 담당하는 내부클래스정의
    class TextWatcherListener implements TextWatcher{
        //문자값이 변경되지 전에 호출
        //s => 현재 EditText에 입력된 값
        //start => s에 저장된 문자열에서 새로 추가될 문자열의 시작 index
        //count => 문자열의 길이
        //after => 추가될 문자열길이
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        //문자가 변경될 때 호출
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("watcher", "s"+s+",start"+start+",...");
            lblinfo.setText("변경되는 문자열..."+s);

        }
        //문자가 변경된 후 호출
        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}