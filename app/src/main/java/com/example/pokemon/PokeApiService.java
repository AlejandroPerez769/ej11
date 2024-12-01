package com.example.pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiService {


    @GET("pokemon?limit=100")
    Call<PokemonListResponse> getAllPokemons();

    @GET("pokemon/{name}")
    Call<Pokemon> getPokemonByName(@Path("name") String name);

    static PokeApiService create() {
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build();

        return retrofit.create(PokeApiService.class);
    }
}
