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

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        final ClienteDAO ge = new ClienteDAO(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btnSalvarCadastro);

        Inserir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText cel  = (EditText) findViewById(R.id.celular);
        String nomeString = nome.getText().toString();
        String celString = cel.getText().toString();
        Cliente cliente = new Cliente();
        cliente.setId("");
        cliente.setNome(nomeString);
        cliente.setCelular(celString);
            String msg = ge.inserir(cliente);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            Intent it = new Intent(CadastroActivity.this, ListaClientesActivity.class);
            startActivity(it);
    }
});
        }

}