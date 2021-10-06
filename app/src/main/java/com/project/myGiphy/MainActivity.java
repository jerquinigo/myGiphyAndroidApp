package com.project.myGiphy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mEdit   = (EditText)findViewById(R.id.editText1);
//                mText = (TextView)findViewById(R.id.textView1);
//                mText.setText("Welcome "+mEdit.getText().toString()+"!");
                text2.setText(submitText.getText().toString());
           }
        });



    }
}