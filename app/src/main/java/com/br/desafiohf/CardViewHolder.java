package com.br.desafiohf;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class CardViewHolder extends RecyclerView.ViewHolder {

    TextView cardName;

    CardViewHolder(View itemView) {
        super(itemView);

        cardName = (TextView) itemView.findViewById(R.id.cardName);
    }
}
