package com.example.evaluasi3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtStb, txtNama, txtAngkatan, txtProdi, txtMinat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtStb = findViewById(R.id.txtStb);
        txtNama = findViewById(R.id.txtNama);
        txtAngkatan = findViewById(R.id.txtAngkatan);
        txtProdi = findViewById(R.id.txtPilihProdi);
        txtMinat = findViewById(R.id.txtPilihMinat);

        String stambuk = getIntent().getStringExtra("STAMBUK");
        String nama = getIntent().getStringExtra("NAMA");
        String programStudi = getIntent().getStringExtra("PROGRAM_STUDI");
        String angkatan = getIntent().getStringExtra("ANGKATAN");
        String minat = getIntent().getStringExtra("MINAT");

        txtStb.setText(stambuk);
        txtNama.setText(nama);
        txtAngkatan.setText(angkatan);
        txtProdi.setText(programStudi);
        txtMinat.setText(minat);
    }
}