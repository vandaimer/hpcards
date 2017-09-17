package com.br.desafiohf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Intent intent = getIntent();
        String cardJsonString = intent.getStringExtra("CARD");

        try {
            JSONObject card = new JSONObject(cardJsonString);
            ImageView cardImage = (ImageView) findViewById(R.id.cardImage);
            Picasso.with(cardImage.getContext()).load(card.getString("image")).fit().into(cardImage);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
