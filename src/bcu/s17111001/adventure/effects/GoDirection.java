package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.model.Location;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class GoDirection implements Effect{

	String direction;
	public GoDirection(String direction) {
		this.direction = direction;
	}
	
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		/*When executed, this effect causes the player to move to the neighbour 
		 * of their current location in the given direction.
		 *  However, if there is no neighbour in that direction, 
		 *  then instead an informative message is printed.
		 */
		Location currentLocation = player.getLocation();
		Location neighbour = currentLocation.getNeighbour(direction);
		
		if(neighbour == null)
			System.out.println("There is no such neighbour in this direction");
		
		player.setLocation(neighbour);
		System.out.println("Player moved to "+neighbour.getName());
	}

}
