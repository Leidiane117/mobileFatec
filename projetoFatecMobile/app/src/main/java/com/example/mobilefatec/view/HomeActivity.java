package com.example.mobilefatec.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilefatec.R;

public class HomeActivity extends AppCompatActivity {
    TextView login;
    EditText senha;
    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
        entrar = (Button) findViewById(R.id.entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             String  slogin = login.getText().toString();
             String  ssenha= senha.getText().toString();
             if ("admin@fatec".equals(slogin)  &&  "123".equals(ssenha))
                {

                    Intent telaHome = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(telaHome);
                    finish();

                }
                else{
                     Toast.makeText(HomeActivity.this,"Usuário ou senha incorretos",
                     Toast.LENGTH_SHORT).show();
                }
            }




        });
    }
}