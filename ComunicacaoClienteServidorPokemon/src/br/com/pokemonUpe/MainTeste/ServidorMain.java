package br.com.pokemonUpe.MainTeste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

import br.com.pokemonUpe.comunication.Servidor;
import br.com.pokemonUpe.comunication.ThreadServBalanceamentoServJogo;

public class ServidorMain {

	private static boolean parar = false;
	
	public static void setParar(boolean opcao) {
		parar = opcao;
	}
	
	public static void main(String[] args) throws IOException {
		
		String nomeServidor;
		String ip;
		int porta;
		Random random = new Random();
		
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		ip = InetAddress.getLocalHost().getHostAddress().toString();
		
		//System.out.print("Informe o nome do servidor: ");
		nomeServidor = "blastoise";//teclado.readLine();
		//System.out.print("Informe porta a ser usada: ");
		porta = 1111;//Integer.parseInt(teclado.readLine());
		
		new ThreadServBalanceamentoServJogo(ip, 1234, 1).start();
		
		int i = random.nextInt();
		int contTentativas = 1;
		
		while(!parar){
			try {
				
				InetAddress end = InetAddress.getByName("233.0.0.3");
				
				String msg = "servidor" + " " + ip + " " + porta + " " + nomeServidor + " " + i + " ";
				
				byte[] buff = msg.getBytes();
				
				DatagramPacket pkg = new DatagramPacket(buff, buff.length, end,	3333);
	
				DatagramSocket ds = new DatagramSocket();
	
				ds.send(pkg);
				
				ds.close();
				Thread.sleep(2000);
			}
	
			catch (Exception e) {
	
				System.out.println("Nao foi possivel enviar a mensagem");
	
			}
			
			contTentativas++;
			if(contTentativas > 5){
				setParar(true);
			}
		}
		setParar(false);
		
		Servidor servidor = new Servidor(nomeServidor, ip, porta);
		servidor.StartarServidor();

	}

}
