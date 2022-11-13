package com.example.mobilefatec.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobilefatec.R;

public class MainActivity extends AppCompatActivity {
    Button listarClientes,cadastrarClientes,buscarClientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listarClientes =  (Button)  findViewById(R.id.btnListar);
        listarClientes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ListaClientesActivity.class);
                startActivity(it);
            }
        });
        cadastrarClientes = (Button) findViewById(R.id.btnCadastrar);
        cadastrarClientes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);
            }
        });

    }

}
