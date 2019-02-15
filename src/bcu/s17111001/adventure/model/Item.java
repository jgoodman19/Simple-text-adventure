package bcu.s17111001.adventure.model;

public class Item {
	private String name;
	private String description;
	private Location place;
	private Boolean port;

	//TODO: declare fields
	
	public Item(String name, String description) {
		// TODO: implement constructor
		this.name = name;
		this.description = description;
		this.port = false;
		place = null;
		
	}
	
	public String getName() {
		// TODO: implement getName method
		
		
		
		return name;
	}
	
	public String getDescription() {
		// TODO: implement getDescription method
		return description;
	}
	
	public Location getLocation() {
		// TODO: implement getLocation method
		return place;
	}
	
	public void setLocation(Location location) {
		// TODO: implement setLocation method
		place = location;
	}
	
	public boolean isPortable() {
		// TODO: implement isPortable method
		return port;
	}
	
	public void setPortable(boolean portable) {
		// TODO: implement setPortable method
		port = portable; 
		
	}
}
