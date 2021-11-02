package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//코드를 이용해서 화면을 디자인
public class AddViewTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. LinearLayout을 만들기 - Context객체 전달
        LinearLayout layout = new LinearLayout(this);
        //2. 레이아웃의 방향설정하기
        layout.setOrientation(LinearLayout.VERTICAL);
        //3. Layout만들기 - width, height지정
        //   => LayoutParams를 이용해서 작업
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                              LinearLayout.LayoutParams.WRAP_CONTENT);
        //4. Layout에 추가될 view를 생성 -
        Button btn = new Button(this);
        btn.setText("코드로 만들어진 버튼");
        btn.setLayoutParams(params);//버튼에 layoutparams를 이용해서 크기 설정

        //5. layout에 view추가하기
        layout.addView(btn);

        //6. layout을 화면에 출력될 수 있도록 처리
        setContentView(layout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn2 = new Button(AddViewTestActivity.this);
                btn2.setText("이벤트로 만들어진 버튼");
                layout.addView(btn2);
            }
        });
    }
}