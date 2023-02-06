package com.example.strayers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Timeline extends AppCompatActivity {
    ListView listView;
    Button adoptMe;
    String[] arr = {"This is", "Item1", "item3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        listView = findViewById(R.id.listview1);
        adoptMe = findViewById(R.id.adoptMe);
//        adoptMe.setVisibility(View.GONE);

        AdoptMeLayout ada = new AdoptMeLayout(this, R.layout.activity_adopt_me_layout, arr);
        listView.setAdapter(ada);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Timeline.this, "You Clicked on position "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}