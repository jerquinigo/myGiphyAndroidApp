package com.project.myGiphy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class MainActivity extends AppCompatActivity {

    public JsonNode mainNode = null;
    public ObjectMapper objMapper = null;
    public OkHttpClient httpClient = new OkHttpClient();
    public JsonNode arrayNode;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy gfgPolicy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(gfgPolicy);
        }

        OkHttpClient http = this.httpClient;
        JsonNode jresult = null;
        final StringBuilder[] stringBuild = {new StringBuilder()};
        ObjectMapper dataMapper = new ObjectMapper();
                Request request = new Request.Builder()
                        .url("https://api.giphy.com/v1/gifs/trending?api_key=yourkeyhere&limit=20")
                        .build();

        try {
            Response response = httpClient.newCall(request).execute();
            jresult = dataMapper.readTree(response.body().string());
            this.arrayNode = jresult.path("data");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> urlArray = new ArrayList<>();
        this.arrayNode.forEach(el -> {
            urlArray.add(el.path("images").path("original").path("url").asText());

        });

        //LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        //ImageView image = findViewById(R.id.imageView);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        for(int i = 0; i < urlArray.size(); i++) {
//            ImageView image = new ImageView(this);
            //LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
            ImageView image = new ImageView(this);

            Glide.with(getBaseContext())
                    .load(urlArray.get(i))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.1f)
                    .into(image);

            layout.addView(image);

        }


//        TextView text2 = findViewById(R.id.textView1);
//        EditText submitText = findViewById(R.id.searchField);
//        Button submitButton = findViewById(R.id.submitButton);
//        final String[] queryResults = new String[1];
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println(v);
//                text2.setText(submitText.getText().toString().trim());
//                queryResults[0] = submitText.getText().toString().trim();
//                System.out.println(Arrays.toString(queryResults));
//           }
//        });




    }

}