package com.example.mobilefatec.model;
import  android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.mobilefatec.dto.Cliente;
import com.example.mobilefatec.until.Conexao;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static Conexao dbHelper = null;
    private static SQLiteDatabase db = null;

    public ClienteDAO(Context context) {
        if (dbHelper == null ) {
            dbHelper = new Conexao(context);
        }
    }

    public String inserir(Cliente cliente) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", cliente.getNome());
        valores.put("CELULAR", cliente.getCelular());
        resultado = db.insert(Conexao.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir cliente";
        } else {
            retorno = "Cliente Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(Cliente cliente) {
        String retorno = "Cliente excluído com Sucesso";
        String where = "ID = " + cliente.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(Conexao.TABELA, where, null);
        db.close();
        return retorno;
    }

    public String alterar(Cliente cliente) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Cliente Alterado com sucesso";
        String where = "ID = " + cliente.getId();
        valores = new ContentValues();
        valores.put("NOME", cliente.getNome());
        valores.put("CELULAR", cliente.getCelular());
        db.update(Conexao.TABELA, valores, where, null);
        db.close();
        return retorno;
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String selectQuery = "SELECT * FROM CLIENTE";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Cliente cliente = new Cliente();
                cliente.setId("" + cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setCelular(cursor.getString(2));
                clientes.add(cliente);
            } while (cursor.moveToNext());
        }
        return clientes;
    }

    public List<Cliente> listar(Cliente clienteEnt) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String parametro = clienteEnt.getNome();
        String selectQuery = "SELECT ID, NOME, EMAIL  FROM CLIENTE  WHERE NOME LIKE ?";
        String[] whereArgs = new String[]{"%" + parametro + "%"};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                Cliente cliente = new Cliente();
                cliente.setId("" + cursor.getInt(0));
                cliente.setNome(cursor.getString(1));
                cliente.setCelular(cursor.getString(2));
                clientes.add(cliente);
            } while (cursor.moveToNext());
        }
        return clientes;


    }


}
