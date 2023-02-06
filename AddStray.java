package com.example.strayers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class AddStray extends AppCompatActivity {
    private SharedPrefrencesHelper sharedPrefrencesHelper;
    EditText name, vaccinated, Info;
    Button submit;
    private RequestQueue rQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPrefrencesHelper = new SharedPrefrencesHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stray);
        name = findViewById(R.id.name);
        vaccinated = findViewById(R.id.vaccinated);
        Info = findViewById(R.id.Info);
        submit = findViewById(R.id.submited);

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            registerAction();
        }
    });
    }

    private void registerAction() {
        final String sname = name.getText().toString();
        final String vac = vaccinated.getText().toString();
        final String info = Info.getText().toString();

        if (sname.isEmpty()) {
            name.setError("Email is required");
            name.requestFocus();
            return;
        }
        if (vac.isEmpty()) {
            vaccinated.setError("Name is required");
            vaccinated.requestFocus();
            return;
        }


        StringRequest stringRequest = new StringRequest(Request.Method.POST, getResources().getString(R.string.url) + "strayAdd.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AddStray.this, "Animal is", Toast.LENGTH_SHORT).show();
                        rQueue.getCache().clear();
                        Log.e("RegisterActivity before TRY",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.optString("success").equals("1")) {
                                Toast.makeText(AddStray.this, "Animal is Up For Adoption", Toast.LENGTH_SHORT).show();
                                sharedPrefrencesHelper.setName1(sname);
                                sharedPrefrencesHelper.setVaccinated(vac);
                                sharedPrefrencesHelper.setInfo(info);

                                startActivity(new Intent(getBaseContext(), Dashboard.class));
                                finish();
                            } else {
                                Toast.makeText(AddStray.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddStray.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("sname", sname);
                params.put("vac", vac);
                params.put("info", info);
                return params;
            }
        };
        rQueue = Volley.newRequestQueue(AddStray.this);
        rQueue.add(stringRequest);
    }
}