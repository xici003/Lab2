package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> listContact;
    MyAdapter contactListViewAdapter;
    ListView listViewContact;

    Button btnXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listContact = new ArrayList<>();
        listContact.add(new Contact(1,"Mot","34567",false));
        listContact.add(new Contact(2,"Hai","0987",true));
        listContact.add(new Contact(3,"Ba","56789",true));

        contactListViewAdapter = new MyAdapter(listContact);

        listViewContact = findViewById(R.id.listview);
        listViewContact.setAdapter(contactListViewAdapter);

        btnXoa = findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}