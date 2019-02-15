package bcu.s17111001.adventure.effects;

import java.util.List;

import bcu.s17111001.adventure.model.Item;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class ShowInventory implements Effect {

	public ShowInventory() {}
	
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		/*When executed, it prints a list of items in the player’s inventory. 
		 * However, if the player’s inventory is empty then instead an informative message is printed.
		 */

		List<Item> items = player.getInventory();
		if(items.size() == 0) {
			System.out.println("There are no items in player's inventory");
			return;
		}
		
		for(Item item : items) {
			System.out.println(item.getName()+", "+item.getDescription());
		}
	}

}
