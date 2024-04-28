package com.example.evaluasi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editStb, editNama;
    Spinner spinnerAngkatan;
    RadioGroup rg;
    RadioButton prodi1, prodi2;
    CheckBox minat1, minat2, minat3, minat4, minat5, minat6;
    Button btn_ringkasan;
    TextView prodi, minat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editStb = findViewById(R.id.editStb);
        editNama = findViewById(R.id.editNama);
        spinnerAngkatan = findViewById(R.id.spinnerAngkatan);
        rg = findViewById(R.id.rg);
        prodi1 = findViewById(R.id.prodi1);
        prodi2 = findViewById(R.id.prodi2);
        minat1 = findViewById(R.id.minat1);
        minat2 = findViewById(R.id.minat2);
        minat3 = findViewById(R.id.minat3);
        minat4 = findViewById(R.id.minat4);
        minat5 = findViewById(R.id.minat5);
        minat6 = findViewById(R.id.minat6);
        btn_ringkasan = findViewById(R.id.btn_ringkasan);
        prodi = findViewById(R.id.prodi);
        minat = findViewById(R.id.minat);

        String[] item = new String[]{"-Pilih Angkatan-","2022", "2021", "2020", "2019", "2018", "2017",
                "2016", "2015", "2014"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item);
        spinnerAngkatan.setAdapter(adapter);

        btn_ringkasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stambuk = editStb.getText().toString();
                String nama = editNama.getText().toString();
                String programStudi = getProgramStudi();
                String angkatan = spinnerAngkatan.getSelectedItem().toString();
                String minat = getMinat();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("STAMBUK", stambuk);
                intent.putExtra("NAMA", nama);
                intent.putExtra("PROGRAM_STUDI", programStudi);
                intent.putExtra("ANGKATAN", angkatan);
                intent.putExtra("MINAT", minat);

                startActivity(intent);
            }
        });
    }
    private String getProgramStudi() {
        int selectedId = rg.getCheckedRadioButtonId();
        if (selectedId == R.id.prodi1) {
            return "Teknik Informatika";
        }
        else if (selectedId == R.id.prodi2) {
            return "Sistem Informasi";
        }
        else {
            return "";}
    }

    private String getMinat() {
        StringBuilder minat = new StringBuilder();
        if (minat1.isChecked()) {
            minat.append("- ").append(minat1.getText()).append("\n");
        }
        if (minat2.isChecked()) {
            minat.append("- ").append(minat2.getText()).append("\n");
        }
        if (minat3.isChecked()) {
            minat.append("- ").append(minat3.getText()).append("\n");
        }
        if (minat4.isChecked()) {
            minat.append("- ").append(minat4.getText()).append("\n");
        }
        if (minat5.isChecked()) {
            minat.append("- ").append(minat5.getText()).append("\n");
        }
        if (minat6.isChecked()) {
            minat.append("- ").append(minat6.getText()).append("\n");
        }
        return minat.toString();
    }
}