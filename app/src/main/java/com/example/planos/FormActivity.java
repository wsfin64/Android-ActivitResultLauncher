package com.example.planos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class FormActivity extends Activity {

    private EditText etDescricao;
    private EditText etNota;
    private Button btSalvar;
    private Button btCancelar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.etDescricao = findViewById(R.id.etFormDescricao);
        this.etNota = findViewById(R.id.etFormNota);
        this.btSalvar = findViewById(R.id.btFormSalvar);
        this.btCancelar = findViewById(R.id.btFormCancelar);

        this.btSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                salvar();
            }
        });

        this.btCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

    }

    private void salvar(){
        String descricao = String.valueOf(this.etDescricao.getText());
        int nota = Integer.parseInt(String.valueOf(this.etNota.getText()));

        Plano plano = new Plano(descricao, nota);

        Intent intentPlano = new Intent().putExtra("PLANO", plano);
        setResult(RESULT_OK, intentPlano);
        finish();
    }
}
