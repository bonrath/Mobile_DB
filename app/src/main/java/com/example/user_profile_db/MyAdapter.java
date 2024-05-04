package com.example.user_profile_db;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<User> arrayList=new ArrayList<User>();
    Activity myContent;

    public MyAdapter(ArrayList<User> arrayList, Activity myContent) {
        this.arrayList = arrayList;
        this.myContent = myContent;
    }

    @Override
    public int getCount(){return arrayList.size();}

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View v= view;
//        if(v==null){
            LayoutInflater layoutInflater=myContent.getLayoutInflater();
            v=layoutInflater.inflate(R.layout.row_item,null);

//        }
        //Use Id Uname Pword to store txtid txtUname txtpass from signle row
        TextView Uid=(TextView) v.findViewById(R.id.txtId);
        TextView Uname=(TextView) v.findViewById(R.id.txtUname);
        TextView Upass=(TextView) v.findViewById(R.id.txtPass);


        User U = arrayList.get(i);
        Uid.setText(arrayList.get(i).getId());
        Uname.setText(arrayList.get(i).getName());
        Upass.setText(arrayList.get(i).getPass());
        return v;

    }
}
