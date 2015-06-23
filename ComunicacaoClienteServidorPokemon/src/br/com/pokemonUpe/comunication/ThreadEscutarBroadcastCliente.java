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
		String msg;
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
				
				//System.out.println("Aguardando Broadcasting");
				mcs.receive(pkg);
				
				String data = new String(pkg.getData());
				String s[] = data.split(" ");
				
				if (s[0].equals("cliente")){//trata o multicast vindo do cliente 
					
					String ip = pkg.getAddress().toString();
					int porta = pkg.getPort();

					Cliente cliente = new Cliente();
					
					cliente.setIdCliente(1);
					cliente.setNome(s[1]);
					cliente.setIp(ip);
					cliente.setPorta(porta);

					ClienteDAO dao = new ClienteDAO();
					
					if(dao.salvarCliente(cliente)== true){
						clientesOnLine++;
					}
					
					System.out.println("ON THE LINE : "+clientesOnLine);
					
					// grita voltando
					ServidorDeBalanceamento bala = new ServidorDeBalanceamento();
					//bala.balanceamento(cliente); chama o metodo de balanceamento que vai retornar o ip e porta do servidor disponível
					
					msg = "192.168.0.101 1111 ";
					
					grp = InetAddress.getByName("232.0.0.2");
					
					byte[] buff = msg.getBytes();
					
					pkg = new DatagramPacket(buff, buff.length, grp, 2222);
					
					DatagramSocket ds = new DatagramSocket();
					
					ds.send(pkg);
					
					ds.close();
					
					mcs.close();

				}
				else if (s[0].equals("servidor")){//trata o multicast vindo do servidor
					System.out.println("Servidor x ativo");
				}
				else{
					System.out.println("Remedente indisponível");
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
