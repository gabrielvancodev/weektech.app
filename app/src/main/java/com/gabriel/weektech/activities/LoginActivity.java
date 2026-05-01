package com.gabriel.weektech.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Usuario;

public class LoginActivity extends AppCompatActivity {

    EditText email, senha;
    Button btnLogin;

    // Método Protegido para criar a tela de login
    @Override

    // Método Privado para criar a tela de login
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
// Ligando XML com Java
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> fazerLogin());
    }
// Método Privad opara realizar login
    private void fazerLogin() {
// Pegando dados do usuário
        String emailStr = email.getText().toString();
        String senhaStr = senha.getText().toString();
        // Validação básica
        if (emailStr.isEmpty() || senhaStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
// Realizando login
        AppDatabase db = AppDatabase.getDatabase(this);

        Usuario usuario = db.usuarioDao().login(emailStr, senhaStr);

        // Verificando se o usuário existe
        if (usuario != null) {

            Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
// Caso o usuário não exista
        } else {
            Toast.makeText(this, "Email ou senha inválidos!", Toast.LENGTH_SHORT).show();
        }
    }
}