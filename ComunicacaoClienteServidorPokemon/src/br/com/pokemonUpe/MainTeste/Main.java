package br.com.pokemonUpe.MainTeste;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.pokemonUpe.gameRules.Golpe;
import br.com.pokemonUpe.gameRules.Jogador;
import br.com.pokemonUpe.gameRules.MasterPokemonProgress;
import br.com.pokemonUpe.gameRules.Pokemon;
import br.com.pokemonUpe.gameRules.PokemonProgress;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pokemon> poke= new ArrayList<Pokemon>();
		
		Pokemon pokemon = new Pokemon(1, "bubasaur", "planta", 2, 2, 2, 2, 2, null,1, 100); 
		
		
		
		poke.add(pokemon);
		Jogador j = new Jogador("vitor", 10, poke, null, 0, 0, 0, null, 1, 0, 56000);
		
		
		
		
		PokemonProgress pp = new PokemonProgress();
		
		
		
		
		
	}

}
