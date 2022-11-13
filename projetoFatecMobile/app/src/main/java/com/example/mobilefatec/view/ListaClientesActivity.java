package com.example.mobilefatec.view;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.mobilefatec.R;
import com.example.mobilefatec.dto.Cliente;
import com.example.mobilefatec.model.ClienteDAO;

import java.util.List;

public class ListaClientesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView Lista;
    List<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);
        final ClienteDAO ge = new ClienteDAO(getBaseContext());
        Lista = (ListView) findViewById(R.id.lista);
        clientes = ge.listar();
        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientes);
        Lista.setAdapter(adapter);
        Lista.setOnItemClickListener(this); // Clique no item
        Lista.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override


    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        Cliente cliente = (Cliente) parent.getItemAtPosition(position);
        Intent it = new Intent(ListaClientesActivity.this, AtualizaClienteActivity.class);
        it.putExtra("Cliente", cliente);
        startActivity(it);
        Toast.makeText(getApplicationContext(), "Item Pressionado :-" + position + " ID= " + cliente.getId(), Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        Cliente cliente = (Cliente) parent.getItemAtPosition(position);
        Intent it = new Intent(ListaClientesActivity.this, AtualizaClienteActivity.class);
        it.putExtra("Cliente",cliente);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + cliente.getId(),Toast.LENGTH_LONG).show();
    }
}
