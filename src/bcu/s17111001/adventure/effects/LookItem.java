package bcu.s17111001.adventure.effects;

import bcu.s17111001.adventure.model.Item;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

// This is for the player 
public class LookItem implements Effect {
	
	private String itemName;

	public LookItem(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public void execute(Player player, World world) {

		boolean itemExist = false;
		Item item = world.getItem(itemName);
		
		if(item != null)
		{
			itemExist = true;
			if(!player.canSeeItem(item))
				itemExist = false;
		}
		
		if(!itemExist) {
			System.out.println("This item does not exist");
		}else {
			System.out.println(item.getDescription());
		}
		
		
	}

}
