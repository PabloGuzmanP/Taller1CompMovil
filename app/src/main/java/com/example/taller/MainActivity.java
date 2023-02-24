package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button;
    private int contador = 0;
    long ahora = System.currentTimeMillis();
    private Date fecha = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String salida = df.format(fecha);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.botonjugar);
        TextView textoContador = (TextView) findViewById(R.id.texto_contador_juego);
        TextView textoFecha = (TextView) findViewById(R.id.texto_fecha_juego);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador=contador+1;
                textoFecha.setText("Usado por ultima vez el "+ salida +".");
                textoContador.setText("El boton ha sido pulsado "+contador+" veces.");
                openNewActivity();
            }
        });

    }
    public void openNewActivity(){
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }
}