package com.example.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTestActivity extends AppCompatActivity {
    //두 줄 텍스트로 리스트뷰를 구성
    ArrayList<HashMap<String,String>> datalist = new ArrayList<HashMap<String,String>>();
    ListView listView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_test);
        listView = findViewById(R.id.simplelist);
        txt = findViewById(R.id.simpleTxt);
        //리스트를 구성할 샘플 데이터 준비
        HashMap<String,String> item = new HashMap<String, String>();
        item.put("name","김");
        item.put("telnum","01011223311");
        datalist.add(item);

        item = new HashMap<String, String>();
        item.put("name","이");
        item.put("telnum","01011223322");
        datalist.add(item);

        item = new HashMap<String, String>();
        item.put("name","박");
        item.put("telnum","01011223333");
        datalist.add(item);

        item = new HashMap<String, String>();
        item.put("name","홍");
        item.put("telnum","01011223344");
        datalist.add(item);

        SimpleAdapter adapter = new SimpleAdapter(this,
                datalist, //HashMap으로 구성된 데이터가 저장된 리스트
                android.R.layout.simple_list_item_2, //row디자인
                new String[]{"name","telnum"}, //HashMap에 저장된 key목록
                new int[]{android.R.id.text1,android.R.id.text2});//어떤 view에 출력할 것인지
        listView.setAdapter(adapter);
    }
}