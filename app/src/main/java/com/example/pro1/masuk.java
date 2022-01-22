package com.example.pro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class masuk extends AppCompatActivity {
    ImageView loginEmail, masukEmail ;
    TextView daftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        loginEmail = findViewById(R.id.loginEmail);
        daftar= findViewById(R.id.daftar);
        masukEmail = findViewById(R.id.masukEmail);


        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(masuk.this, MainActivity.class);
                startActivity(intent2);
            }
        });

                //Pindah Ke Halaman Masuk
                masukEmail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(masuk.this, Masuk1.class);
                        startActivity(intent);
                    }
                });





    }}

