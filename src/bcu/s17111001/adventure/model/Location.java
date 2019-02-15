package bcu.s17111001.adventure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Location {
	// TODO: declare fields
	private String name;
	private String description;
	private Map<String, Location> neighbours;// Where String is the direction name
	private List<Item> items;
	
	
	public Location(String name, String description) {
		// TODO: implement constructor
		this.name = name;
		this.description= description;
		this.neighbours = new HashMap<>();
		this.items = new ArrayList<Item>();
	}
	
	public String getName() {
		// TODO: implement getName method
		return name;
	}
	


	public String getDescription() {
		// TODO: implement getDescription method
		
		return description;
	}
	


	public void addNeighbour(String direction, Location neighbour) {
		// TODO: implement addNeighbour method
		if(!neighbours.containsKey(direction))
			neighbours.put(direction, neighbour);
		
	}
	
	public Location getNeighbour(String direction) {
		// TODO: implement getNeighbour method
		if(neighbours.containsKey(direction))
			return neighbours.get(direction);
		else
			return null;
	}
	
	public Collection<String> getAllDirections() {
		// TODO: implement getAllDirections method
		return neighbours.keySet();
	}
	
	public List<Item> getItems() {
		// TODO: implement getItems method

		return Collections.unmodifiableList(items);
	}
	
	public void addItem(Item item) {
		// TODO: implement addItem method
		Location oldLocation = item.getLocation();
		if(oldLocation != null)
			oldLocation.removeItem(item);
		
		item.setLocation(this);
		items.add(item);
	}
	
	public boolean hasItem(Item item) {
		// TODO: implement hasItem method
		return items.contains(item);

	}
	
	public void removeItem(Item item) throws IllegalArgumentException{
		// TODO: implement removeItem method
		if(items.contains(item)) {
		items.remove(item);
		item.setLocation(null);
	}else {
		throw new IllegalArgumentException ("Item not in this location");
	}
	}
}

