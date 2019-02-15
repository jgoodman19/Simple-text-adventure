package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.model.Item;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class DropItem implements Effect{

	private String itemName;
	public DropItem(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		/*When executed, this effect causes the player to remove that item from their 
		 * inventory, leaving it in their current location. However, if the item 
		 * is not in the player’s inventory, or there is no item of that name, 
			then instead an informative message is printed.
		 */

		try {
			Item item = world.getItem(itemName);
			if(item == null)
				throw new IllegalArgumentException ("There is no item of that name");
			
			player.dropItem(item);
			System.out.println(item.getName()+" dropped.");
			
		}
		catch(IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
