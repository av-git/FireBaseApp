package com.example.avelino.firebaseapp;

import android.icu.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReferenceRaiz = FirebaseDatabase.getInstance().getReference();

    //exemplo criar estrutura d usuario no firebase
    DatabaseReference usuarioReferencia = databaseReferenceRaiz.child("usuarios"); //o child cria um no usuario
    DatabaseReference anunciosReferencia = databaseReferenceRaiz.child("anuncios"); //o child cria um no usuario
    DatabaseReference marcasReferencia = databaseReferenceRaiz.child("marcas"); //o child cria um no usuario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //exemplo1_basico();
        //exemplo2_criando_varios_nos();
        //exemplo3_criando_estruta_com_objeto_anuncio();
        //exemplo4_criando_estruta_com_objeto_marcar();
        listandoDadosFireBaseEmTempoReal();

    }

    //ex5 - listando os registros do firebase
    //chamamos o metodo que fica ouvindo mudanças na base do firebase
    //aula: sessao 16 aula 153 Udemy
    private void listandoDadosFireBaseEmTempoReal() {

        anunciosReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //DICA. PODEMOS FICAR OUVINDO UM NO RAIZ (anuncios) OU UM DOS SEUS NOS FILHOS (EX: anuncios --> 001)
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void exemplo3_criando_estruta_com_objeto_anuncio() {
        //ex3 - passando um objeto para firebase salvar
        Anuncio anuncio = new Anuncio();
        anuncio.setId("001");
        anuncio.setDataAnuncio(new Date());
        anuncio.setDescricao("promo");
        anuncio.setPreco(22.3);
        anuncio.setProdutoId(new Long(2));
        anuncio.setTitulo("Fralda Pamper");
        anunciosReferencia.child("001").setValue(anuncio);
    }

    private void exemplo4_criando_estruta_com_objeto_marcar() {
        //ex3 - passando um objeto para firebase salvar
        Marca marca = new Marca();
        marca.setId(new Long(3));
        marca.setNome("Pampers");

        marcasReferencia.child("001").setValue(marca);
    }

    private void exemplo2_criando_varios_nos() {
        //ex2
        //a forma abaixo cria toda a estrutura chamando o child(no) para cada nivel. obs:
        // podemos passar logo um objeto que ele cria todos os campos
        usuarioReferencia.child("001").child("nome").setValue("avelino teste");
    }

    private void exemplo1_basico() {
        //ex1
        databaseReferenceRaiz.child("pontos").setValue("101");
    }
}
