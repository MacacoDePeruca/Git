package br.com.pokemonUpe.gameRules;

public class PokemonProgress {
	
	public int calculaXP(Pokemon pokemon){
		int precisaParaSubirDeNivel =0;
		for(int i =0; i <= pokemon.getNivel();i++){
			precisaParaSubirDeNivel = precisaParaSubirDeNivel+ (i*100);
		}
		
		if(pokemon.getXpAcumulado() >= precisaParaSubirDeNivel){
			return pokemon.getNivel() +1;
		}else {
			return pokemon.getNivel();
		}
		/**
		 * agora tem que dar um jeito pra dar um ponto para que o jogador aumente 
		 * o status do seu pokemon
		 */
		
	}
}
