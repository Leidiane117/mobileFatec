package com.example.mobilefatec.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilefatec.R;
import com.example.mobilefatec.dto.Cliente;
import com.example.mobilefatec.model.ClienteDAO;

public class AtualizaClienteActivity extends AppCompatActivity {

    Button upCliente, delCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);
        final ClienteDAO ge = new ClienteDAO(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nome2);
        final EditText cel = (EditText)findViewById(R.id.celular3);
        Intent it = getIntent();
        final Cliente recuperado = (Cliente) ((Intent) it).getSerializableExtra("Cliente");
        nome.setText(recuperado.getNome());
        cel.setText(recuperado.getCelular());

        upCliente = (Button) findViewById(R.id.atualizar);
        upCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String cpfString = cel.getText().toString();
                recuperado.setNome(nomeString);
                recuperado.setCelular(cpfString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                Intent it = new Intent(AtualizaClienteActivity.this, ListaClientesActivity.class);
                startActivity(it);

            }
        });

        delCliente= (Button) findViewById(R.id.btnExcluir);
        delCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                Intent it = new Intent(AtualizaClienteActivity.this, ListaClientesActivity.class);
                startActivity(it);
            }
        });


    }
}
