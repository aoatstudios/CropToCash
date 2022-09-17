package com.example.croptocash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.croptocash.model.Exhibit;
import com.example.croptocash.model.ExhibitLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestExhibitsLoader extends AppCompatActivity {

    private LottieAnimationView animationView;
    List<Exhibit> exhibitList;
    private RecyclerView recyclerView;
    private ExhibitLoader exhibitLoader;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibits_loader);

        mToolbar = findViewById(R.id.nav_action);
        mToolbar.setTitle(R.string.app_name);
//        setSupportActionBar(mToolbar);

        recyclerView = findViewById(R.id.exhibits_list);
        animationView = findViewById(R.id.animationView);
        exhibitList = new ArrayList<>();

        getExhibitList();

    }

    private void getExhibitList() {
        String url = "https://my-json-server.typicode.com/Reyst/exhibit_db/list";

        new Thread(new Runnable() {
            @Override
            public void run() {
                Http http = new Http(RestExhibitsLoader.this, url);
                http.send();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Integer code = http.getStatusCode();

                        if (code == 200) {
                            animationView.setVisibility(View.GONE);
                            //Getting JSON response
                            try {
                                //Convert http response into jsonObject
                                JSONArray response = new JSONArray(http.getResponse());


                                //iterating through the array list
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject objectArray = response.getJSONObject(i);

                                    Exhibit exhibit = new Exhibit();
                                    exhibit.setTitle(objectArray.getString("title"));


                                    JSONArray imgs = objectArray.getJSONArray("images");

                                    for (int y = 0; y < imgs.length(); y++) {
//                                        exhibit.setImage1(imgs.getString(y));

                                        if (imgs.length() == 3){
                                            exhibit.setImage1(imgs.getString(0));
                                            exhibit.setImage2(imgs.getString(1));
                                            exhibit.setImage3(imgs.getString(2));

                                            exhibit.setLength(3);

                                        }
                                        if (imgs.length() == 4){
                                            exhibit.setImage1(imgs.getString(0));
                                            exhibit.setImage2(imgs.getString(1));
                                            exhibit.setImage3(imgs.getString(2));
                                            exhibit.setImage4(imgs.getString(3));

                                            exhibit.setLength(4);

                                        }

                                        if (imgs.length() == 5){
                                            exhibit.setImage1(imgs.getString(0));
                                            exhibit.setImage2(imgs.getString(1));
                                            exhibit.setImage3(imgs.getString(2));
                                            exhibit.setImage4(imgs.getString(3));
                                            exhibit.setImage4(imgs.getString(4));

                                            exhibit.setLength(5);

                                        }
                                    }
                                    exhibitList.add(exhibit);

                                }
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                exhibitLoader = new ExhibitLoader(getApplicationContext(), exhibitList);
                                recyclerView.setAdapter(exhibitLoader);


                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(RestExhibitsLoader.this, "Exception: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else {

                            Toast.makeText(RestExhibitsLoader.this, "Error " + code, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }
}