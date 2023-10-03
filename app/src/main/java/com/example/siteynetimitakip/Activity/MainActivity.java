package com.example.siteynetimitakip.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.siteynetimitakip.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button borcActivityButton;
    Button apartmanSakiniEkleButton;
    Button apartmanSakinleriniGosterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        borcActivityButton = findViewById(R.id.borc_button);
        apartmanSakiniEkleButton = findViewById(R.id.apartman_sakini_ekle_button);;
        apartmanSakinleriniGosterButton = findViewById(R.id.apartman_sakinlerini_goster_button);

        borcActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BorcActivity.class);
                startActivity(intent);
            }
        });

        apartmanSakiniEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, KullaniciEkleActivity.class);
                startActivity(intent1);
            }
        });

        apartmanSakinleriniGosterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ApartmanSakinleriniGosterActivity.class);
                startActivity(intent2);
            }
        });


    }
}


