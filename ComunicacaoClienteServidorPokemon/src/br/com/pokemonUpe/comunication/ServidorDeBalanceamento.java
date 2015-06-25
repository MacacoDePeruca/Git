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
import java.sql.SQLException;

import br.com.pokemonUpe.DAO.ClienteDAO;
import br.com.pokemonUpe.DAO.ServidorDAO;

/**
 *
 * @author Vitor
 */
public class ServidorDeBalanceamento {
    private int contadorDeClientes;
    private LogDeComunicacao log;
	
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
	
	public boolean verificaServidorOnLine(Servidor server) throws UnknownHostException{
		boolean conectado = false;
		
		// verificar para todos os servidores na tabela respectiva
		
		try {
			
		Socket socket = new Socket(server.getIp(), server.getPorta());
			
			 conectado = socket.isConnected();
			
			if(conectado == true){
				System.out.println("servidor : "+server.getNomeDoServidor()+" está online!");
				
			}else{
				System.out.println("não há servidores on-line, vá se masturbar um pouco!");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conectado ;
	}
	
	public String balanceamento(){
		
		try{
			Servidor serv = new Servidor();
			Servidor serv2 = new Servidor();
			ServidorDAO servDAO = new ServidorDAO();
			serv = servDAO.trazerDadosDoServidor("blastoise");
			
			if(serv.getClientesOnline() < 10){
				return serv.getIp() + " " + serv.getPorta() + " ";
			}
			else {
				serv2 = servDAO.trazerDadosDoServidor("charizard");
				if (serv2.getClientesOnline() < 10){
					return serv2.getIp() + " " + serv2.getPorta() + " ";
				}
				else{
					if(serv.getClientesOnline() > serv2.getClientesOnline())
						return serv2.getIp() + " " + serv2.getPorta() + " ";
					else
						return serv.getIp() + " " + serv.getPorta() + " ";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return " ";
		
	}
		
	public void startBalanceamento(){
		
		System.out.println("Servidor de balanceamento Ativo");
		new ThreadEscutarBroadcastCliente().start();
		
	}
	
}
