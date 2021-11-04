package com.example.intent;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
/*
    Intent를 이용하는 작업 중 결과를 가지고 처음 호출해준 액티비티로 데이터를 가지고
    돌아오는 작업은 startActivityForResult를 사용 => 2020년 5월 기준으로 변경(deprecated)
    registerForActivirtResult메소드를 이용해서 콜백을 등록해서 작업하는 방식으로 변경
    액티비티가 많아지면서 onActivityResult의 코드가 길어지고 분기가 많아지면서 유지보수가 힘들어짐
    onActivityResult안에서 모든 작업을 처리하지 않고 분리시킴 => 독립적인 코드로 작성
    1. ActivityResultLauncher를 정의
        => 원하는 작업을 갯수대로 여러 개 만들 수 있다.
    2. registerForActivityResult메소드를 이용해서 콜백을 등록
        => 리턴값이 오는 경우 어떻게 처리할 것인지 등록
        매개변수1 : 어떤 작업을 처리할 것인지 명시
                    new ActivityResultContracts.StartActivityForResult()
                    =>액티비티를 실행하고 작업을 처리한 후
                    호출한 액티비티로 값을 가지고 되돌아 오는 경우

        매개변수2 : 결과값에 대한 처리를 담당할 콜백메소드를 구현
                     new ActivityResultCallback<ActivityResult>()를 구현
                     ActivityResultCallback의 onActivityResult(ActivityResult result)를
                     오버라이딩해서 처리할 내용을 정의
                     - requestcode를 정의하지 않는다
                     - ActivityResult객체가 인텐트, resultcode정보를 갖고 있다.
        resultcode는 작업결과의 다양성을 위해서 필요

    3. 1번에서 정의한 ActivityResultLauncher의 launch메소드를 호출하면서 인텐트를 전달
 */
public class ReturnDataFirstActivity_Callback extends AppCompatActivity
			implements OnClickListener{
    public static final int SECOND_BUTTON = 10;
    public static final int THIRD_BUTTON = 20;
	Button bt1;
	Button bt2;
    Button bt3;
    Button bt4;
    ActivityResultLauncher<Intent> secondbtn_Launcher;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first2);
        bt1 = (Button)findViewById(R.id.call1);
        bt2 = (Button)findViewById(R.id.call2);
        bt3 = (Button)findViewById(R.id.btnExit);
        bt4 = (Button)findViewById(R.id.call3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        secondbtn_Launcher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if(result.getResultCode()== Activity.RESULT_OK){
                                    //callee역할을 하는 액티비티에서 실행을 끝낸 후 값을 공유한
                                    //인텐트를 사용함 즉, 기존의 인텐트(SecondActivity에서 공유한)를 불러오기
                                    Intent intent = result.getData();
                                    String returndata = intent.getStringExtra("second");
                                    Toast.makeText(ReturnDataFirstActivity_Callback.this,"launch"+returndata,
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.btnExit){
		    finish();
        }else if(v.getId()==R.id.call1){
		    Intent intent = new Intent();
		    intent.putExtra("info","첫 번째 액티비티가 넘기는 메시지");
		    startActivity(intent);//에러발생!!!
        }else if(v.getId()==R.id.call2){
		    //새로운 액티비티를 실행해서 작업을 완료하고 되돌아오는 작업을 처리
            Intent intent = new Intent(this,ReturnDataSecondActivity.class);
            intent.putExtra("code","call2");
            intent.putExtra("data","첫 번째 액티비가 넘기는 메시지");

            secondbtn_Launcher.launch(intent);

        }else if(v.getId()==R.id.call3){
            Intent intent = new Intent(this,ReturnDataSecondActivity.class);
            intent.putExtra("code","call3");
            intent.putExtra("data","첫 번째 액티비가 넘기는 메시지2");

            startActivityForResult(intent,THIRD_BUTTON);
		}
    }
}









































