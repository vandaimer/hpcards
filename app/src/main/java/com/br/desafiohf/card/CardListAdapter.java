package com.br.desafiohf.card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.br.desafiohf.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CardListAdapter extends RecyclerView.Adapter<CardViewHolder> implements Filterable {

    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> filteredList;
    private CardItemListener cardItemListener;

    public CardListAdapter(ArrayList<Card> cards) {
        this.cards = cards;
        filteredList = cards;
        cardItemListener = new CardItemListener(filteredList);

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_card_list, viewGroup, false);
        v.setOnClickListener(cardItemListener);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, int i) {
        viewHolder.cardName.setText(filteredList.get(i).getName());
        Picasso.with(viewHolder.cardImage.getContext()).load(filteredList.get(i).getImageURL()).fit().centerCrop().into(viewHolder.cardImage);
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().toLowerCase();
                filteredList = cards;

                if (!charString.isEmpty()) {
                    ArrayList<Card> tmpList = new ArrayList<>();
                    for (Card card : cards) {
                        if (card.getName().toLowerCase().contains(charString)) {
                            tmpList.add(card);
                        }
                    }
                    filteredList = tmpList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                filteredList = (ArrayList<Card>) filterResults.values;
                cardItemListener.updateCardList(filteredList);
                notifyDataSetChanged();
            }
        };
    }
}
