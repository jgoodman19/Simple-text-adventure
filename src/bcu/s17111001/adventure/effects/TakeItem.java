package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.model.Item;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class TakeItem implements Effect{

	private String itemName;
	public TakeItem(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		/*When executed, it takes that item into the player’s inventory. 
		 * However, if the player is already carrying the item, 
		 * or it is not in the player’s current location,
		 * or the item is not portable, 
		 * or there is no item of that name, then instead an informative message is printed.
		 */

		try {
			Item item = world.getItem(itemName);
			if(item == null) 
				throw new IllegalArgumentException("There is no such item");
			
			player.takeItem(item);
			System.out.println("You are now carrying "+item.getName());
		}
		catch(IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
