package com.example.pro1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Masuk1 extends AppCompatActivity {

    EditText inputEmail, inputPass;
    String email, password;
    ImageView btnMasuk;
    private FirebaseAuth mAuth;
    private Object Masuk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk1);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.inputEmail);
        inputPass = findViewById(R.id.inputPass);
        btnMasuk = findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });
    }

    private void cekLogin() {
        email = inputEmail.getText().toString();
        password = inputPass.getText().toString();

        if (email.length() == 0) {
            Toast.makeText(Masuk1.this, "Silahkan Masukan Email", Toast.LENGTH_LONG).show();
        } if (password.length()== 0) {
                Toast.makeText(Masuk1.this,"Silahkan Maukan Password", Toast.LENGTH_LONG).show();
        } else {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @RequiresApi(api = Build.VERSION_CODES.S)
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Masuk1.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                            Intent next = new Intent(Masuk1.this, pilihan.class);
                            startActivity(next);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Masuk1.this, "Gagal Masuk", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        }


    }
}