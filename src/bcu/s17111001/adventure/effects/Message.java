package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class Message implements Effect {
	
	private String message;

	public Message(String message) {
		this.message = message;
	}

	@Override
	public void execute(Player player, World world) {
		System.out.println(message);
		
		
	}

}
