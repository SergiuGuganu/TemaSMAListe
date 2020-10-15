package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    protected TextView txtView;
    protected Button btnBack, btnList;
    private String extraInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initializeViews();
        Intent intent = getIntent();
        extraInfo = intent.getStringExtra("extra");
        setTexts();
        setOnClickListeners();
    }

    private void initializeViews(){
        txtView = (TextView) findViewById(R.id.txt_view);
        btnBack = (Button) findViewById(R.id.btn_back1);
        btnList = (Button) findViewById(R.id.btn_goList);
    }

    private void setTexts(){
        txtView.setText(extraInfo);
    }

    private void setOnClickListeners(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToList();
            }

        });
    }

    private void goToList(){
        Intent intToList = new Intent(this, ThirdActivity.class);
        startActivity(intToList);
    }
}
