package com.example.strayers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {
    TextView msgTV;
    Button logOut;
    private SharedPrefrencesHelper sharedPrefrencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        msgTV = findViewById(R.id.msgTV);
        logOut = findViewById(R.id.logOut);

        sharedPrefrencesHelper = new SharedPrefrencesHelper(this);
        msgTV.setText(sharedPrefrencesHelper.getName());

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefrencesHelper.setMail_id(null);
                sharedPrefrencesHelper.setName(null);
                sharedPrefrencesHelper.setContact(null);
                sharedPrefrencesHelper.setPassword(null);
                sharedPrefrencesHelper.setCity(null);
                startActivity(new Intent(UserProfile.this, MainActivity.class));
                finish();
            }
        });

    }

    public void Epost(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}


