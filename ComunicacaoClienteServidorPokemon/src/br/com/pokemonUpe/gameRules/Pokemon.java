package br.com.pokemonUpe.gameRules;

import java.util.List;

public class Pokemon {
	private int id;
	private String nome;
	private String tipo;
	// habilibdades 
	private int habilidade;
	private int armadura;
	private int resistencia;
	private int poderDeFogo;
	private int BonusDecaptura;
	private  List<Golpe> golpes;
	
	public Pokemon(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(int habilidade) {
		this.habilidade = habilidade;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getpoderDeFogo() {
		return poderDeFogo;
	}

	public void setpoderDeFogo(int poderDeFogo) {
		this.poderDeFogo = poderDeFogo;
	}

	public int getBonusDecaptura() {
		return BonusDecaptura;
	}

	public void setBonusDecaptura(int bonusDecaptura) {
		BonusDecaptura = bonusDecaptura;
	}

	public List<Golpe> getGolpes() {
		return golpes;
	}

	public void setGolpes(List<Golpe> golpes) {
		this.golpes = golpes;
	}
	
	
}
