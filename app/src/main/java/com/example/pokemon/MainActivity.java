package com.example.pokemon;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    private PokeApiService pokeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Configurar el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pokemonAdapter = new PokemonAdapter(pokemonList);
        recyclerView.setAdapter(pokemonAdapter);
        pokeApiService = PokeApiService.create();


        loadAllPokemons();
    }


    private void loadAllPokemons() {
        pokeApiService.getAllPokemons().enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    pokemonList.clear();
                    pokemonList.addAll(response.body().getResults());
                    pokemonAdapter.notifyDataSetChanged(); // Actualizar el RecyclerView con los nuevos datos
                } else {
                    Toast.makeText(MainActivity.this, "No se pudieron cargar los Pokémon", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
