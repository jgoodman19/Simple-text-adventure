package bcu.s17111001.adventure.game;

import bcu.s17111001.adventure.model.Location;

import java.util.List;
import java.util.Scanner;

import bcu.s17111001.adventure.effects.*;
import bcu.s17111001.adventure.model.*;

public class Main implements Runnable {
	private World world;
	public Main(World world) {
		this.world = world;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Player player = new Player(world.getStartingLocation());
		List<Effect> startEffects = world.getStartEffects();
		for(Effect startEffect : startEffects) {
			startEffect.execute(player, world);			
		}
		
		Scanner reader = new Scanner(System.in); 
		while(true) {
			try {
				System.out.print("> ");
				String command = reader.nextLine();
				Effect effect = CommandParser.parsePlayerCommand(command);
				effect.execute(player, world);
			}
			catch(QuitException exception) {
				break;
			}			
		}
		
		reader.close();
		reader = null;
	}
	
	public static void main(String[] args){
		World world = new World();
		Location house = world.addLocation("house", "You are in a small village house.");
		Location street =world.addLocation("street", "You are on the main street of the village.");
		
		house.addNeighbour("out", street);
		street.addNeighbour("in", house);
		
		Item clock = world.addItem("clock", "It is an old grandfather clock.");
		house.addItem(clock);
		
		Item hammer = world.addItem("hammer", "It is a brand new hammer.");
		street.addItem(hammer);		
		hammer.setPortable(true);
		
		Action useHammer = world.addAction("use hammer");
		
		useHammer.addRequiredItem(hammer);
		useHammer.addRequiredItem(clock);
		
		useHammer.addEffect(new Message("You hit the clock with the hammer."));
		useHammer.addEffect(new Message("The clock shatters into pieces."));
		useHammer.addEffect(new Message("THE END"));
		useHammer.addEffect(new Quit());
		
		world.setStartingLocation(house);
		world.onStart(new LookLocation());
		
		Main main = new Main(world);
		main.run();
	}

	
}
