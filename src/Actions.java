
public class Actions {
	public Action[] actions;
	
	public Action[] buildActionArray() {
		//This will build an array with relevant actions
		String[] laStrArr = {"Look Around", "Look"};
		Action lookAround = new Action("Look Around", laStrArr, "Used to check for items in a room.");
		String[] ciStrArr = {"Check Inventory", "Check Inv"};
		Action checkInv = new Action("Check Inventory", ciStrArr, "Check what is currently in your hands.");
		String[] eStrArr = {"Examine"};
		Action examine = new Action("Examine [Item]", eStrArr, "Provides more details on an object. Ex. \"Examine bed\"");
		String[] gStrArr = {"Grab"};
		Action grab = new Action("Grab [Item]", gStrArr, "Allows you to interact with an item or pick it up. Ex. \"Grab key\"");
		String[] dStrArr = {"Drop"};
		Action drop = new Action("Drop [Item]", dStrArr, "The drop action removes an item from your hand. You must be holding the item. Ex. \"Drop key\"");
		String[] tStrArr = {"Talk"};
		Action talk = new Action("Talk [Item]", tStrArr, "You can communicate with some items/beings with this action. Ex. \"Talk Marvin\"");
		String[] hStrArr = {"Help"};
		Action help = new Action("Help [Action]", hStrArr, "Asking for help with the help action is a little meta isn't it? This will show you the help text for an action. Ex. \"Help Grab\"");
		String[] qStrArr = {"Quit", "Exit", "Stop"};
		Action quit = new Action("Quit", qStrArr, "This will quit the adventure.");
	
		Action[] tmpActions = {lookAround, checkInv, examine, grab, drop, talk, help, quit};
		actions = tmpActions;
		return actions;
		
	}
	
	
	
}
