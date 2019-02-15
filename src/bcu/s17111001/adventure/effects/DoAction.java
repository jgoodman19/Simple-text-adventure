package bcu.s17111001.adventure.effects;

import java.util.List;

import bcu.s17111001.adventure.model.Action;
import bcu.s17111001.adventure.model.Player;
import bcu.s17111001.adventure.model.World;

public class DoAction implements Effect {

	private String actionName;
	public DoAction(String actionName) {
		this.actionName = actionName;
	}
	
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		/*The execute method gets the action of that name from the world and performs it 
		 * (i.e. executes all its effects). 
		 * However, if the player is not allowed to perform this action, or 
		 * there is no action of that name, then instead an informative message is printed.
		 */

		Action action = world.getAction(actionName);
		if(action == null) {
			System.out.println("Action does not exist");
			return;
		}
		
		if(!action.isAllowed(player)) {
			System.out.println("Action is not allowed for this player");
			return;			
		}
		
		List<Effect> effects = action.getEffects();
		try {
			for(Effect effect : effects) {
				effect.execute(player, world);
			}
		}
		catch(Exception er) {			
		}
		
	}

}
