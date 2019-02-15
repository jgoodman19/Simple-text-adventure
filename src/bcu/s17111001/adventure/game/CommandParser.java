package bcu.s17111001.adventure.game;

import bcu.s17111001.adventure.effects.Effect;
import bcu.s17111001.adventure.effects.*;

public class CommandParser {
	public static final String HELP_MESSAGE =
		"Commands:\n" +
		"    look              Look around you.\n" +
		"    look [item]       Look at an item.\n" +
		"    inventory         Look at your inventory.\n" +
		"    go [direction]    Walk in a direction.\n" +
		"    take [item]       Take an item.\n" +
		"    drop [item]       Drop an item.\n" +
		"    help              Show this help message.\n" +
		"    quit              Exit the game.";
	
	public static Effect parsePlayerCommand(String command) {
		// TODO: complete implementation of parsePlayerCommand
		String[] parts = command.split(" ");
		Effect effect = null;
		switch(parts[0]) {
			case "look":
				if(parts.length> 1) {
					effect = new LookItem(parts[1]);
				}
				else {
					effect = new LookLocation();
				}
				break;
			case "inventory":
				effect = new ShowInventory();
				break;
			case "go":
				effect = new GoDirection(parts[1]);
				break;
			case "take":
				effect = new TakeItem(parts[1]);
				break;
			case "drop":
				effect = new DropItem(parts[1]);
				break;
			case "help":
				System.out.println(HELP_MESSAGE);
				break;
			case "quit":
				effect = new Quit();
				break;
			default:
				effect = new DoAction(command);
				break;
		}
		
		return effect;
	}
}
