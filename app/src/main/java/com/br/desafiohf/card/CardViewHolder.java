package com.br.desafiohf.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.desafiohf.R;

class CardViewHolder extends RecyclerView.ViewHolder {

    TextView cardName;
    ImageView cardImage;

    CardViewHolder(View itemView) {
        super(itemView);

        cardName = (TextView) itemView.findViewById(R.id.cardName);
        cardImage = (ImageView) itemView.findViewById(R.id.cardImage);
    }
}
