package com.example.sistemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//cast
        this.login = (TextView) findViewById(R.id.tv_logado);
//recebendo
        Intent log = getIntent();
        Bundle logado = getIntent().getExtras();
//setando nome do usuario recebido
        if (login != null) {
            String user = logado.getString("user");
            login.setText("USUARIO: " + user+" ");
        }
    }
}
