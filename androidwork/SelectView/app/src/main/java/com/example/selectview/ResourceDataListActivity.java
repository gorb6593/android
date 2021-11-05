package com.example.selectview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/*
    리소스로 저장되어 있는 데이터를 ListView에 출력하기
 */
public class ResourceDataListActivity extends AppCompatActivity {
    ListView listView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview1);
        txt = findViewById(R.id.listtxt);
        //리소스로 지정된 데이터를 이용해서 어댑터를 만드는 경우 ArrayAdapter의 Static메소드 이용
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.mylist_data,
                android.R.layout.simple_list_item_1);

        //3. ListView에서 어댑터가 뷰를 만들 수 있도록 ListView에 어댑터 연결
        listView.setAdapter(adapter);

        //이벤트연결
        MyListener listener = new MyListener();
        listView.setOnItemClickListener(listener);
    }
    class MyListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //View view매개변수가 목록을 구성하는 하나의 데이터가 출력되는 row
            TextView listrow_view = (TextView)view;
            txt.setText(listrow_view.getText());
        }
    }
}