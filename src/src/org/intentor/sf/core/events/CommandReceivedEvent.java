package org.intentor.sf.core.events;

import java.awt.Point;
import java.util.EventObject;

import org.intentor.sf.core.GameCommand;
import org.intentor.sf.core.PlayerCommands;

/**
 * Representa evento de comando recebido.
 */
@SuppressWarnings("serial")
public class CommandReceivedEvent extends EventObject {
	
	/***
	 * Comando executado pelo jogador.
	 */
	public GameCommand command;
	
	/**
	 * Posição atual do jogador.
	 */
	public Point currentPosition;
		
	/***
	 * Cria um novo evento.
	 * @param source		Fonte do evento.
	 * @param commandStr	Comando recebido.
	 */
	public CommandReceivedEvent(Object source, String commandStr) {
        super(source);

        String[] args = commandStr.split(";");
        
        int player = Integer.valueOf(args[0]);
        PlayerCommands cmd = PlayerCommands.getCommandByID(args[1]);
        
        this.command = new GameCommand(player, cmd);
        
        for (int i = 2; i < args.length; i++) this.command.addArgument(args[i]);
    }
}
