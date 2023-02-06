package com.example.strayers;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Request extends AppCompatActivity {

        ListView listViw;
        String[] arr = {"This is", "Item1", "item3"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_request);
            Log.d(TAG, "AdoptMeDashboard: ");
            listViw = findViewById(R.id.reque);


            // using custom Adapter
            RequestLayout ada = new RequestLayout(this, R.layout.activity_request_layout, arr);
            listViw.setAdapter(ada);
            listViw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(Request.this, "You Clicked on position "+i, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }