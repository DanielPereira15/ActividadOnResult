package com.example.actividadonresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_RESULTADO="key_resultado";
    private final int REQUEST_CODE_RESULTADO_ACTIVITY=0;

    EditText etText;
    Button btnRedirigir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText=findViewById(R.id.etResultado);
        btnRedirigir=findViewById(R.id.btnRedirigir);
    }

    public void irActivity(View v){
        Intent intent= new Intent(this,ResultadoYVolver.class);
        if(etText.getText().toString().equals("aire")){
            intent.putExtra(KEY_RESULTADO,"ACERTADO");
        }else{
            intent.putExtra(KEY_RESULTADO,"FALLASTE");
        }

        startActivityForResult(intent,REQUEST_CODE_RESULTADO_ACTIVITY);

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);


        if (requestCode==REQUEST_CODE_RESULTADO_ACTIVITY){
            if(resultCode==RESULT_OK){
                if (data.getIntExtra(ResultadoYVolver.KEY_ACCION,-1)==ResultadoYVolver.SALIR){
                    finish();
                }else if (data.getIntExtra(ResultadoYVolver.KEY_ACCION,-1)==ResultadoYVolver.EMPEZAR){
                    recreate();
                }
            }
        }


    }

}