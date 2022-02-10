package com.example.actividadonresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadoYVolver extends AppCompatActivity {

    public final static String KEY_ACCION="key_accion";
    public final static int SALIR=0;
    public final static int EMPEZAR=1;


    TextView tx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tx=findViewById(R.id.idText);
        String r= getIntent().getStringExtra(MainActivity.KEY_RESULTADO);
        tx.setText(r);

    }

    public void aceptar(View v){
        setResult(RESULT_OK, new Intent().putExtra(KEY_ACCION,EMPEZAR));  //El value tiene que ser el mismo que en el main activity hayamos puesto
        finish();
    }

    public void salir(View v){
        setResult(RESULT_OK,new Intent().putExtra(KEY_ACCION,SALIR));
        finish();
    }


}