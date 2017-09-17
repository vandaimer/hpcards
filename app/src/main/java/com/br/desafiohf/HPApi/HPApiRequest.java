package com.br.desafiohf.HPApi;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HPApiRequest {

    private static String BASE_URL = "http://hp-api.herokuapp.com/";

    public static HPApiClient getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(HPApiClient.class);
    }
}
