package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected RelativeLayout relLay;
    protected LinearLayout linLay;
    protected Button diagButton, okButton, cancelButton;
    protected EditText diagEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setOnClickListeners();
    }

    private void initializeViews(){
        relLay = (RelativeLayout) findViewById(R.id.rel_layout_dialog);
        linLay = (LinearLayout) findViewById(R.id.lin_layout_dialog);
        diagButton = (Button) findViewById(R.id.btn_dialog);
        okButton = (Button) findViewById(R.id.btn_ok);
        cancelButton = (Button) findViewById(R.id.btn_cancel);
        diagEdit = (EditText) findViewById(R.id.et_dialog);
    }

    private void setOnClickListeners(){
        diagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(relLay.getVisibility() == View.INVISIBLE)
                { relLay.setVisibility(View.VISIBLE); diagButton.setText("Hide Dialog!");
                if(linLay.getVisibility() == View.INVISIBLE)
                    linLay.setVisibility(View.VISIBLE);}
                else {
                    if (relLay.getVisibility() == View.VISIBLE) {
                        relLay.setVisibility(View.INVISIBLE);
                        diagButton.setText("Show Dialog!");
                    }
                    if (linLay.getVisibility() == View.VISIBLE)
                        linLay.setVisibility(View.INVISIBLE);
                }
            }
        });

        okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nextActivity();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayToast();
            }
        });

    }
    private void nextActivity(){
        String inputValue = diagEdit.getText().toString();
        if (inputValue.isEmpty())
        {
            Toast.makeText(this, "Introduceti un text pentru a continua", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("extra",inputValue);
            startActivity(intent);
        }
    }

    private void displayToast(){
        Toast.makeText(this, "Introduceti un text iar apoi apasati Ok", Toast.LENGTH_SHORT).show();
    }

}