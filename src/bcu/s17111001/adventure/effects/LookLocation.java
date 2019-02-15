package bcu.s17111001.adventure.effects;

import java.util.Collection;
import java.util.List;

import bcu.s17111001.adventure.model.Item;
import bcu.s17111001.adventure.model.Location;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class LookLocation implements Effect{

	public LookLocation() {
		
	}
	
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		/*When executed, it gets the player’s current location and prints:
		 *  (i) the location’s description;
		 *  (ii) a list of items there, if any; and
		 *  (iii) a list of directions the player can walk.
		 */

		Location location = player.getLocation();
		// print location description 
		
		System.out.println(location.getDescription());
		
		// (ii) a list of items there, if any
		List<Item> items = location.getItems();
		if(items.size() > 0) {
			System.out.println("Item in the location : ");
			for(Item item : items) {
				System.out.println(item.getName()+", "+item.getDescription());
			}
		}
		
		// a list of directions the player can walk
		Collection<String> directions = location.getAllDirections();
		if(directions.size() > 0) {
			System.out.println("Reachable directions : ");
			for(String direction : directions) {
				System.out.println(direction);
			}
		}
	}

}
