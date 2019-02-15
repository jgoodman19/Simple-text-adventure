package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.game.QuitException;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class Quit implements Effect{

	public Quit() {
		
	}
	
	@Override
	public void execute(Player player, World world) throws QuitException {
		// TODO Auto-generated method stub		
		throw new QuitException();		
	}

}
