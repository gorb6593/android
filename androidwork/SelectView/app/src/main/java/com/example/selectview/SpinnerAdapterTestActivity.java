package com.example.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerAdapterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_adapter_test);
        Spinner spinner = findViewById(R.id.spinner01);
        TextView txtResult = findViewById(R.id.spinner_result);
        AutoCompleteTextView auto = findViewById(R.id.autoview);
        //Spinner를 위한 Adapter
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.mylist_data,
                android.R.layout.simple_spinner_item);
        //AutoCompleteTextView를 위한 Adapter
        ArrayAdapter autoadapter = ArrayAdapter.createFromResource(this,
                R.array.mylist_data,
                android.R.layout.simple_dropdown_item_1line);
        //Spinner를 선택했을 때 보여지는 목록에 적용할 디자인
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Spinner와 어댑터 연결
        spinner.setAdapter(adapter);
        //AutoCompleteTextView와 어댑터연결
        auto.setAdapter(autoadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //myrow = 선택된 row뷰에서 텍스트뷰를 찾아오기
                TextView myrow = view.findViewById(android.R.id.text1);
                //spinner에서 선택한 값을 텍스트뷰에 출력하기
                txtResult.setText(myrow.getText());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}