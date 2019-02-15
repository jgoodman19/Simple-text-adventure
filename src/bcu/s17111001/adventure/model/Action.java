package bcu.s17111001.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bcu.s17111001.adventure.effects.Effect;

public class Action {
	// TODO: declare fields
	private String name;
	private List<Item> requiredItems;
	private List<Effect> effects;

	
	public Action(String name) {
		// TODO: implement constructor
		this.name = name;
		this.requiredItems = new ArrayList<Item>();
		this.effects = new ArrayList<Effect>();


		
	}
	
	public String getName() {
		// TODO: implement getName method
		return name;
		
	}
	
	public void addRequiredItem(Item item) {
		// TODO: implement addRequiredItem method
		requiredItems.add(item);
	}
	
	public boolean isAllowed(Player player) {
		// TODO: implement isAllowed method
		int allowed = 0;
		for(Item i: requiredItems) {
			if(player.hasItem(i)) {
				allowed = 1;
				break;
				}else {
					return false;
				}
				
			}
			if(allowed == 1) {
				return true;
			}else {
				return false;
			}
		}

	
	
	public void addEffect(Effect effect) {
		// TODO: implement addEffect method
		effects.add(effect);
	}
	
	public List<Effect> getEffects() {
		// TODO: implement getEffects method
		return Collections.unmodifiableList(effects);
	}
}
