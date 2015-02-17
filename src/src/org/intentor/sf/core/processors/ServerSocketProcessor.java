package org.intentor.sf.core.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.intentor.sf.core.events.PlayerConnectedEvent;

/***
 * Processamento de conexão com sockets a partir do servidor.
 */
public class ServerSocketProcessor extends SocketProcessor {

	ServerSocket serverSocket = null;
	Socket clientSocket = null;	
	
	public ServerSocketProcessor(int port) {
		super(port);
	}
	
	@Override
	public void run() {
		try {
			try {
				InetAddress addr = InetAddress.getLocalHost();
				addr = InetAddress.getByAddress(addr.getAddress()); 
	        	this.serverSocket = new ServerSocket(port, 0, addr);
	        } catch (IOException e) {
	        	throw new IOException("Starting server failure: " + e.getMessage());
	        }
	        
	        try {
	        	this.clientSocket = serverSocket.accept();
	        } catch (IOException e) {
	        	throw new IOException("Client connection failure: " + e.getMessage());
	        }
	        

        	if (this.clientSocket.isConnected()) {
		        try {
		        	this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
					this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
				} catch (IOException e) {
		        	throw new IOException("Client connection configuration failure: " + e.getMessage());
				}
				
				this.startListeningMessages();
				PlayerConnectedEvent event = new PlayerConnectedEvent(this);
				this.firePlayerConnectedEvent(event);
        	}
		} catch (IOException e) {
        	this.fireConnectionErrorEvent(e.getMessage());
		} finally {
    		this.connectionThread.interrupt();
		}
	}
	
	@Override
	public void close() throws IOException {
		super.close();
		this.clientSocket.close();
		this.serverSocket.close();
	}
}
