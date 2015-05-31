package br.com.pokemonUpe.gameRules;

public class Item {
	private int idItem;
	private int DescricaoItem;
	private String efeito; // está String por enquanto não consigo algo melhor
	
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public int getDescricaoItem() {
		return DescricaoItem;
	}
	public void setDescricaoItem(int descricaoItem) {
		DescricaoItem = descricaoItem;
	}
	public String getEfeito() {
		return efeito;
	}
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	
	
	
 
}
