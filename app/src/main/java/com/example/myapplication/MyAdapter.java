package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    final ArrayList<Contact> listContact;

    public MyAdapter(ArrayList<Contact> listContact) {
        this.listContact = listContact;
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int position) {
        return listContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listContact.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.activity_contact_view2, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Contact contact = (Contact) getItem(position);

        if(contact.status == true){
            ((CheckBox) viewProduct.findViewById(R.id.checkbox)).setChecked(true);
        }else {
            ((CheckBox) viewProduct.findViewById(R.id.checkbox)).setChecked(false);
        }
        ((TextView) viewProduct.findViewById(R.id.txtTen)).setText(String.format(contact.name));
        ((TextView) viewProduct.findViewById(R.id.txtPhone)).setText(String.format(contact.phoneNumber));

        CheckBox checkBox = viewProduct.findViewById(R.id.checkbox);



        return viewProduct;
    }

}
