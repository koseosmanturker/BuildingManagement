package com.example.siteynetimitakip.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.siteynetimitakip.Adapters.ApartmanSakiniAdapter;
import com.example.siteynetimitakip.DB.DB;
import com.example.siteynetimitakip.Entity.ApartmanSakini;
import com.example.siteynetimitakip.R;

import java.util.ArrayList;

public class ApartmanSakinleriniGosterActivity extends AppCompatActivity {

    private int id;

    private RecyclerView apartmanSakinleriRecylerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartman_sakinlerini_goster);

        apartmanSakinleriRecylerView = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        ArrayList<ApartmanSakini> apartmanSakinleri = DB.getInstance(this).getAllAparment();
        displayNotes(apartmanSakinleri);

    }

    protected void onResume() {
        super.onResume();
        ArrayList<ApartmanSakini> apartmanSakinleri = DB.getInstance(this).getAllAparment();
        displayNotes(apartmanSakinleri);
    }
    private void displayNotes(ArrayList<ApartmanSakini> apartmanSakinleri) {

        ApartmanSakiniAdapter apartmanSakiniAdapter = new ApartmanSakiniAdapter(apartmanSakinleri, item -> {

        } );


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        apartmanSakinleriRecylerView.setLayoutManager(layoutManager);
        apartmanSakinleriRecylerView.setAdapter(apartmanSakiniAdapter);

    }


}