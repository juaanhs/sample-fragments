package br.com.juaanhs.fragments.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.juaanhs.fragments.R;
import br.com.juaanhs.fragments.ui.fragment.ContatosFragment;
import br.com.juaanhs.fragments.ui.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversas, buttonContatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remove sombra  da actionBar
        getSupportActionBar().setElevation(0);

        buttonContatos = findViewById(R.id.btn_contatos);
        buttonConversas = findViewById(R.id.btn_conversas);
        conversasFragment = new ConversasFragment();
        contatoFragment = new ContatosFragment();

        //Configura objeto para o fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //inicia a transição
        transaction.add(R.id.framelayout_conteudo, conversasFragment);
        transaction.commit(); // encerra a transição

        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout_conteudo, contatoFragment);
                transaction.commit();
            }
        });

        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout_conteudo, conversasFragment);
                transaction.commit();
            }
        });
    }
}
