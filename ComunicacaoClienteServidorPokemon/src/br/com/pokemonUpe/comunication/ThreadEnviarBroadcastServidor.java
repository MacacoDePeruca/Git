package br.com.pokemonUpe.comunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

public class ThreadEnviarBroadcastServidor extends Thread {
String nomeCliente;
/**
 * essa thread serve para enviar um broadcast na rede
 * para que o servidor que está em estado de escutar receba
 *  a requisição.
 */
	public ThreadEnviarBroadcastServidor(){
		
	}
	
	public void run(){
        final String IpGrupo = "233.0.0.3";
		final int porta = 3333; // a definir
		
		try {
			
			InetAddress end = InetAddress.getByName(IpGrupo);//envia multicast para o IpGrupo

			nomeCliente = "ash";
			String msg = "cliente " + nomeCliente + " ";
			
			byte[] buff = msg.getBytes();

			DatagramPacket pkg = new DatagramPacket(buff, buff.length, end, porta);

			DatagramSocket ds = new DatagramSocket();//responsável para enviar
            ds.send(pkg);
            ds.close();
            //System.out.println("Cliente enviou broadcast");
		}

		catch (Exception e) {

			System.out.println("Nao foi possivel enviar a mensagem");

		}
		
		try {
			
			InetAddress grp = InetAddress.getByName("232.0.0.2");

			MulticastSocket mcs;
			
			mcs = new MulticastSocket(2222);

			mcs.joinGroup(grp);

			byte rec[] = new byte[100];

			DatagramPacket pkg = new DatagramPacket(rec, rec.length);
			
			pkg.getAddress();
			
			//System.out.println("Aguardando servidor de rota informar o servidor");
			mcs.receive(pkg);
			
			String data = new String(pkg.getData());
						  
			String s[] = data.split(" ");
			String ipServidor = s[0];
			int portaServidor = Integer.parseInt(s[1]);
			//System.out.println(ipServidor);
			//System.out.println(portaServidor);
			mcs.close();
			
			Socket socket = new Socket(ipServidor, portaServidor);
			
			System.out.println("Conectado ao servidor via socket");
			PrintStream saida = new PrintStream(socket.getOutputStream());
			new ThreadReceberMsgConxeao(socket).start();
			
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			String msg;
			while (true) {
				msg = teclado.readLine();
				// envia o conteudo de 'msg' para o servidor
				saida.println(msg);
			}
			
		}
		
		catch (Exception e) {

			e.printStackTrace();

		}
		
    }
}
