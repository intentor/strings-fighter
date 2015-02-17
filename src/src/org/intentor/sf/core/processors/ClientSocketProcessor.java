package org.intentor.sf.core.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.intentor.sf.core.events.PlayerConnectedEvent;

/***
 * Processamento de conexão com sockets a partir do cliente.
 */
public class ClientSocketProcessor extends SocketProcessor {

	Socket echoSocket = null;
	String ip;
	
	public ClientSocketProcessor(String ip, int port) {
		super(port);
		this.ip = ip;
	}
	
	@Override
	public void run() {
		try {
			try {
				this.echoSocket = new Socket(this.ip, this.port);
				this.out = new PrintWriter(this.echoSocket.getOutputStream(), true);
				this.in = new BufferedReader(new InputStreamReader(this.echoSocket.getInputStream()));
			} catch (UnknownHostException e) {
	        	throw new Exception("Host adress not found.");
			} catch (IOException e) {
	        	throw new Exception("Host connection failure: " + e.getMessage());
			}

			this.startListeningMessages();	
			this.firePlayerConnectedEvent(new PlayerConnectedEvent(this));	
		} catch (Exception e) {
        	fireConnectionErrorEvent(e.getMessage());
		} finally {
    		this.connectionThread.interrupt();
		}
	}
	
	@Override
	public void close() throws IOException {
		super.close();
		this.echoSocket.close();
	}
}