package com.example.planos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvDecricao;
    private TextView tvNota;
    private Button btAdd;
    private Button btSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("APP_PLANOS", "Main - Criando aplicação");

        this.tvDecricao = findViewById(R.id.tvMainDescricao);
        this.tvNota = findViewById(R.id.tvMainNota);
        this.btAdd = findViewById(R.id.btMainAdd);
        this.btSobre = findViewById(R.id.btMainSobre);

        // Contrato para pegar Intent da Activiy
        ActivityResultLauncher<Intent> formResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Plano plano = (Plano) result.getData().getSerializableExtra("PLANO");
                        this.tvDecricao.setText(plano.getDescricao());
                        this.tvNota.setText(String.valueOf(plano.getNota()));
                    }else {
                        Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        this.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForm = new Intent(MainActivity.this, FormActivity.class);

                // Ativando contrato da intent para transferir dados para a Main
                formResult.launch(intentForm);

            }
        });

        this.btSobre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentSobre = new Intent(MainActivity.this, SobreActivity.class);
                intentSobre.putExtra("HELLO", "Hello World!");

                if(intentSobre.resolveActivity(getPackageManager()) != null){
                    startActivity(intentSobre);
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("APP_PLANOS", "Main - Iniciando aplicação");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("APP_PLANOS", "Main - Aplicação rodando");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("APP_PLANOS", "Main - Pausando aplicação");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("APP_PLANOS", "Main - Parando aplicação");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("APP_PLANOS", "Main - Reiniciando aplicação");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("APP_PLANOS", "Main - Matando aplicação");
    }
}