/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

import java.io.IOException;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitor
 */
public class Servidor {
    private final int MAX_DE_CLIENTES =10;
	static MulticastSocket mcs;
    private ServerSocket serverSocket;
    private Socket socket;
    private LogDeComunicacao log = new LogDeComunicacao();
    
    public Servidor(Socket socket) {
        this.socket = socket;
        
    }
    
    public void StartarServidor(){
        
        try {
            // a porta 1111 foi escolhida como padrão no sistema para startar o servidor
            serverSocket = new ServerSocket(1111);
                while (true){
                   new ThreadEscutarBroadcastCliente().start();
                   log.aguardandoConexaoComOservidor();
                   Socket s = serverSocket.accept();
                new ThreadConexaoCliente(s).start();
                   /**
                    * criar classe de log pra mostrar a movimentação dentro do 
                    * servidor mas por enquanto o System out serve
                    */
                	log.aguardandoConexaoComOservidor();
                   
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
}
