package br.com.pokemonUpe.comunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import br.com.pokemonUpe.DAO.ClienteDAO;

import com.mysql.jdbc.PreparedStatement;


public class ThreadEscutarBroadcastCliente extends Thread{
	/**
	 * essa thread vai ser usada para escutar o cliente
	 * e depois mand outro broadcast
	 */
	int clientesOnLine =0;
	public void run(){
		try {
			while(true){
			//System.out.println("Servidor escutando");
			InetAddress grp = InetAddress.getByName("233.0.0.3");

			MulticastSocket mcs;
			
			mcs = new MulticastSocket(3333);

			mcs.joinGroup(grp);

			byte rec[] = new byte[30];

			DatagramPacket pkg = new DatagramPacket(rec, rec.length);
			
			pkg.getAddress();
			
			System.out.println("Aguardando Broadcasting");
			mcs.receive(pkg);
			
			String data = new String(pkg.getData());
			
			String msg = data;
			String ip = pkg.getAddress().toString();
			int porta = pkg.getPort();
			
			System.out.println(porta);
			System.out.println(ip);
			System.out.println(msg);
			
			//final int porta = 2222;
			Cliente cliente = new Cliente();
			cliente.setIdCliente(1);
			cliente.setNome(msg);
			cliente.setIp(ip);
			cliente.setPorta(porta);
			System.out.println("Thread escutar: "+msg);
			System.out.println("Thread escutar: "+ip);
			System.out.println("Thread escutar: "+porta);
			ClienteDAO dao= new ClienteDAO();
			
			if(dao.salvarCliente(cliente)== true){
				clientesOnLine++;
			}
			
			System.out.println("ON THE LINE : "+clientesOnLine);
			
// grita voltando
			ServidorDeBalanceamento bala= new ServidorDeBalanceamento();
			//bala.balanceamento(cliente); chama o metodo de balanceamento que vai retornar o ip e porta do servidor disponível
			
			msg = "192.168.0.100 1111 ";
			
			System.out.println("Servidor de balaceamento enviou o ip: "+msg.substring(13)+"e porta : "+porta+" do servidor para o cliente");
			
			grp = InetAddress.getByName("232.0.0.2");
			
			byte[] buff = msg.getBytes();

			pkg = new DatagramPacket(buff, buff.length, grp, 2222);

			DatagramSocket ds = new DatagramSocket();
			
			ds.send(pkg);
			
			ds.close();
			
			mcs.close();
			

			}
		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}
	

}
