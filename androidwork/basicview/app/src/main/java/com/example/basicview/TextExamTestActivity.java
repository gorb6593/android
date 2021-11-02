package com.example.basicview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class TextExamTestActivity extends AppCompatActivity {
    EditText textarea1;
    EditText textarea2;
    EditText inputdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_exam);
        textarea1 = findViewById(R.id.area1);
        textarea2 = findViewById(R.id.area2);
        inputdata = findViewById(R.id.input);

        //EditText에서 Enter키를 누르면 반응하도록 작업하기
        inputdata.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (keyCode){
                    case KeyEvent.KEYCODE_ENTER://엔터키에 대한 상수
                        textarea1.append(inputdata.getText()+"\n");
                        textarea2.append(inputdata.getText()+"\n");
                        inputdata.setText("");
                }
                return true;
            }
        });
    }
}