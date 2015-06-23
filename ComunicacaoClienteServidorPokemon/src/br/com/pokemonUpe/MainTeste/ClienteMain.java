package br.com.pokemonUpe.MainTeste;

import br.com.pokemonUpe.comunication.Cliente;

public class ClienteMain {

	public static void main(String[] args) {
		
		Cliente cliente =  new Cliente();
		cliente.conectarComServidorDebalanceamento();
		
	}

}
