package br.com.pokemonUpe.comunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ThreadEnviarBroadcastServidor {
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

			byte[] buff = nomeCliente.getBytes();

			DatagramPacket pkg = new DatagramPacket(buff, buff.length, end, porta);

			DatagramSocket ds = new DatagramSocket();//responsável para enviar
            ds.send(pkg);
            ds.close();
                        
		}

		catch (Exception e) {

			System.out.println("Nao foi possivel enviar a mensagem");

		}
    }
}
