package com.br.desafiohf.HPApi;

import com.br.desafiohf.Card;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HPApiClient {
    @GET("api/characters")
    Call<List<Card>> getCharacters();
}
