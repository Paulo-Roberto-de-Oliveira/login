package com.example.sistemas.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sistemas.MainActivity;
import com.example.sistemas.R;
import com.example.sistemas.modelo.ModeloLogin;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {


    private EditText username, password; //coleta dados
    private Button btnLogin;//botao login
    private TextView dica; //dica senha

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ArrayList<ModeloLogin> usuarios = new ArrayList<>();//armazena os usuario
        ModeloLogin m = new ModeloLogin();
//usuario1 para login
        m.setUsername("pedro");
        m.setPassword("123");
        m.setPasse("123");
        usuarios.add(m);

//usuario2 para login
        m = new ModeloLogin();
        m.setUsername("mario");
        m.setPassword("456");
        m.setPasse("456");
        usuarios.add(m);

//usuario3 para login
        m = new ModeloLogin();
        m.setUsername("joao");
        m.setPassword("789");
        m.setPasse("789");
        usuarios.add(m);

//fazendo cast
        this.username = (EditText) findViewById(R.id.name);
        this.password = (EditText) findViewById(R.id.pass);
        this.btnLogin = (Button) findViewById(R.id.Login);
        this.dica = (TextView) findViewById(R.id.txtdica);

// evento botao loging
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!username.getText().toString().isEmpty()) {
                    boolean achei = false;
                    for (ModeloLogin m : usuarios) {

                        if (m.getUsername().equals(username.getText().toString())) {
                            final String ajuda = m.getPasse();
                            achei = true;//verificação existencia usuario
                            if (!password.getText().toString().isEmpty() && password.getText().toString().equals(m.getPassword())) {
//chamando nova tela passando usuario logado
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                Bundle logado = new Bundle();
                                logado.putString("user", m.getUsername());
                                intent.putExtras(logado);
                                startActivity(intent);
                                clean();
                                Toast.makeText(Login.this, "Bem Vindo " + m.getUsername(), Toast.LENGTH_LONG).show();


                            } else {
                                dica.setText("");
//Abrindo msg para dica senha
                                AlertDialog.Builder pergunta = new AlertDialog.Builder(Login.this);
                                pergunta.setTitle("Senha Incorreta ! \nVoce gostaria de uma dica");
                                pergunta.setNegativeButton("NÃO", null);
                                pergunta.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        password.setText("");
                                        dica.setText("SUA SENHA É: " + ajuda);// Exibindo dica senha
                                    }
                                });
                                pergunta.create().show();
                            }
                        }
                    }
//usuario nao encontrado
                    if (achei == false) {
                        Toast.makeText(Login.this, "USUARIO NÃO CADASTRADO", Toast.LENGTH_SHORT).show();
                        System.out.println("1 " + achei);
                    }
//campo vazio
                } else {
                    Toast.makeText(Login.this, "CAMPO USUARIO VAZIO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//limpando campos
    public void clean() {
        this.username.setText("");
        this.password.setText("");
        this.dica.setText("");
    }
}
