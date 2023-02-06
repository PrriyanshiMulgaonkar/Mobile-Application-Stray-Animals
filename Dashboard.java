package com.example.strayers;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {
    private SharedPrefrencesHelper sharedPrefrencesHelper;
    MenuItem option1, option2;
    ListView listView;
    TextView animalData;
    String item1, item2, item3;
    String[] arr = {"Ruby", "Sheru", "Merina"};
    private RequestQueue rQueue;
    ImageButton reqAdd;
    Button adoptMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefrencesHelper = new SharedPrefrencesHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        listView = findViewById(R.id.listview98);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option5);
        reqAdd = findViewById(R.id.re);
//        adoptMe = findViewById(R.id.adoptMe);

//        item1 = sharedPrefrencesHelper.getName1();
//        item2 = sharedPrefrencesHelper.getName1();
//        item3 = sharedPrefrencesHelper.getName1();

        if("2".equals(sharedPrefrencesHelper.getRole())){
            reqAdd = findViewById(R.id.re);
            reqAdd.setVisibility(View.VISIBLE);
        }
        else{
            reqAdd.setVisibility(View.INVISIBLE);
        }

//        Log.d(TAG, "onCreate: " + item1);
//        arr = {item1, item2, item3};

//        loginAction();

        // using array Adapter
        AdoptMeLayout ada = new AdoptMeLayout(this, R.layout.activity_adopt_me_layout, arr);
        listView.setAdapter(ada);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Dashboard.this, "You Clicked on position " + i, Toast.LENGTH_SHORT).show();
            }
        });

    }

//    private void loginAction() {
////        Toast.makeText(SmallTripSearchResult.this, "hiiiiiii it is out", Toast.LENGTH_SHORT).show();
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, getResources().getString(R.string.url) + "strayData.php",
//                response ->  {
//                    rQueue.getCache().clear();
//                    Log.e("anyText", response);
////                    String name = "", vacci = "", info = "";
//                    animalData = findViewById(R.id.animalData);
//                    String data = "";
//
//                    try {
////                        JSONObject jsonObject = new JSONObject(response);
//                        JSONObject jsonRootObject = new JSONObject(response);
//                        JSONArray jsonArray = jsonRootObject.optJSONArray("details");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            int id = 0;
//                            String name1 = "", vac = "", Des = "";
//
//                            JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                                id = Integer.parseInt(jsonObject.optString("animalId").toString());
//                                name1 = jsonObject.optString("name");
//                                vac = jsonObject.optString("vaccinated");
//                                Des = jsonObject.optString("info");
//
//                                data += "Name - " + name1+"\n Vaccination Status - "+vac+"\nInfo - " +Des+"\n\n\n";
//
////                                name += "Name = " + name;
////                                info += "Description - " + Des;
////                                vacci += "Location - " + vac;
//
//                        }
//                        animalData.setText(data);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(Dashboard.this, error.toString(), Toast.LENGTH_LONG).show();
//                    }
//                });
//        rQueue = Volley.newRequestQueue(Dashboard.this);
//        rQueue.add(stringRequest);
//    }




        public void Acc(View view) {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void time(View view) {
        Intent intent = new Intent(this, Timeline.class);
        startActivity(intent);
    }

    public void req(View view) {
        Intent intent = new Intent(this, Request.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.option1:
                Intent intent = new Intent(this, help.class);
                startActivity(intent);
                return true;
            case R.id.option5:
                Intent intent1 = new Intent(this, AddStray.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
