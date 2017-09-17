package com.br.desafiohf;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class CardItemListener implements  View.OnClickListener {

    private ArrayList<Card> cardsList;

    public CardItemListener(ArrayList<Card> cardsList) {
        this.cardsList = cardsList;
    }

    @Override
    public void onClick(View v) {
    }
}
