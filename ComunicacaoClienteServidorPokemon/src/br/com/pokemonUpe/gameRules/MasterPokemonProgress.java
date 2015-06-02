package br.com.pokemonUpe.gameRules;

public class MasterPokemonProgress {

	
	public int calculaXP(Jogador treinador){
		int precisaParaSubirDeNivel =0;
		for(int i =0; i <= treinador.getNivel();i++){
			precisaParaSubirDeNivel = precisaParaSubirDeNivel+ (i*1000);
		}
		
		if(treinador.getXpAcumulado() >= precisaParaSubirDeNivel){
			return treinador.getNivel() +1;
		}else {
			return treinador.getNivel();
		}
		/**
		 * agora tem que dar um jeito de fazer com que o jogador 
		 * possa ganhar um novo pokemon
		 */
	}
	
	
}
