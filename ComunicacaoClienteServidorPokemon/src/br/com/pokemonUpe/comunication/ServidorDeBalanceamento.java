/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import br.com.pokemonUpe.DAO.ServidorDAO;


public class ServidorDeBalanceamento {
    
	public ServidorDeBalanceamento(){
		
	}
	
	public boolean verificaServidorOnLine(Servidor server) throws UnknownHostException{
		boolean conectado = false;
		
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
