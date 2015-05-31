package br.com.pokemonUpe.MainTeste;

import java.util.ArrayList;
import java.util.List;

import br.com.pokemonUpe.gameRules.Golpe;
import br.com.pokemonUpe.gameRules.Pokemon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokemon poke = new Pokemon();
		poke.setNome("bubasaur");
		poke.setpoderDeFogo(5);
		List<Golpe> habilidades= new ArrayList<Golpe>();
		Golpe choqueDoTrovao = new Golpe();
		choqueDoTrovao.setNomeGolpe("chicote de vinha");
		habilidades.add(choqueDoTrovao);
		poke.setGolpes(habilidades);
		
		System.out.println(poke.getNome()+" utilizou "+poke.getGolpes().get(0).getNomeGolpe()
				);
	}

}
