package com.gabriel.weektech.activities;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Usuario;
import com.gabriel.weektech.R;

public class CadastroActivity extends AppCompatActivity {

    EditText nome, ra, curso, serie, email, senha;
    CheckBox checkCoffee;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //  Ligando XML com Java
        nome = findViewById(R.id.nome);
        ra = findViewById(R.id.ra);
        curso = findViewById(R.id.curso);
        serie = findViewById(R.id.serie);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        checkCoffee = findViewById(R.id.checkCoffee);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> cadastrarUsuario());
    }

    private void cadastrarUsuario() {

        AppDatabase db = AppDatabase.getDatabase(this);

        String nomeStr = nome.getText().toString();
        String raStr = ra.getText().toString();
        String cursoStr = curso.getText().toString();
        String serieStr = serie.getText().toString();
        String emailStr = email.getText().toString();
        String senhaStr = senha.getText().toString();
        boolean coffee = checkCoffee.isChecked();

        //  Validação básica
        if (nomeStr.isEmpty() || emailStr.isEmpty() || senhaStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }
        //  Criando usuário
        Usuario user = new Usuario();
        user.nome_completo = nomeStr;
        user.ra = raStr;
        user.email = emailStr;
        user.tipo = "ALUNO";
        user.senha = senhaStr;


        db.usuarioDao().inserir(user);

        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

        limparCampos();
    }

    private void limparCampos() {
        nome.setText("");
        ra.setText("");
        curso.setText("");
        serie.setText("");
        email.setText("");
        checkCoffee.setChecked(false);
    }
}