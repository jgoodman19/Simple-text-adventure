package bcu.s17111001.adventure.test;

import org.junit.Test;

import bcu.s17111001.adventure.model.Item;
import bcu.s17111001.adventure.model.Location;

import static org.junit.Assert.*;

public class ItemTest {
	private final Item clock = new Item("clock", "It is an old grandfather clock.");
	
	@Test
	public void testGetName() {
		assertEquals("clock", clock.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("It is an old grandfather clock.", clock.getDescription());
	}
	
	@Test
	public void testSetPortable() {
		clock.setPortable(true);
		assertTrue(clock.isPortable());
	}
	
	@Test
	public void testLocation() {
		Location house = new Location("house", "You are in a small village house.");
		clock.setLocation(house);
		assertSame(house, clock.getLocation());
	}
	
	// TODO: more unit tests
}
