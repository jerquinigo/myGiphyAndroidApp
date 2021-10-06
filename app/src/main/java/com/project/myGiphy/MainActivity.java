package com.project.myGiphy;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.Arrays;

import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text2 = findViewById(R.id.textView1);
        EditText submitText = findViewById(R.id.searchField);
        Button submitButton = findViewById(R.id.submitButton);
        final String[] queryResults = new String[1];

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mEdit   = (EditText)findViewById(R.id.editText1);
//                mText = (TextView)findViewById(R.id.textView1);
//                mText.setText("Welcome "+mEdit.getText().toString()+"!");
                text2.setText(submitText.getText().toString().trim());
                queryResults[0] = submitText.getText().toString().trim();
                System.out.println(Arrays.toString(queryResults));
           }
        });

        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url().build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String run(String url) throws IOException {
//            Request request = new Request.Builder()
//                    .url(url)
//                    .build();

//            try (Response response = client.newCall(request).execute()) {
//                return response.body().string();
//            }
//        }


    }
}