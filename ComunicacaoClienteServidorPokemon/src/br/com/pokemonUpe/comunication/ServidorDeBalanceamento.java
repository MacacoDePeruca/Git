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
	
	public boolean verificaServidorOnLine(Servidor server) throws UnknownHostException{
		boolean conectado = false;
		
		// verificar para todos os servidores na tabela respectiva
		
		try {
			
		Socket socket = new Socket(server.getIp(), server.getPorta());
			
			 conectado = socket.isConnected();
			
			if(conectado == true){
				System.out.println("servidor : "+server.getNomeDoServidor()+" est� online!");
				
			}else{
				System.out.println("n�o h� servidores on-line, v� se masturbar um pouco!");
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
		 *  est� on line, quantos servidores est�o on-line?
		 *  e quais s�o?
		 *  se houver apenas um servidor online mandar jogador pra ele 
		 *  se alcan�ar o n� limite de jogadores levantar 2� servidor
		 *  e assim sucessivamente.
		 */
		if(verificaServidorOnLine(new Servidor("blastoise")) == true){
			qtdClientes = dao.trazerDadosDoServidor("blastoise").getClientesOnline();
			 
		 	if(qtdClientes < dao.trazerDadosDoServidor("blastoise").getMAX_DE_CLIENTES()){
		 		// conecta com o servidor principal, balstoise!
		 		cli.setSocket(conectarComServidor(cli, "blastoise"));
		 		cliDao.salvarCliente(cli);
		 		
		 	}else {
		 		// aqui come�a a matem�tica com balanceamento!!!
		 		
		 	}
			
		}else{
			// aqui � caso por algum motivo o servidor principal caia
			log.falhaAoConectar();
			// verifica se o servidor secund�rio est� on-line
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
