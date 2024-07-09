package com.example.lmbapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    DBManager db;
    ArrayList<String> id, nomClient, prenomClient;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        db = new DBManager(MainActivity.this);
        id = new ArrayList<>();
        nomClient = new ArrayList<>();
        prenomClient = new ArrayList<>();

        displayData();

        customAdapter = new CustomAdapter(MainActivity.this, id, nomClient, prenomClient);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void displayData() {
        Cursor cursor = db.getAllClients();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                nomClient.add(cursor.getString(1));
                prenomClient.add(cursor.getString(2));
            }
        }
    }
}
