package com.example.user_profile_db;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText userID, userName, userPass;
    Button save, search, edit, delete, list;
    MyDatabase myDatabase;
    Cursor mycursor;

    //Create obj
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID=(EditText) findViewById(R.id.eId);
        userName=(EditText) findViewById(R.id.eName);
        userPass=(EditText) findViewById(R.id.ePass);
        save=(Button) findViewById(R.id.btnSave);
        search=(Button) findViewById(R.id.btnSearch);
        edit=(Button) findViewById(R.id.btnEdit);
        delete=(Button) findViewById(R.id.btnDelete);
        list=(Button) findViewById(R.id.btnList);
        myDatabase =new MyDatabase(this);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.InsertData(userID.getText().toString(),
                                    userName.getText().toString(),
                                    userPass.getText().toString());
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor mycursor=myDatabase.SearchData(userID.getText().toString().trim());
                if(mycursor.moveToFirst()){
                    userName.setText(mycursor.getString(1));
                    userPass.setText(mycursor.getString(2));
                }else{
                    Toast.makeText(MainActivity.this, "Not found", Toast.LENGTH_SHORT).show();

                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userID.getText().toString().equals("")) {
                    Cursor mycursor=myDatabase.SearchData(userID.getText().toString().trim());
                    if(mycursor.moveToFirst()){
                        myDatabase.EditData(userID.getText().toString().trim(),userName.getText().toString(),userPass.getText().toString());
                        Toast.makeText(MainActivity.this, "User edited successfully!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "User id not allow null!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Cursor cursor=myDatabase.SearchData(userID.getText().toString().trim());
                    if(cursor.moveToFirst()){
                        myDatabase.DeleteData(userID.getText().toString().trim());
                        Toast.makeText(MainActivity.this, "Record deleted successfully!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                    }
                }

        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, User_List.class);
                startActivity(intent);
            }
        });





    }

}