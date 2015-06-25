package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.pokemonUpe.MainTeste.ServidorMain;

public class ThreadServBalanceamentoServJogo extends Thread{
	
	private ServerSocket serverSocket;
	private Socket s;
	private String ip;
	private int porta;
	private int opcao;
	PrintStream saida;
	
	public ThreadServBalanceamentoServJogo(String ip, int porta, int opcao){
		
		this.ip = ip;
		this.porta = porta;
		this.opcao = opcao;
	}
	
	public void run(){
		if (opcao == 1){//thread usada pelo servidor para aguardar uma conexão socket
			try {
	            serverSocket = new ServerSocket(porta);
	            while (true){
	            	
	                s = serverSocket.accept();
	                saida = new PrintStream(s.getOutputStream());
	                
	                new Servidor();
	                Servidor.setServBalanServJogo(saida);
	                new ServidorMain();
					ServidorMain.setParar(true);
	                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	              
	        		new ThreadReceberMsgServBalac(s).start();
	        		
	        		String msg;
	        		while (true){
	        			msg = teclado.readLine();
	        			saida.println(msg);
	        			
	    			}
	            }
	        } catch (IOException ex) {
	        	
	            ex.getMessage();
	        }finally{
	            try {
	            	serverSocket.close();
	            } catch (Exception e) {
	            	e.printStackTrace();   
	            }
	        }
		}
		
		if (opcao == 2){//thread usada pelo servidor de balanceamento para fazer conexão com o servidor
			try{
				s = new Socket(ip, porta);
				PrintStream saida = new PrintStream(s.getOutputStream());
				
				new ThreadReceberMsgServ(s).start();
				
				BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
				String msg;
				
				while (true) {
					
					msg = teclado.readLine();
					// envia o conteudo de 'msg' para o servidor do jogo
					saida.println(msg);
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
