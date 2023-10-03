package com.example.siteynetimitakip.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.siteynetimitakip.DB.DB;
import com.example.siteynetimitakip.R;

public class KullaniciEkleActivity extends AppCompatActivity {

    EditText editTextKiraciIsmi, editTextSahibiIsmi, editTextBlock, editTextApartment;
    Button ekleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_ekle);

        Intent intent = getIntent();

        editTextKiraciIsmi = findViewById(R.id.kiraci_isim_edit_text);
        editTextSahibiIsmi = findViewById(R.id.ev_sahibi_isim_edit_text);
        editTextBlock = findViewById(R.id.block_number_edit_text);
        editTextApartment = findViewById(R.id.apartment_number_edit_text);

        ekleButton = findViewById(R.id.kullanıcı_ekle_button);

        ekleButton.setOnClickListener(view -> {
            addNewApartment();
        });
    }

    private void addNewApartment() {
        String kiraciIsmı = editTextKiraciIsmi.getText().toString();
        String sahibiIsmı = editTextSahibiIsmi.getText().toString();
        String block = editTextBlock.getText().toString();
        String apartment = editTextApartment.getText().toString();

        DB.getInstance(this).addNewApartment(kiraciIsmı,sahibiIsmı,block,apartment);
        finish();
    }
}