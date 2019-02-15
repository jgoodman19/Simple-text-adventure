package bcu.s17111001.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	// TODO: declare fields
	private Location place;
	private List<Item> inventory;
	
	
	public Player(Location location) {
		// TODO: implement constructor
		this.place = location;
		this.inventory = new ArrayList<Item>();
	}
	
	public Location getLocation() {
		// TODO: implement getLocation method
		return place;
	}
	
	public void setLocation(Location location) {
		// TODO: implement setLocation method
		place = location;
	}
	
	public void takeItem(Item item) {
		// TODO: implement takeItem method
		if(!item.getLocation().getName().trim().equals(getLocation().getName().trim()))
			throw new IllegalArgumentException("The item you are looking for isn't here");
		
		if (!item.isPortable())
			throw new IllegalArgumentException("That item cannot be transported");
		
		if(inventory.contains(item)) 
			throw new IllegalArgumentException("Item already exist in player's inventory");
		
		inventory.add(item);
	}
		
	
	
	public boolean hasItem(Item item) {
		// TODO: implement hasItem method
		return (inventory.contains(item));

	}
	
	public boolean canSeeItem(Item item) {
		// TODO: implement canSeeItem method
		return (hasItem(item) || item.getLocation()== getLocation());
		}
	
	public void dropItem(Item item) throws IllegalArgumentException{
		// TODO: implement dropItem method
		if(inventory.contains(item)) {
			inventory.remove(item);
			place.addItem(item);
		}else {
			throw new IllegalArgumentException ("You have no item in your inventory");
		}
	}

	
	public List<Item> getInventory() {
		// TODO: implement getInventory method
		return Collections.unmodifiableList(inventory);
		
	}
}
