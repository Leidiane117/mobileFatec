package com.example.mobilefatec.until;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bd_loja.db";
    public static final String TABELA = "CLIENTE";

    private static final int VERSAO_SCHEMA = 1;
    private final String S_CREATE;

    public Conexao(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE = "CREATE TABLE CLIENTE (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,CELULAR TEXT);";
    }
   @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}





