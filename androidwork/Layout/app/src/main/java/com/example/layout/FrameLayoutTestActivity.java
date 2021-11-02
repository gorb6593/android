package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class FrameLayoutTestActivity extends AppCompatActivity {
    ImageView image1;
    ImageView image2;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout_test);
        image1 = findViewById(R.id.img01);
        image2 = findViewById(R.id.img02);
    }
    //버튼이 클릭될 때 호출되는 메소드
    public void myclick(View v){
        imagechange();
    }
    //버튼을 선택할 때마다 이미지가 교체되어 보이도록 구현
    public void imagechange(){
        if(index==0){
            //View.VISIBLE은 FrameLayout에 추가 되어있는 뷰를 화면에 표시하기
            image1.setVisibility(View.VISIBLE);
            //View.INVISIBLE은 화면에 표시하지 않기
            image2.setVisibility(View.INVISIBLE);
            Log.d("index", "현재index값=>"+index);
            index=1;
        }else if(index==1){
            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.VISIBLE);
            Log.d("index", "현재index값=>"+index);
            index=0;
        }
    }
}