package com.example.strayers;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
public class   Registration extends AppCompatActivity {
    TextView loginTV;
    EditText mail1, name, contact, city, password, password1;
    Button submit;
    private RequestQueue rQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        loginTV = findViewById(R.id.loginTV);
        mail1 = findViewById(R.id.image);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.vaccinated);
        city = findViewById(R.id.Info);
        password = findViewById(R.id.password);
        password1 = findViewById(R.id.password1);
        submit = findViewById(R.id.submit);

//        loginTV.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getBaseContext(), LoginActivity.class));
//            }
//        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAction();
            }
        });
    }

    private void registerAction() {
        final String fname = mail1.getText().toString();
        final String lname = name.getText().toString();
        final String uname = contact.getText().toString();
        final String mail = city.getText().toString();
        final String pswd = password.getText().toString();
        final String pswd1 = password1.getText().toString();
        if (fname.isEmpty()) {
            mail1.setError("Email is required");
            mail1.requestFocus();
            return;
        }
        if (lname.isEmpty()) {
            name.setError("Name is required");
            name.requestFocus();
            return;
        }
        if (uname.isEmpty()) {
            contact.setError("Contact is required");
            contact.requestFocus();
            return;
        }
        if (mail.isEmpty()) {
            city.setError("City is required");
            city.requestFocus();
            return;
        }
        if (pswd.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if (!pswd.equals(pswd1)) {
            password1.setError("Password mismatch");
            password1.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getResources().getString(R.string.url) + "register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        rQueue.getCache().clear();
                        Log.e("RegisterActivity before TRY",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.optString("success").equals("1")) {
                                Toast.makeText(Registration.this, "Registered Successfully! Now Login", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getBaseContext(), MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(Registration.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("firstname", fname);
                params.put("lastname", lname);
                params.put("username", uname);
                params.put("email", mail);
                params.put("password", pswd);
                params.put("password1", pswd1);
                return params;
            }
        };
        rQueue = Volley.newRequestQueue(Registration.this);
        rQueue.add(stringRequest);
    }
}