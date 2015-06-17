/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

import java.net.DatagramPacket;

import br.com.pokemonUpe.DAO.ClienteDAO;

/**
 *
 * @author Vitor
 */
public class ServidorDeBalanceamento {
    private int contadorDeClientes;
	
	/**
     * Servidor de balanceamento, a estrat�gia aqui � bem simples, saber quantos jogadores
     * tem em cada servidor e tentar sempre distribuir a carga
     * por exemplo, temos 10 jogadores no servidor 1 e seis no 2 ent�o o servidor de roteamento
     * manda os novos jogadores para o servidor 2 at� que fique balanceado.
     * --- aqui � a primeira instancia do cliente, ele passa primeiro por aqui pra depois 
     * entrar no jogo em si.
     * 
     * Tecnicas a serem implementadas
     * 1- broadcast
     * 2- em seguida salva o ip e a porta do cliente na tabela espec�fica para tal
     * 3- verifica qual servidor est� mais dispon�vel e leve
     * 4 - joga o cliente nesse servidor 
     * 
    **/
	public ServidorDeBalanceamento(){
		
	}
	
	public void balanceamento(Cliente cli){
		//
		
	}
	
	public void startBalanceamento(){
		System.out.println("servidor escutando!");
		
		new ThreadEscutarBroadcastCliente().start();
		
		
	}
	
	public boolean salvarClienteNaTabela(){
		/**
		 * j� fiz na camada DAO
		 * 
		 */
		return true;
	}
	
	
	
}
