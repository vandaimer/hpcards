package com.br.desafiohf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class CardActivity extends AppCompatActivity {

    private final String NOT_FOUND = "Não informado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String cardJsonString = intent.getStringExtra("CARD");

        Card card = new Gson().fromJson(cardJsonString, Card.class);
        ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
        TextView cardName = (TextView) findViewById(R.id.cardName);
        TextView cardSpecies = (TextView) findViewById(R.id.cardSpecie);
        TextView cardHouse = (TextView) findViewById(R.id.cardHouse);
        TextView cardWandWood = (TextView) findViewById(R.id.cardWandWood);
        TextView cardWandCore = (TextView) findViewById(R.id.cardWandCore);
        TextView cardWandLength = (TextView) findViewById(R.id.cardLength);

        cardName.setText(card.getName());
        cardSpecies.setText(card.getSpecies());
        cardHouse.setText(card.getHouse());

        String tmp = card.getWand().get("wood");
        if(tmp.isEmpty()){
            tmp = NOT_FOUND;
        }
        cardWandWood.setText(tmp);

        tmp = card.getWand().get("core");
        if(tmp.isEmpty()){
            tmp = NOT_FOUND;
        }
        cardWandCore.setText(tmp);

        tmp = card.getWand().get("length");
        if(tmp.isEmpty()){
            tmp = NOT_FOUND;
        }
        cardWandLength.setText(tmp);

        Picasso.with(cardImage.getContext()).load(card.getImageURL()).fit().into(cardImage);
    }
}
