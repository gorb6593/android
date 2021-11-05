package com.example.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewTestActivity extends AppCompatActivity {
    //1. ListView에 출력할 데이터
    String[] datalist = {"oracle","java","jdbc","html","css","javascript","jQuery",
                    "servlet","jsp","spring","hadoop","flume","sqoop","android"};
    ListView listView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview1);
        txt = findViewById(R.id.listtxt);
        //2. Adapter 객체 생성 - ListView에 출력할 데이터를 어떤 디자인으로 출력할지 정하기
            ArrayAdapter adapter = new ArrayAdapter(this,
                                   android.R.layout.simple_list_item_1,
                                   datalist);

        //3. ListView에서 어댑터가 뷰를 만들 수 있도록 ListView에 어댑터 연결
        listView.setAdapter(adapter);

        //이벤트연결
        MyListener listener = new MyListener();
        listView.setOnItemClickListener(listener);
    }
    class MyListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("kim",view.toString()+",position:"+position+",id:"+id);
            txt.setText(datalist[position]);
        }
    }
}