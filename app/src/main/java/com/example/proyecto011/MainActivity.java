package com.example.proyecto011;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private TextView tv3;

    private EditText et1, et2;
    private String [] operaciones = {"sumar", "restar", "multiplicar", "dividir"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv3 = findViewById(R.id.tv3);
        spinner1 = findViewById(R.id.spinner1);

        ArrayAdapter <String> adaptador1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,operaciones);
        spinner1.setAdapter(adaptador1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void operar (View v) {
        int valor1 = Integer.parseInt(et1.getText().toString());
        int valor2 = Integer.parseInt(et2.getText().toString());
        String operacion = spinner1.getSelectedItem().toString();

        if (operacion.equals("sumar")) {
            int suma = valor1 + valor2;
            tv3.setText("La suma es " + suma);
        }
        if (operacion.equals("restar")) {
            int resta = valor1 - valor2;
            tv3.setText("La resta es " + resta);
        }
        if (operacion.equals("multiplicar")) {
            int multip = valor1 * valor2;
            tv3.setText("La multiplicación es " + multip);
        }
        if (operacion.equals("dividir")) {
            int dividir = valor1 / valor2;
            tv3.setText("La división es " + dividir);
        }


    }

}