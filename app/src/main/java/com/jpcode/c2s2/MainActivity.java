package com.jpcode.c2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private EditText etNacimiento;
    private EditText etNombre;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etDescripcion;
    private Button botonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etNacimiento = findViewById(R.id.etNacimiento);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etDescripcion = findViewById(R.id.etDescripcion);
        botonSiguiente = findViewById(R.id.botonSiguiente);

        etNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        botonSiguiente.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MuestraDatos.class);
                intent.putExtra("Nombre", etNombre.getText().toString());
                intent.putExtra("FechaNac", etNacimiento.getText().toString());
                intent.putExtra("Telefono", etPhone.getText().toString());
                intent.putExtra("Email", etEmail.getText().toString());
                intent.putExtra("Descripcion", etDescripcion.getText().toString());
                startActivity(intent);

            }
        });

    };

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date = i2 + "/" + (i1 + 1) + "/" + i;
        etNacimiento.setText(date);
    }
}

