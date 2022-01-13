package com.example.fun_with_flags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> li = new ArrayList<>();
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String URL = "https://restcountries.com/v2/region/asia";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        Country_Adapter country_adapter = new Country_Adapter(this,R.layout.country_layout,li);
        /*listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));*/

        //using okHttp
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String json = response.body().string();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //tx.setText(x);
                            create(json);
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                            listView.setAdapter(country_adapter);
                        }
                    });
                }
            }
        });
    }
    public void create(String h){
        if(h.length() == 0)
            Toast.makeText(this,"Empty Response",Toast.LENGTH_LONG).show();
        try {
            JSONArray root = new JSONArray(h);
           for(int i = 0; i< root.length(); i++){
               JSONObject obj = root.getJSONObject(i);
               JSONObject image = obj.getJSONObject("flags");
               JSONArray languages = obj.getJSONArray("languages");
               JSONArray borders = obj.getJSONArray("borders");
               String s = "";
               String s1 = "";
               for(int x = 0; x<borders.length(); x++) s += borders.get(x)+" ";
               for(int x = 0; x<languages.length(); x++)s1 += languages.getJSONObject(x).getString("name")+" ";

               li.add(new Country(obj.getString("name"),obj.getString("region"), obj.getString("capital")
                       , image.getString("png"),obj.getString("subregion"),s1,s,obj.getString("population")));
           }
        }
        catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }


    }
}