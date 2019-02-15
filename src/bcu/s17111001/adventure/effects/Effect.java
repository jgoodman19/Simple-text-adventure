package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.game.QuitException;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public interface Effect {
	public void execute(Player player, World world) throws QuitException;
}
