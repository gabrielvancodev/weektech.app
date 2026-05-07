package com.gabriel.weektech.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Localizacao;

public class LocalizacaoActivity extends AppCompatActivity {

    private EditText nomeLocal, endereco, cidade, estado;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        // Inicialização dos componentes da tela
        nomeLocal = findViewById(R.id.nomeLocal);
        endereco = findViewById(R.id.endereco);
        cidade = findViewById(R.id.cidade);
        estado = findViewById(R.id.estado);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(v -> salvarLocalizacao());
    }

    private void salvarLocalizacao() {
        String nomeStr = nomeLocal.getText().toString();
        String enderecoStr = endereco.getText().toString();
        String cidadeStr = cidade.getText().toString();
        String estadoStr = estado.getText().toString();

        // Validação simples
        if (nomeStr.isEmpty() || enderecoStr.isEmpty() || cidadeStr.isEmpty() || estadoStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Criando o objeto Localizacao
        Localizacao loc = new Localizacao();
        loc.nome_local = nomeStr;
        loc.endereco = enderecoStr;
        loc.cidade = cidadeStr;
        loc.estado = estadoStr;

        // Salvando no banco de dados Room
        AppDatabase db = AppDatabase.getDatabase(this);
        db.localizacaoDao().insert(loc);

        Toast.makeText(this, "Localização salva com sucesso!", Toast.LENGTH_SHORT).show();
        finish(); // Fecha a activity e volta para a tela anterior
    }
}
