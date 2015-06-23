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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return conectado ;
	}
	
	public void balanceamento(Cliente cli) throws UnknownHostException, SQLException{
		ServidorDAO dao = new ServidorDAO();
		ClienteDAO cliDao = new ClienteDAO();
		int qtdClientes = 0;
		/** 
		 * fazer conexao socket direta com servidor pra veer se o mesmo
		 *  está on line, quantos servidores estão on-line?
		 *  e quais são?
		 *  se houver apenas um servidor online mandar jogador pra ele 
		 *  se alcançar o nº limite de jogadores levantar 2º servidor
		 *  e assim sucessivamente.
		 */
		if(verificaServidorOnLine(new Servidor("blastoise")) == true){
			qtdClientes = dao.trazerDadosDoServidor("blastoise").getClientesOnline();
			 
		 	if(qtdClientes < dao.trazerDadosDoServidor("blastoise").getMAX_DE_CLIENTES()){
		 		// conecta com o servidor principal, balstoise!
		 		cli.setSocket(conectarComServidor(cli, "blastoise"));
		 		cliDao.salvarCliente(cli);
		 		
		 	}else {
		 		// aqui começa a matemática com balanceamento!!!
		 		
		 	}
			
		}else{
			// aqui é caso por algum motivo o servidor principal caia
			log.falhaAoConectar();
			// verifica se o servidor secundário está on-line
			if(verificaServidorOnLine(new Servidor("charizard"))== true){
				cli.setSocket(conectarComServidor(cli, "charizard"));
			}
			
		}
		
	}
	public Socket conectarComServidor(Cliente cliente, String nomeServidor) throws SQLException{
		ServidorDAO dao = new ServidorDAO();
		try {
			cliente.setSocket(new Socket(dao.trazerDadosDoServidor(nomeServidor).getIp(), dao.trazerDadosDoServidor(nomeServidor).getPorta()));
			return cliente.getSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void startBalanceamento(){
		//System.out.println("servidor escutando!");
		
		new ThreadEscutarBroadcastCliente().start();
		
		
	}
	
}
