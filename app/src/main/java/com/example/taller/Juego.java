package com.example.taller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Juego extends AppCompatActivity {

    private int numero = new Random().nextInt(50);
    private EditText numeroIngresado;
    private Button botonAdivinar;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juegonumero);
        numeroIngresado = findViewById(R.id.numero_ingresado);
        botonAdivinar = findViewById(R.id.boton_adivinar);
    }
    public void adivinar(View view){
        int numeroIng = Integer.parseInt(numeroIngresado.getText().toString());
        if(numeroIng == numero){
            Toast.makeText(getApplicationContext(),"Adivino el numero \uD83C\uDF89", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
            mensaje.setTitle("Intentos");
            mensaje.setMessage("El numero de intentos en ganar fue: " + contador);
            mensaje.setNeutralButton("Continuar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    continuar();
                }
            });
            mensaje.show();
            numero = new Random().nextInt(50);
            numeroIngresado.setText("");
        } else {
            if(numeroIng < numero){
                contador = contador+1;
                Toast.makeText(getApplicationContext(),"El numero es mayor", Toast.LENGTH_SHORT).show();
            }
            if(numeroIng > numero){
                contador = contador+1;
                Toast.makeText(getApplicationContext(),"El numero es menor", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void continuar(){
        finish();
    }
}
