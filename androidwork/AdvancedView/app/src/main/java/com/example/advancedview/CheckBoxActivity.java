package com.example.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity
        implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    TextView text1;
    CheckBox[] checkArr = new CheckBox[3];
    Switch myswitch;
    Button setCheckbtn;
    Button showCheckbtn;
    Button clearCheckbtn;
    Button reverseCheckStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        //뷰의 주소값을 가지고 오기 - 26버전부터 캐스팅하지 않아도 된다.
        text1 = findViewById(R.id.checktxt);
        checkArr[0] = findViewById(R.id.check1);
        checkArr[1] = findViewById(R.id.check2);
        checkArr[2] = findViewById(R.id.check3);
        setCheckbtn = findViewById(R.id.btncheck1);
        showCheckbtn = findViewById(R.id.btncheck2);
        clearCheckbtn = findViewById(R.id.btncheck3);
        reverseCheckStatus = findViewById(R.id.btncheck4);
        myswitch = findViewById(R.id.switch1);

        //체크박스, 버튼에 리스너 설정하기
        for(int i=0; i<checkArr.length; i++){
            checkArr[i].setOnCheckedChangeListener(this);
        }
        setCheckbtn.setOnClickListener(this);
        showCheckbtn.setOnClickListener(this);
        clearCheckbtn.setOnClickListener(this);
        reverseCheckStatus.setOnClickListener(this);
        myswitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btncheck1:
                //모든 박스 설정
                setCheckVal(true);
                break;
            case R.id.btncheck2:
                //모든 박스 상태를 TextView에 출력
                getCheckStatus();
                break;
            case R.id.btncheck3:
                //모든 박스 해제
                setCheckVal(false);
                break;
            case R.id.btncheck4:
                //선택이면 해제, 해제면 선택
                reverseStatus();
                break;
        }
    }
    //모든 박스 상태를 TextView에 출력
    public void getCheckStatus(){
        text1.setText("");
        for(int i=0; i<checkArr.length; i++){
            if(checkArr[i].isChecked()){
                String tag = (String)checkArr[i].getTag();
                text1.append(tag+"번 설정됨\n");
            }else {
                String tag = (String)checkArr[i].getTag();
                text1.append(tag+"번 해제됨\n");
            }
        }
    }

    //선택이면 해제, 해제면 선택
    public void reverseStatus(){
        for(int i=0; i<checkArr.length; i++){
            checkArr[i].toggle();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //Log.d("Lee",buttonView.toString()+"====="+isChecked+"====="+buttonView.getTag());
        if(buttonView instanceof CheckBox){
            display(Integer.parseInt(buttonView.getTag()+""),isChecked);
        }else{
            //스위치가 선택
            if(buttonView.getId()==R.id.switch1) {
                String msg = "";
                if (buttonView.isChecked()) { //isChecked()는 체크 상태인지 확인하는 것
                    msg = "활성상태";
                } else {
                    msg = "비활성상태";
                }
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }
    //체크박스의 상태가 변경될 때 호출되는 메소드
    //체크박스가 선택되면 Toast가 "XXX체크 박스 선택", 해제되면 "XXX 체크 박스 해제" 메시지
    //스위치도 체크해제에 따라 토스트를 출력하기
    //TextView출력
    //checkStatus=>선택유무값
    //index=> 선택, 해제된 체크박스를 구분할 수 있는 태그값
    public void display(int index, boolean checkStatus){
        if(checkStatus){
            text1.setText(index+"체크박스가 선택");
        }else {
            text1.setText(index+"체크박스가 해제");
        }
    }
    //모든 체크박스의 상태를 체크 상태로 설정 - 매개변수를 이용해서 설정 및 해제 작업을 처리
    public void setCheckVal(boolean chkval){
        //모든 체크박스 체크되거나 해제될 수 있도록 구현
        //체크 상태설정,해제 버튼을 누르면 실행되도록 구현
        for(int i=0; i<checkArr.length; i++){
            checkArr[i].setChecked(chkval);
        }
    }
}