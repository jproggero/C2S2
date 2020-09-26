package com.jpcode.c2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class MuestraDatos extends AppCompatActivity {
    private TextView tvNombreValor;
    private TextView tvFechaNacValor;
    private TextView tvTelefonoValor;
    private TextView tvEmailValor;
    private TextView tvDescripcionValor;
    private Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String fechaNac = parametros.getString("FechaNac");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");

        tvNombreValor = (TextView) findViewById(R.id.tvNombreValor);
        tvNombreValor.setText(nombre);

        tvFechaNacValor = (TextView) findViewById(R.id.tvFechaNacValor);
        tvFechaNacValor.setText(fechaNac);

        tvTelefonoValor = (TextView) findViewById(R.id.tvTelefonoValor);
        tvTelefonoValor.setText(telefono);

        tvEmailValor = (TextView) findViewById(R.id.tvEmailValor);
        tvEmailValor.setText(email);

        tvDescripcionValor = (TextView) findViewById(R.id.tvDescripcionValor);
        tvDescripcionValor.setText(descripcion);

        btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);

        btnEditarDatos.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }});
    }
}