package com.example.planos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.icu.text.ConstrainedFieldPosition;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SobreActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        Log.i("APP_PLANOS", "Sobre - Criando aplicação");

        if (getIntent().hasExtra("HELLO")){
            String msg = getIntent().getStringExtra("HELLO");
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        this.layout = findViewById(R.id.layoutSobre);

        this.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

        Log.i("APP_PLANOS", "Sobre - Aplicação rodando");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("APP_PLANOS", "Sobre - Pausando aplicação");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("APP_PLANOS", "Sobre - Parando aplicação");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("APP_PLANOS", "Sobre - Reiniciando aplicação");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("APP_PLANOS", "Sobre - Matando aplicação");
    }
}