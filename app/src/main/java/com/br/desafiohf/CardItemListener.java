package com.br.desafiohf;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

public class CardItemListener implements  View.OnClickListener {

    private ArrayList<Card> cardList;

    public CardItemListener(ArrayList<Card> cardsList) {
        this.cardList = cardsList;
    }

    @Override
    public void onClick(View v) {
        RecyclerView recyclerView = (RecyclerView) v.getRootView().findViewById(R.id.cardList);
        int itemPosition = recyclerView.getChildLayoutPosition(v);
        Gson gsonCard = new Gson();

        Intent intent = new Intent(v.getContext(), CardActivity.class);
        intent.putExtra("CARD", gsonCard.toJson(cardList.get(itemPosition)));
        v.getContext().startActivity(intent);
    }

    public void updateCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }
}
