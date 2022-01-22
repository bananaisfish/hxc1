package com.example.pro1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class daftarr extends AppCompatActivity {

    EditText namaText, nomorText, emailText, kataText;
    String nama, nomor, email, kata ;
    ImageView daftar;
    CheckBox Checkbox;
    String Check;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        daftar = (ImageView) findViewById(R.id.daftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(daftarr.this, pilihan.class);
                startActivity(intent);
            }
        });

        namaText = findViewById(R.id.namaText);
        emailText = findViewById(R.id.emailText);
        nomorText = findViewById(R.id.nomorText) ;
        kataText = findViewById(R.id.kataText) ;
        Checkbox = findViewById(R.id.checkBox) ;

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrasi();
            }
        });
    }

    private void registrasi() {
        nama = namaText.getText().toString() ;
        email = emailText.getText().toString() ;
        nomor = nomorText.getText().toString() ;
        kata = kataText.getText().toString() ;
        Check = Checkbox.getText().toString() ;


        if (namaText.length() == 0) {
            Toast.makeText(daftarr.this, "Silahkan Masukan Email", Toast.LENGTH_LONG).show();
        } if (emailText.length()== 0) {
            Toast.makeText(daftarr.this, "Silahkan Maukan Password", Toast.LENGTH_LONG).show();
        } if (nomorText.length()== 0) {
            Toast.makeText(daftarr.this, "Silahkan Masukan Nomor", Toast.LENGTH_LONG).show();
        } if (kataText.length()== 0) {
            Toast.makeText(daftarr.this, "Silahkan Masukan Password", Toast.LENGTH_LONG).show();
        } if (Checkbox.length()== 0) {
            Toast.makeText(daftarr.this, "Harap Centang", Toast.LENGTH_LONG).show();
        } else {

            mAuth.createUserWithEmailAndPassword  (email, nama)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @RequiresApi(api = Build.VERSION_CODES.S)
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(daftarr.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                                Intent next = new Intent(daftarr.this, pilihan.class);
                                startActivity(next);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(daftarr.this, "Gagal Masuk", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    } }