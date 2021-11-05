package com.example.datamanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datamanagement.sqllite.DBHelper;
import com.example.datamanagement.sqllite.ExamDBHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText id;
    EditText price;
    EditText su;
    TextView result1;
    TextView result2;
    ExamDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        id = findViewById(R.id.edtName);
        price = findViewById(R.id.edtPrice);
        su = findViewById(R.id.edtSu);
        result1 = findViewById(R.id.btnResult);
        result2 = findViewById(R.id.btnResult2);

        dbHelper = new ExamDBHelper(this);
        db = dbHelper.getWritableDatabase();
    }
    public void insert1(View v){
        String sql = "insert into product values(?,?,?,0,0)";
        db.execSQL(sql, new String[]{id.getText().toString(),
                                    price.getText().toString(),
                                    su.getText().toString()});
        id.setText("");
        price.setText("");
        su.setText("");
        showToast("삽입성공");
    }
    ArrayList<HashMap<String,String>> datalist = new ArrayList<HashMap<String,String>>();
    ListView listView;
    TextView txt;
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}