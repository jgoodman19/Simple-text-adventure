package bcu.s17111001.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bcu.s17111001.adventure.effects.Effect;

public class World {
	// TODO: declare fields
	private Location startLocation;
	private Map<String, Item> items;
	private Map<String, Location> locations;
	private Map<String, Action> actions;
	private List<Effect> effects;
	
	
	public World() {
		// TODO: implement constructor
		this.startLocation = null;
		this.items = new HashMap<>();
		this.locations = new HashMap<>();
		this.actions = new HashMap<>();
		this.effects = new ArrayList<Effect>();
	}
	
	public Location getStartingLocation() {
		return startLocation;
		// TODO: implement getStartingLocation method
	}
	
	public void setStartingLocation(Location location) {
		// TODO: implement setStartingLocation method
		startLocation = location;
	}
	
	public Item getItem(String name) {
		// TODO: implement getItem method
		if(items.containsKey(name))
			return items.get(name);
		else
			return null;
	}
	
	public Item addItem(String name, String description) throws IllegalArgumentException{
		// TODO: implement addItem method
		if(items.containsKey(name)) {
			throw new IllegalArgumentException("This item already exists");
		}else {
			Item item = new Item(name, description);
			items.put(name, item);
			return item;
		}
		
	}
	
	public Location getLocation(String name) {
		// TODO: implement getLocation method
		if(locations.containsKey(name))
			return locations.get(name);
		else
			return null;
	}
	
	public Location addLocation(String name, String description) throws IllegalArgumentException{
		// TODO: implement addLocation method
		if(locations.containsKey(name)) {
			throw new IllegalArgumentException("This location already exists");
		} else {
			Location place = new Location(name, description);
			locations.put(name, place);
			return place;
		}
	}
	
	public Action getAction(String name) {
		// TODO: implement getAction method
		if(actions.containsKey(name))			
			return actions.get(name);
		else
			return null;
	}
	
	public Action addAction(String name) throws IllegalArgumentException{ 
		// TODO: implement addAction method
		if(actions.containsKey(name)) {
			throw new IllegalArgumentException("This action already exists");
		} else {
			Action action = new Action(name);
			actions.put(name, action);
			return action;
		}
	}
	
	
	public void onStart(Effect effect) {
		// TODO: implement onStart method
		effects.add(effect);
	}
	
	public List<Effect> getStartEffects() {
		// TODO: implement getStartEffects method
		return Collections.unmodifiableList(effects);
	}
}
