/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.pokemonUpe.DAO.ClienteDAO;

/**
 *
 * @author Vitor
 */
public class ServidorDeBalanceamento {
    private int contadorDeClientes;
	
	/**
     * Servidor de balanceamento, a estratégia aqui é bem simples, saber quantos jogadores
     * tem em cada servidor e tentar sempre distribuir a carga
     * por exemplo, temos 10 jogadores no servidor 1 e seis no 2 então o servidor de roteamento
     * manda os novos jogadores para o servidor 2 até que fique balanceado.
     * --- aqui é a primeira instancia do cliente, ele passa primeiro por aqui pra depois 
     * entrar no jogo em si.
     * 
     * Tecnicas a serem implementadas
     * 1- broadcast
     * 2- em seguida salva o ip e a porta do cliente na tabela específica para tal
     * 3- verifica qual servidor está mais disponível e leve
     * 4 - joga o cliente nesse servidor 
     * 
    **/
	public ServidorDeBalanceamento(){
		
	}
	
	public Servidor verificaServidorOnLine(Servidor server) throws UnknownHostException{
		 
		
		// verificar para todos os servidores na tabela respectiva
		
		try {
			
		Socket socket = new Socket(server.getIp(), server.getPorta());
			
			boolean conectado = socket.isConnected();
			
			if(conectado == true){
				System.out.println("servidor : "+server.getNomeDoServidor()+" está online!");
				
			}else{
				System.out.println("não há servidores on-line, vá se masturbar um pouco!");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return server;
	}
	public void conexaoDiretaComServidorSocket(Servidor servidor){
		
		
		
		
	}
	public void balanceamento(Cliente cli){
		/** 
		 * fazer conexao socket direta com servidor pra veer se o mesmo
		 *  está on line, quantos servidores estão on-line?
		 *  e quais são?
		 *  se houver apenas um servidor online mandar jogador pra ele 
		 *  se alcançar o nº limite de jogadores levantar 2º servidor
		 *  e assim sucessivamente.
		 */
		
		
	}
	
	public void startBalanceamento(){
		System.out.println("servidor escutando!");
		
		new ThreadEscutarBroadcastCliente().start();
		
		
	}
	
}
