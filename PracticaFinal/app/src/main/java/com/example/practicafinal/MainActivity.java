package com.example.practicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicafinal.Entities.Library;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Nombre = findViewById(R.id.editTextTextPersonName);
        EditText Nombre2 = findViewById(R.id.editTextTextPersonName2);
        EditText Nombre3 = findViewById(R.id.editTextTextPersonName3);
        EditText Nombre4 = findViewById(R.id.editTextTextPersonName4);
        EditText Nombre5 = findViewById(R.id.editTextTextPersonName5);
        EditText Nombre6 = findViewById(R.id.editTextTextPersonName6)
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = Nombre.getText().toString();
                String nombre2 = Nombre2.getText().toString();
               // int nombre3 = Nombre3.getText().toString();
                String nombre4 = Nombre4.getText().toString();
                String nombre5 = Nombre5.getText().toString();
                String nombre6 = Nombre6.getText().toString();

                Library library = new Library(
                     nombre,nombre2,2,
                );
            }
        });
    }
}