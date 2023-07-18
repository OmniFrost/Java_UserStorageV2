package com.izdeveloper.userstorageappv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

public class ListUsersActivity extends AppCompatActivity {

    private UserStorage userList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        userList = UserStorage.getSingle();

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(getApplicationContext(), userList.getUsers());
        recyclerView.setAdapter(new ListAdapter(getApplicationContext(), userList.getUsers()));


        for (User i : userList.getUsers()) {
            Log.d("UserStorage", i.getName() + " " + i.getSurname() + " " + i.getEmail() + " " + i.getDegree());
        }
    }
}