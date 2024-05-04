package com.example.user_profile_db;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class User_List extends AppCompatActivity {
    MyDatabase myDB=new MyDatabase(this);
    MyAdapter myAdapter;
    ListView UserList;
    ArrayList<User> myArrayList= new ArrayList<User>();


    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        UserList=(ListView) findViewById(R.id.lstUserList);

        //get all user from cursor add to arraylist
        Cursor myCursor=myDB.GetAllUser();
        while (myCursor.isAfterLast()==false){
            User myUser=new User(myCursor.getString(0),myCursor.getString(1),myCursor.getString(2));
//            Toast.makeText(this, myUser.getId(), Toast.LENGTH_SHORT).show();
            myArrayList.add(myUser);
            myCursor.moveToNext();

        }
       // Toast.makeText(this, myArrayList.size(), Toast.LENGTH_SHORT).show();
        //add array to myAdapter
        myAdapter=new MyAdapter(myArrayList,this);

        //add adapter to myAdapter
        UserList.setAdapter(myAdapter);



    }
}