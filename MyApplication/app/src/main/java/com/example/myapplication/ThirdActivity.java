package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private int index;
    private RecyclerView listRv;
    private ListAdapter listAd;
    private List<ListModel> listMod;
    private Button btnBack, btnAdd, btnRemove;
    private String strUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", strDown = "abcdefghijklmnopqrstuvwxyz";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initializeViews();
        initializeList();
        setRecycleView();
        setOnClickListeners();

    }

    private void initializeList(){
        listMod = new ArrayList<>();
        listMod.add(new ListModel("A","a"));
        listMod.add(new ListModel("B","b"));
        listMod.add(new ListModel("C","c"));
        listMod.add(new ListModel("D","d"));
        index = 3;
    }

    private void initializeViews(){

        listRv = findViewById(R.id.rv_list);
        btnBack = (Button) findViewById(R.id.btn_back2);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnRemove = (Button) findViewById(R.id.btn_remove);
    }

    private void setRecycleView(){
        listAd = new ListAdapter(listMod);
        listRv.setLayoutManager(new LinearLayoutManager(this));
        listRv.setAdapter(listAd);
    }

    private void setOnClickListeners(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem();
            }
        });
    }

    private void addItem(){
        if(index == 25){
            Toast.makeText(this,"Nu mai puteti adauga elemente",Toast.LENGTH_SHORT).show();
        }
        else{
            index++;
            listMod.add(new ListModel(String.valueOf(strUp.charAt(index)),String.valueOf(strDown.charAt(index))));
            listAd.notifyDataSetChanged();
        }
    }

    private void removeItem(){
        if(index > 0){
            listMod.remove(index);
            listAd.notifyDataSetChanged();
            index--;
        }
        else{
            Toast.makeText(this,"Nu puteti sterge primul element",Toast.LENGTH_SHORT).show();
        }

    }

}
