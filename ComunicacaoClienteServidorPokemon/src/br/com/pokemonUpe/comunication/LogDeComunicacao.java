/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokemonUpe.comunication;

/**
 *
 * @author Vitor
 */
public class LogDeComunicacao {
    public void aguardandoConexaoComOservidor(){
        System.out.println("aguardando conexao socket");
    }
    public void falhaAoConectar(){
    	System.out.println("não foi possivel se conectar ao servidor, por favor tente novamente"+
    "em alguns instantes");
    }
    public void sucesso(String nomeDoServidor, int jogadores){
    	System.out.println("conexão estabelecida com sucesso!"+" SERVIDOR :"+nomeDoServidor
    			+" NUMERO DE JOGADORES : "+jogadores);
    }
}
