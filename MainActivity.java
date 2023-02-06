package com.example.strayers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {

    EditText user, pasword;
    Button loginBtn;
    private RequestQueue rQueue;
    private SharedPrefrencesHelper sharedPrefrencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user = findViewById(R.id.user);
        pasword = findViewById(R.id.pasword);
        loginBtn = findViewById(R.id.loginBtn);
        sharedPrefrencesHelper = new SharedPrefrencesHelper(this);


//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loginAction();
//            }
//        });
    }
//    private void loginAction() {
//        final String userr = user.getText().toString();
//        final String pswd = pasword.getText().toString();
//        if (userr.isEmpty()) {
//            user.setError("Username or Email is required");
//            user.requestFocus();
//            return;
//        }
//        if (pswd.isEmpty()) {
//            pasword.setError("Password is required");
//            pasword.requestFocus();
//            return;
//        }
//        Toast.makeText(MainActivity.this, "before STRING REQ! ", Toast.LENGTH_SHORT).show();
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, getResources().getString(R.string.url) + "login.php",
//                response -> {
//                    rQueue.getCache().clear();
//                    Toast.makeText(MainActivity.this, "get CACHE! ", Toast.LENGTH_SHORT).show();
//                    Log.e("anyText",response);
//                    try {
//                        Toast.makeText(MainActivity.this, "in TRY! ", Toast.LENGTH_SHORT).show();
//                        JSONObject jsonObject = new JSONObject(response);
//                        if (jsonObject.optString("success").equals("1")) {
//                            JSONObject jsonObject1 = jsonObject.getJSONObject("details");
//
//                            sharedPrefrencesHelper.setMail_id(jsonObject1.getString("Mail_id"));
//                            sharedPrefrencesHelper.setName(jsonObject1.getString("Name"));
//                            sharedPrefrencesHelper.setCity(jsonObject1.getString("City"));
//                            sharedPrefrencesHelper.setContact(jsonObject1.getString("Contact"));
//                            sharedPrefrencesHelper.setPassword(jsonObject1.getString("Password"));
//                            sharedPrefrencesHelper.setRole(jsonObject1.getString("Role"));
//
//                            Toast.makeText(MainActivity.this, "Login Successfully! ", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getBaseContext(), Dashboard.class));
//                            finish();
//                        } else {
//                            Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("user", userr);
//                params.put("pasword", pswd);
//                return params;
//            }
//
//        };
//        rQueue = Volley.newRequestQueue(MainActivity.this);
//        rQueue.add(stringRequest);
//    }
    public void Register (View view){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void AdoptMe (View view){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }


}