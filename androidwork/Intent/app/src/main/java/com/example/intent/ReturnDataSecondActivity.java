package com.example.intent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReturnDataSecondActivity extends AppCompatActivity {
	String code;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.second2);
	    Button bt1 = (Button)findViewById(R.id.btnClose1);
	    Button bt2_show = (Button)findViewById(R.id.btnShowData);
		TextView txt = findViewById(R.id.secondTxt);
		Intent intent = getIntent();
		code = intent.getStringExtra("code");
		bt2_show.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (code){
					case "call2":
						//호출한 액티비티에서 공유한 데이터 추출
						String data = intent.getStringExtra("data");
						txt.setText(data);
					case "call3":
						//호출한 액티비티에서 공유한 데이터 추출
						String data2 = intent.getStringExtra("data");
						txt.setText(data2);


				}
			}
		});
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//호출한 액티비티로 되돌아갈 때 설정하 값이 있는 경우 셋팅
				intent.putExtra("second", "두 번째 액티비티에서 실행 완료");
				//되돌아갈 때 값을 공유한 intent객체를 넘긴다.
				setResult(RESULT_OK,intent);
				finish();
			}
		});
	}
}
