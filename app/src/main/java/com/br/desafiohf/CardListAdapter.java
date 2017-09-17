package com.br.desafiohf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CardListAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private ArrayList<Card> cards = new ArrayList<>();

    public CardListAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_card_list, viewGroup, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, int i) {
       viewHolder.cardName.setText(cards.get(i).getName());
       Picasso.with(viewHolder.cardImage.getContext()).load(cards.get(i).getImageURL()).fit().centerCrop().into(viewHolder.cardImage);
    }


    @Override
    public int getItemCount() {
        return cards.size();
    }
}
