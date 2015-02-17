package org.intentor.sf.core.processors;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import org.intentor.sf.core.listeners.*;

import org.intentor.sf.core.events.*;

/***
 * Processamento de conex�o com sockets.
 */
public abstract class SocketProcessor implements Runnable {
	
	/**
	 * Indica se o processador est� conectado.
	 */
	protected boolean connected;
	
	/***
	 * Thread para inicializa��o de conex�es.
	 */
	protected Thread connectionThread;
	
	/***
	 * Porta de comunica��o do socket.
	 */
	protected int port;
	
	/***
	 * Thread de recebimento de mensagens.
	 */
	protected Thread commandsThread;
	
	/***
	 * Leitor de recebimento de mensagens.
	 */
	protected BufferedReader in = null;
	
	/***
	 * Escritor de envio de mensagens.
	 */
	protected PrintWriter out = null;
	
	/**
     * Listeners de eventos de comandos.
     */
	protected List<SocketCommandsListener> listenersCommands = new LinkedList<SocketCommandsListener>();
	
	/**
     * Listeners de eventos de conex�o.
     */
	protected List<SocketConnectionListener> listenersConnection = new LinkedList<SocketConnectionListener>();
	
	/***
	 * Inicializa o gerenciador.
	 * @param port Porta de comunica��o do socket.
	 */
	public SocketProcessor(int port) {
		this.port = port;
	}
	
	/***
	 * Inicializa a leitura de mensagens da entrada.
	 * @throws IOException
	 */
	protected void startListeningMessages() throws IOException {
		this.commandsThread = new ReceiveCommandsThread();
		this.commandsThread.start();
	}
	
	/***
	 * Inicia a conex�o do socket.
	 * @throws IOException 
	 */
	public void start() {
		this.connectionThread = new Thread(this);
		this.connectionThread.start();
	}
	
	/***
	 * Fecha a conex�o com o socket.
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (this.commandsThread != null && this.commandsThread.isAlive()) this.commandsThread.interrupt();
		
		this.listenersCommands.clear();
		this.listenersConnection.clear();
		
		this.out.close();
		this.in.close();
		
		this.connected = false;
	}
	
	/**
	 * Indica se o socket est� conectado.
	 * @return Valor booleano indicando se o socket est� conectado.
	 */
	public boolean isConnected() {
		return this.connected;
	}

	/***
	 * M�todo para execu��o de conex�o inicial.
	 */
	@Override
	public abstract void run();
	
	/***
	 * Envia um comando ao socket conectado.
	 * @param command Comando a ser enviado.
	 * @throws IOException
	 */
	public void sendCommand(String command) {
		this.out.println(command);
	}
	
	/***
	 * Dispara evento de recebimento de comando.
	 * @param e	Objeto representando o evento disparado. 
	 */
	protected void fireCommandReceivedEvent(CommandReceivedEvent e) {
        for (SocketCommandsListener l : this.listenersCommands) l.commandReceived(e);
	}
	
	/***
	 * Dispara evento de in�cio de conex�o de jogador.
	 * @param e	Objeto representando o evento disparado. 
	 */
	protected void firePlayerConnectedEvent(PlayerConnectedEvent e) {
		this.connected = true;
        for (SocketConnectionListener l : this.listenersConnection) l.playerConnectedReceived(e);
	}
	
	/***
	 * Dispara evento de desconex�o de jogador.
	 * @param e	Objeto representando o evento disparado. 
	 */
	protected void firePlayerDisconnectedEvent(PlayerDisconnectedEvent e) {
		this.connected = false;
        for (SocketConnectionListener l : this.listenersConnection) l.playerDisconnectedReceived(e);
	}
		
	/***
	 * Dispara evento de erro de conex�o.
	 * @param message Mensagem do erro ocorrido. 
	 */
	protected void fireConnectionErrorEvent(String message) {
		ConnectionErrorEvent e = new ConnectionErrorEvent(this, message);
		this.fireConnectionErrorEvent(e);
	}
	
	/***
	 * Dispara evento de erro de conex�o.
	 * @param e	Objeto representando o evento disparado. 
	 */
	protected void fireConnectionErrorEvent(ConnectionErrorEvent e) {
		this.connected = false;
        for (SocketConnectionListener l : this.listenersConnection) l.connectionErrorReceived(e);
	}
	
	/***
     * Adiciona listener de eventos de comandos.
     * @param l Listener do evento.
     */
    public void addCommandsListener(SocketCommandsListener l) {
        this.listenersCommands.add(l);
    }
    
    /***
     * Remove listener de eventos de comandos.
     * @param l Listener do evento.
     */
    public void removeCommandsListener(SocketCommandsListener l) {
        this.listenersCommands.remove(l);
    }
    
    /***
     * Adiciona listener de eventos de conex�o.
     * @param l Listener do evento.
     */
    public void addConnectionListener(SocketConnectionListener l) {
        this.listenersConnection.add(l);
    }
    
    /***
     * Remove listener de eventos de conex�o.
     * @param l Listener do evento.
     */
    public void removeConnectionListener(SocketConnectionListener l) {
        this.listenersConnection.remove(l);
    }
    
    /***
     * Thread de leitura de mensagens via rede.
     */
	protected class ReceiveCommandsThread extends Thread {
		/***
		 * Executa leitura de mensagens em thread separada.
		 * @throws IOException
		 */
		public void run() {
			String inputLine = null;
			try {
				while ((inputLine = in.readLine()) != null) {
					CommandReceivedEvent e = new CommandReceivedEvent(this, inputLine);
					fireCommandReceivedEvent(e);
				}
			} catch (IOException e) {
				firePlayerDisconnectedEvent(new PlayerDisconnectedEvent(this));
			}
		}
    }
}
