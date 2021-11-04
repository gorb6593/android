package com.example.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

public class BasicAppRun extends AppCompatActivity {
    //승인을 받을 권한의 목록
    String[] permission_list = {Manifest.permission.CALL_PHONE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_app_run);
        rumPermission();
    }
    //권한을 체크하는 메소드 - 승인처리
    public void rumPermission(){
        //하위버전이면 실행되지 않도록 설정 -M(23)버전보다 낮으면 종료
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return;//메소드종료
        }
        //모든 권한을 셀프로 체크
        for(String permission:permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list, 0);
                break;
            }
        }
    }
    //안드로이드에 등록된 액션으로 암시적인텐트를 호출 - 데이터가 필요
    //데이터의 셋팅은 Uri객체로 만들기
    //구글맵실행
    public void runGoogleMap(View v){
        Uri uri = Uri.parse("geo:37.50940483611031, 127.0589353743628");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //웹브라우저실행
    public void runWeb(View v){
        Uri uri = Uri.parse("https://www.daum.net");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    //전화걸기화면만 실행
    public void runDial(View v){
        //사용할 데이터를 ()안에 등록 이때, 접두사를 이용해서 파싱하므로 적절하게 사용
        Uri uri = Uri.parse("tel:0000000");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    //실제 전화 걸기 위한 메소드
    public void runCallPhone(View v) {
        int chk = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (chk == PackageManager.PERMISSION_GRANTED) {
            Log.d("LEE", "성공");
            Uri uri = Uri.parse("tel:0123456789");
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent);
        } else {
            Log.d("LEE", "실패");
            return;
        }
    }
}
