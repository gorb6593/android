package com.example.intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExamFirstActivity extends AppCompatActivity{
    EditText name;
    EditText tel;
    Button btn;
    Button btn2;
    TextView resultTxt;
    public static final int INPUT_DATA_RESULT_TEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        name = findViewById(R.id.EditText01);
        tel = findViewById(R.id.EditText02);
        btn  = findViewById(R.id.Button01);//입력완료
        btn2  = findViewById(R.id.Button02);//객체공유
        resultTxt = findViewById(R.id.first_return);

        ActivityResultLauncher<Intent> Launcher;
        Launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode()==Activity.RESULT_OK){
                                Intent intent = result.getData();
                                boolean state = intent.getBooleanExtra("chkVal",false);
                                if(state){
                                    resultTxt.setText("우수회원설정");
                                }else {
                                    resultTxt.setText("일반회원설정");
                                }
                            }
                    }
                });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //명시적 인텐트 - 실행할 액티비티의 클래스명을 직접 입력해서 처리
                Intent intent = new Intent(ExamFirstActivity.this, ExamSecondActivity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("tel", tel.getText().toString());
                Launcher.launch(intent);
            }
        });
    }
}
