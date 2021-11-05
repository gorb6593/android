package com.example.datamanagement.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
    데이터베이스가 업데이트되거나 DB를 처음 생성하는 경우 사용할 클래스
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 3;
    public DBHelper(Context context){
        //파일의 형태로 데이터가 저장되고 관리된다. - 이 코드가 데이터베이스를 오픈하고 연결
        super(context,"test.db",null,DB_VERSION);
    }
    /*
        앱이 설치되고 SQLiteOpenHelper가 최초로 호출될 때 한 번만 실행
        앱을 최초로 다운로드 받는 사람들을 위해서 만든 메소드 - 항상 최신으로 유지
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("kim","데이터베이스가 생성되었습니다.");
        //테이블생성
        String sql = "create table if not exists member("
                    + "idx integer primary key autoincrement,"
                    + "id text,"
                    + "name text,"
                    + "age integer)";
        db.execSQL(sql);
    }
    /*
        데이터베이스의 버전이 변경될 때마다 호출되는 메소드
        스키마가 변경되면 호출되어 업데이트에 관련된 여러가지 처리를 구현
        기존 사용자들이 변경된 내용을 반영하려 할때 호출되는 메소드
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("kim", "데이터베이스의 스키마가 변경되었습니다. oldVersion"+oldVersion+",newVersion:"+newVersion);
        switch (oldVersion){
            case 1:
                //1버전에서 2버전으로 넘어갈때 처리해야 하는 것을 구현
            case 2:
                //2 -> 3
                Log.d("kim", "3버전입니다. 데이터를 백업받고 처리될 수 있도록 구현");
            case 3:
                //3 -> 4

        }
    }
}
