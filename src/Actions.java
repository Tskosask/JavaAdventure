import java.util.Scanner;

//This class builds the array of actions and handles action events
public class Actions {
	public Action[] actions;
	
	public Action[] buildActionArray() {
		//This will build an array with relevant actions
		String[] laStrArr = {"Look Around", "Look"};
		Action lookAround = new Action("Look", "Look Around", laStrArr, "Used to check for items in a room.");
		String[] ciStrArr = {"Check Inventory", "Check Inv"};
		Action checkInv = new Action("Inv", "Check Inventory", ciStrArr, "Check what is currently in your hands.");
		String[] eStrArr = {"Examine"};
		Action examine = new Action("Examine", "Examine [Item]", eStrArr, "Provides more details on an object. Ex. \"Examine bed\"");
		String[] gStrArr = {"Grab"};
		Action grab = new Action("Grab", "Grab [Item]", gStrArr, "Allows you to interact with an item or pick it up. Ex. \"Grab key\"");
		String[] dStrArr = {"Drop"};
		Action drop = new Action("Drop", "Drop [Item]", dStrArr, "The drop action removes an item from your hand. You must be holding the item. Ex. \"Drop key\"");
		String[] tStrArr = {"Talk"};
		Action talk = new Action("Talk", "Talk [Item]", tStrArr, "You can communicate with some items/beings with this action. Ex. \"Talk Marvin\"");
		String[] hStrArr = {"Help"};
		Action help = new Action("Help", "Help [Action]", hStrArr, "Asking for help with the help action is a little meta isn't it? This will show you the help text for an action. Ex. \"Help Grab\"");
		String[] qStrArr = {"Quit", "Exit", "Stop"};
		Action quit = new Action("Quit", "Quit", qStrArr, "This will quit the adventure.");
	
		Action[] tmpActions = {lookAround, checkInv, examine, grab, drop, talk, help, quit};
		actions = tmpActions;
		return actions;
	}
	
	public void handleAction(String tmpActionId, String secondPhrase, Player player, Room room, Scanner userInput) {
		//check for events that have second phrases
		if (secondPhrase != null) {
			if (tmpActionId.equals("HELP")) {
				//print out the action's help text
				int[] currActionIndexAndLength = getActionFromPhrase(secondPhrase);
				Action actionToHelpWith = currActionIndexAndLength != null ? actions[currActionIndexAndLength[0]] : null;
	
				if (actionToHelpWith != null) {
					System.out.print(actionToHelpWith.helpText + " \n");
				} else {
					System.out.print("That is not a valid action that I can help with. \n");
				}
			} else if (tmpActionId.equals("EXAMINE")) {
				Item currItem = returnIfItemNearby(room, player, secondPhrase);
					
				//if the item is in the room then you can examine it
				if (currItem != null) {
					currItem.examine();
				} else {
					System.out.print("You do not see that item. \n");
				}
				
			} else if (tmpActionId.equals("GRAB")){
				String itemName = secondPhrase;
				Item currItem = room.returnIfItemInRoom(itemName);
				
				//if the item is in the room then you can grab it
				if (currItem != null) {
					//check if it is a window to determine what grab method to use
					if (currItem.getClass() == Item.class) {
						currItem.grab(player, room, userInput);
					} else {
						currItem.grab();
					}
				} else if (player.checkForItemInHand(itemName)) {
					//check if the user is already holding the item
					System.out.print("You are already holding that. \n");
				
				} else {
					System.out.print("You cannot grab something that is not there. \n");
				}
			} else if (tmpActionId.equals("DROP")) {
				String itemName = secondPhrase;
				//check if the item is in the player's hand
				if (player.checkForItemInHand(itemName)) {
					Item currItem = player.returnIfItemInHand(itemName);
					//drop item
					player.dropItem(room, currItem);
				} else {
					System.out.print("You are not holding that. \n");
				}
				
			} else if (tmpActionId.equals("TALK")) {
				Item currItem = returnIfItemNearby(room, player, secondPhrase);
				
				//if the item is in the room then you can examine it
				if (currItem != null) {
					currItem.talk();
				} else {
					System.out.print("You do not see that item. \n");
				}
			} else {
				System.out.print("Input was not recognized. \n");
			}
		
		} else { //events that don't have second phrases

			if (tmpActionId.equals("LOOK")) {
				//looks for items in the room
				player.lookAround(room);
			} else if (tmpActionId.equals("INV")){
				//checks what is in the player's hands
				player.checkInventory();
			} else if (tmpActionId.equals("QUIT")){
				//close the game
				System.out.print("Goodbye, " + player.getName());
				System.exit(0);
			} else {
				//handle invalid input
				System.out.print("Input was not recognized. \n");
			}
		}
	}
	
	private static Item returnIfItemNearby(Room room, Player player, String currItemName) {
		//look for the item in the room
		Item itemFound = room.returnIfItemInRoom(currItemName);
		//if you don't find the item in the room...
		if (itemFound == null) {
			//Check here to see if the item is in your hands			
			itemFound = player.returnIfItemInHand(currItemName);
		} 
		
		if (itemFound != null) { //return the found item
			return itemFound;
		} else {
			return null;
		}
	}
	
	public int[] getActionFromPhrase(String currActionName) {
		//Check for an action by using its check phrases
		for (int i = 0; i < actions.length; i++) {
			for(String phrase : actions[i].checkPhrases) {
				//check if the phrase is short or equal to the size of the action you are checking against to avoid errors
				if(phrase.length() <= currActionName.length()) {
					//Check from the start of the currActionName to avoid bugs and to allow items like "walkie-talkie" for example
					String beginingOfCurrAction = currActionName.toLowerCase().substring(0, phrase.length());

					if (phrase.toLowerCase().equals(beginingOfCurrAction)) {
						//if you find a matching check phrase, you found the action. Return its index and length.
						int[] returnArray = {i, phrase.length()};
						return returnArray;
					}
				}
			}
		}
		
		return null;
	}
	
}
