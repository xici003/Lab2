package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {
    public static final String TableName = "ContactTable";
    public static final String Id = "Id";
    public static final String Name = "Fullname";
    public static final String Phone = "Phonenumber";
    public static final String Image = "Image";

    public static final  String Status = "Status";
    public MyDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "Create table if not exists "+ TableName + " ("
                + Id + " Integer Primary key, "
                + Name + " Text, "
                + Phone + " Text, "
                + Image + " Text, "
                + Status + " Integer)";

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //xoá bảng TableContact đã có
        db.execSQL("Drop table if exists "+ TableName);

        //taoj laij
        onCreate(db);
    }

    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact> list = new ArrayList<>();
        String sql = "Select * from " + TableName;
        //Lay doi tuong csdl
        SQLiteDatabase db = this.getReadableDatabase();
        //chạy câu truy vấn về dạng Cursor
        Cursor cursor = db.rawQuery(sql,null);
        //tạo ArrayList<Contact> ể trả về
        if(cursor!=null){
            while (cursor.moveToNext()){
                Contact contact = new Contact(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4));
                list.add(contact);
            }
        }

        return list;
    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, contact.getId());
        value.put(Name, contact.getName());
        value.put(Phone, contact.getPhoneNumber());
        value.put(Image, contact.getImage());
        value.put(Status,contact.isStatus());
        db.insert(TableName, null, value);
        db.close();
    }
    public void updateContact(int id, Contact contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Id, contact.getId());
        value.put(Name, contact.getName());
        value.put(Phone, contact.getPhoneNumber());
        value.put(Image, contact.getImage());
        db.update(TableName,value,Id + "=?",
                new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteContact(int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM " + TableName + " WHERE " + Id + " = " + id;
        db.execSQL(sql);
        db.close();
    }

}
