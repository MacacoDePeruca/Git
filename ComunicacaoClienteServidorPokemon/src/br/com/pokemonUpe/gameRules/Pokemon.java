package br.com.pokemonUpe.gameRules;

import java.util.List;

public class Pokemon {
	private int id;
	private String nome;
	private String tipo;
	private Pokemon evoluiPara;
	private Pokemon vemDe;
	private int nivel;
	private int xpAcumulado;
	
	// habilibdades 
	private int habilidade;
	private int armadura;
	private int resistencia;
	private int poderDeFogo;
	private int bonusDecaptura;
	private List<Golpe> golpes;
	private int pontosDeVida;
	private int pontosDeMagia;
	
	public Pokemon(){
		
	}
	
	

	public Pokemon(int id, String nome, String tipo, int habilidade,
			int armadura, int resistencia, int poderDeFogo, int bonusDecaptura,
			List<Golpe> golpes, int nivel, int xp) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.habilidade = habilidade;
		this.armadura = armadura;
		this.resistencia = resistencia;
		this.poderDeFogo = poderDeFogo;
		this.bonusDecaptura = bonusDecaptura;
		this.golpes = golpes;
		this.xpAcumulado = xp;
		this.nivel = nivel;
	}

	
	
	
	
	public int getNivel() {
		return nivel;
	}



	public int getXpAcumulado() {
		return xpAcumulado;
	}



	public void setXpAcumulado(int xpAcumulado) {
		this.xpAcumulado = xpAcumulado;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	public Pokemon getEvoluiPara(){
		return evoluiPara;
	}
	public void setEvoluiPara(Pokemon evoluiPara){
		this.evoluiPara = evoluiPara;
	}
	

	public Pokemon getVemDe() {
		return vemDe;
	}



	public void setVemDe(Pokemon vemDe) {
		this.vemDe = vemDe;
	}



	public int getPoderDeFogo() {
		return poderDeFogo;
	}



	public void setPoderDeFogo(int poderDeFogo) {
		this.poderDeFogo = poderDeFogo;
	}



	public int getPontosDeVida() {
		return pontosDeVida;
	}



	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}



	public int getPontosDeMagia() {
		return pontosDeMagia;
	}



	public void setPontosDeMagia(int pontosDeMagia) {
		this.pontosDeMagia = pontosDeMagia;
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
		return bonusDecaptura;
	}

	public void setBonusDecaptura(int bonusDecaptura) {
		bonusDecaptura = bonusDecaptura;
	}

	public List<Golpe> getGolpes() {
		return golpes;
	}

	public void setGolpes(List<Golpe> golpes) {
		this.golpes = golpes;
	}
	
	
}
