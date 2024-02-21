package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddView extends AppCompatActivity {
    private EditText txtid,txtname, txtphone;
    private Button btnAdd;
    private ArrayList<Contact> data;
    private MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);
        txtid = findViewById(R.id.txtId);
        txtname = findViewById(R.id.txtName);
        txtphone = findViewById(R.id.txtPhone);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = Integer.parseInt(txtid.getText().toString());
                    String name = txtname.getText().toString();
                    String phone = txtphone.getText().toString();
                    // Kiểm tra xem các trường có rỗng không
                    if (name.isEmpty() || phone.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Intent intent = new Intent();
                        //Bundle ở đây được sử dụng để đóng gói dữ liệu
                        // và gửi nó từ Activity hiện tại đến Activity khác thông qua Intent
                        Bundle b = new Bundle();
                        b.putInt("Id", id);
                        b.putString("Name", name);
                        b.putString("Phone", phone);
                        intent.putExtras(b);
                        setResult(150, intent);
                        finish();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập số cho ID", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}