package com.gabriel.weektech.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.gabriel.weektech.R;
import com.gabriel.weektech.database.AppDatabase;
import com.gabriel.weektech.models.Evento;
import com.gabriel.weektech.models.Inscricao;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class EventoAdapter extends BaseAdapter {

    private Context context;
    private List<Evento> eventos;
    private AppDatabase db;

    public EventoAdapter(Context context, List<Evento> eventos) {

        this.context = context;
        this.eventos = eventos;
        this.db = AppDatabase.getDatabase(context);
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return eventos.get(position).id_evento;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_evento, parent, false);
        }

        Evento evento = eventos.get(position);

        TextView txtNomeEvento =
                convertView.findViewById(R.id.txtNomeEvento);

        TextView txtDataEvento =
                convertView.findViewById(R.id.txtDataEvento);

        TextView txtInscritos =
                convertView.findViewById(R.id.txtInscritos);

        MaterialButton btnDetalhes =
                convertView.findViewById(R.id.btnDetalhes);

        List<Inscricao> inscritos =
                db.inscricaoDao().listarPorEvento(evento.id_evento);

        txtNomeEvento.setText(evento.nome_evento);

        txtDataEvento.setText(
                "📅 " + evento.data_inicio
        );

        txtInscritos.setText(
                "👥 Inscritos: " +
                        inscritos.size() +
                        "/" +
                        evento.qntd_vagas
        );

        btnDetalhes.setOnClickListener(v -> {

            View dialogView = LayoutInflater
                    .from(context)
                    .inflate(R.layout.dialog_evento, null);

            TextView txtDescricao =
                    dialogView.findViewById(R.id.txtDescricao);

            CheckBox checkCoffee =
                    dialogView.findViewById(R.id.checkCoffee);

            MaterialButton btnInscrever =
                    dialogView.findViewById(R.id.btnInscrever);

            MaterialButton btnFechar =
                    dialogView.findViewById(R.id.btnFecharDialog);

            txtDescricao.setText(
                    evento.descricao +
                            "\n\n📅 Data: " + evento.data_inicio +
                            "\n👥 Inscritos: " + inscritos.size() +
                            "\n🎟️ Vagas: " + evento.qntd_vagas
            );

            AlertDialog dialog =
                    new AlertDialog.Builder(context)
                            .setView(dialogView)
                            .create();

            btnInscrever.setOnClickListener(btn -> {

                List<Inscricao> listaAtual =
                        db.inscricaoDao()
                                .listarPorEvento(evento.id_evento);

                if (listaAtual.size() >= evento.qntd_vagas) {

                    Toast.makeText(
                            context,
                            "Evento lotado!",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                Inscricao inscricao = new Inscricao();

                inscricao.id_evento = evento.id_evento;
                inscricao.id_usuario = 1;
                inscricao.coffee_break =
                        checkCoffee.isChecked();

                inscricao.confirmado = true;
                inscricao.presenca_confirmada = false;

                db.inscricaoDao().inserir(inscricao);

                Toast.makeText(
                        context,
                        "Inscrição realizada com sucesso!",
                        Toast.LENGTH_SHORT
                ).show();

                notifyDataSetChanged();

                dialog.dismiss();
            });

            btnFechar.setOnClickListener(btn -> {
                dialog.dismiss();
            });

            dialog.show();
        });

        return convertView;
    }
}