package com.example.datamanagement.exam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datamanagement.R;
import com.example.datamanagement.sqllite.ExamDBHelper;

public class MainActivity_Result extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    EditText edtName;
    EditText edtSu;
    EditText edtPrice;
    ListView listview;
    ExamDBHelper dbHelper;//데이터베이스 파일생성, 테이블생성,업데이트....
    SQLiteDatabase db;//로컬디비연동을 위한 핵심 클래스
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.btnIns).setOnClickListener(this);
        findViewById(R.id.btnResult).setOnClickListener(this);
        findViewById(R.id.btnResult2).setOnClickListener(this);
        findViewById(R.id.btnSearch).setOnClickListener(this);
        listview = findViewById(R.id.list);
        listview.setOnItemClickListener(this);
        //1. DBHelper생성
        dbHelper = new ExamDBHelper(this);
        //2. SQLiteDatabase생성
        db = dbHelper.getWritableDatabase();//읽기쓰기 가능하도록
        edtName = (EditText)findViewById(R.id.edtName);
        edtSu = (EditText)findViewById(R.id.edtSu);
        edtPrice = (EditText)findViewById(R.id.edtPrice);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnIns){
            String sql = "insert  into product(name,price,su,totPrice) values(?,?,?,?)";
            if(edtName.getText().toString().equals("")){
                Toast.makeText(this,"상품명을 입력하세요"
                        , Toast.LENGTH_LONG).show();
                return;

            }
            int price
                    = Integer.parseInt(edtPrice.getText().toString());
            int su
                    = Integer.parseInt(edtSu.getText().toString());
            int totPrice = price*su;
            db.execSQL(sql,new String[]{edtName.getText().toString(),price+"",su+"",totPrice+""});
        }else if(v.getId()==R.id.btnResult){
            String sql = "select * from product";
            Cursor c = db.rawQuery(sql,null);
            //만약에 일반 ArrayAdapter나 커스트마이징된 Adapter를 쓴다면
            //Cursor객체를 List나 배열로 변환
            String[] datas = new String[c.getCount()];//row의 개수가 리턴
            int count = 0;
            while(c.moveToNext()){
                int id = c.getInt(0);
                String name = c.getString(1);
                int price = c.getInt(2);
                int su = c.getInt(3);
                int totPrice = c.getInt(4);
                datas[count] = id+","+name+","+totPrice;
                count++;
            }
            ArrayAdapter adapter
                    = new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1,
                    datas);
            listview.setAdapter(adapter);
        }else if(v.getId()==R.id.btnResult2){
            //SimpleCursorAdapter를 이용해서 작업합니다.
        }else if(v.getId()==R.id.btnSearch){
            //SimpleCursorAdapter를 이용해서 작업합니다.
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}