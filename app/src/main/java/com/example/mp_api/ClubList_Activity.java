package com.example.mp_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClubList_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_list);
        vollyRequest();
    }

    public void vollyRequest(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://demo2987659.mockable.io/clublist";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("result",response);
                decodeJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("exception in response", error.toString());
            }
        });

        queue.add(stringRequest);
    }

    public void decodeJson(String response){
        try {
            ArrayList<DataModel> data = new ArrayList<>();
            JSONObject result = new JSONObject(response);
            JSONArray array = result.getJSONArray("clubs");
            for (int i=0; i<array.length();i++){
                JSONObject club=array.getJSONObject(i);
                int id = club.getInt("id");
                String name = club.getString("clubname");
                String address = club.getString("clubaddress");
                String fee = club.getString("clubentryfee");
                String type = club.getString("clubtype");
                DataModel dataModel = new DataModel(id,name,address,fee,type);
                data.add(dataModel);
            }
            layoutManager = new LinearLayoutManager(this);
            recyclerView = findViewById(R.id.lvClubList);
            recyclerView.setLayoutManager(layoutManager);
            recyclerAdapter = new ClubList_RecycleView_Adapter(ClubList_Activity.this, data);
            recyclerView.setAdapter(recyclerAdapter);
            }catch (Exception ex){
            Log.d("exception in decode", ex.toString());
        }
    }
}