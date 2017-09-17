package com.br.desafiohf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.br.desafiohf.HPApi.HPApiClient;
import com.br.desafiohf.HPApi.HPApiRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Card> cardsList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CardListAdapter cardListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.cardList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        HPApiClient client = HPApiRequest.getClient();
        Call<List<Card>> call = client.getCharacters();

        call.enqueue(new Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                List<Card> resp = response.body();
                if(!resp.isEmpty()) {
                    cardsList = new ArrayList<>(resp);
                    cardListAdapter = new CardListAdapter(cardsList, new CardItemListener(cardsList));
                    recyclerView.setAdapter(cardListAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {}
        });
    }
}
