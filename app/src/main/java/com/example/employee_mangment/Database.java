package com.example.employee_mangment;

import static java.lang.Character.getName;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class Database  extends SQLiteOpenHelper {

    public static final String tableName = "employee";

    public static final String emp_name = "emp_name";
    public static final String emp_phone_no = "emp_phone_no";
    public static final String emp_address = "emp_address";
    public static final String emp_email = "emp_email";



    public static final String name="Employee_DB";
    public static final int version=2;

    public Database(
            Context context) {

        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+tableName+" ("+emp_name+" TEXT, "+emp_phone_no+" INTEGET, "+emp_address+" TEXT, "+emp_email+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean insertEmployee(Model model){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(emp_name,model.getName());
        values.put(emp_phone_no,model.getPhone_no());
        values.put(emp_address,model.getAddrees());
        values.put(emp_email,model.getEmail());

       long reslut= db.insert(tableName,null,values);
       if (reslut == -1)
           return false;
       return true;
    }

    //---> Upadate Data Employee
    public boolean updateEmployee(Model model){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(emp_name,model.getName());
        values.put(emp_phone_no,model.getPhone_no());
        values.put(emp_address,model.getAddrees());
        values.put(emp_email,model.getEmail());

        String agre [] ={model.getName()+""};
        int reslut= db.update(tableName,values,"emp_name=?",agre);
        return  reslut > 0;
    }

    //---> Count of Employee
    public long countOfEmployee(){
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db,tableName);
    }

    public boolean deleteEmployee(String name){
        SQLiteDatabase db = getWritableDatabase();
        String agre [] ={name};

        int reslut= db.delete(tableName,"emp_name=?",agre);
        return  reslut > 0;

    }

    //--> get All Data
    public ArrayList<Model> getAllEmployee(){
        ArrayList<Model> emps= new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName,null);
        if(cursor != null && cursor.moveToFirst())
            do{
                String name = cursor.getString(0);
                int phoneNo = cursor.getInt(1);
                String address = cursor.getString(2);
                String email = cursor.getString(3);
                Model model = new Model(name,phoneNo,address,email);
                emps.add(model);
            }while (cursor.moveToNext());
        cursor.close();
        return emps;
    }

    //---> Search one Employee
    public ArrayList<Model> getEmployee(String emp_name){
        ArrayList<Model> emps= new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName+"WHRER " +emp_name+"=?",new String [] {emp_name});
        if(cursor != null && cursor.moveToFirst())
            do{
                String name = cursor.getString(0);
                int phoneNo = cursor.getInt(1);
                String address = cursor.getString(2);
                String email = cursor.getString(3);
                Model model = new Model(name,phoneNo,address,email);
                emps.add(model);
            }while (cursor.moveToNext());
        cursor.close();
        return emps;
    }



}
