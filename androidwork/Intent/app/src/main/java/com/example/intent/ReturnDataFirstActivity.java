package com.example.intent;



import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReturnDataFirstActivity extends AppCompatActivity
			implements OnClickListener{
    public static final int SECOND_BUTTON = 10;
    public static final int THIRD_BUTTON = 20;
	Button bt1;
	Button bt2;
    Button bt3;
    Button bt4;
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
            //값을 가지고 되돌아올때 사용되는 메소드가 startActivityForResult - 현재버전 deprecated
            //인텐트객체와 함께 requestcode를 함께 넘긴다.
            startActivityForResult(intent,SECOND_BUTTON);
        }else if(v.getId()==R.id.call3){
            Intent intent = new Intent(this,ReturnDataSecondActivity.class);
            intent.putExtra("code","call3");
            intent.putExtra("data","첫 번째 액티비가 넘기는 메시지2");

            startActivityForResult(intent,THIRD_BUTTON);
		}
	}
    /*
        인텐트를 통해서 액티비티를 호출하고 되돌아오는 경우 자동으로 onActivityResult를 호출한다.
        onActivityResult를 오버라이딩해서 작업을 구현
        requestCode => 요청했던 뷰를 구분하기 위한 코드
        resultCode => 결과코드
        data => Intent객체
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnintent) {
        super.onActivityResult(requestCode, resultCode, returnintent);
        Log.d("LEE",requestCode+"");
        switch (requestCode){
            case SECOND_BUTTON:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("second");
                    Toast.makeText(this,"1번버튼"+returndata,Toast.LENGTH_LONG).show();
                }
                break;
            case THIRD_BUTTON:
                if(resultCode==RESULT_OK){
                    String returndata = returnintent.getStringExtra("second");
                    Toast.makeText(this,"2번버튼"+returndata,Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}









































