import java.util.Scanner;
 
public class Start {
	public static void main(String args[]) {
		//Initialize Player and the starting room. 
		Player player = new Player();
		Rooms Rooms = new Rooms();
		Rooms.buildRoomsMap();
		Room[] roomMap = Rooms.getRoomMap();
		//The player wakes up in bedroom1
		Room room = roomMap[0];
		
		Scanner userInput = new Scanner(System.in);

		
		System.out.print("Welcome. \n");
		
		askPlayerForName(player, userInput);
		
		//Start game play loop until the user quits
		while (true) {
			whatToDo(player, room, userInput);
		}
	}

	private static void askPlayerForName(Player player, Scanner userInput) {
		System.out.print("What is your name? \n");
		
		//Get and set the player's name
		String playerName = userInput.nextLine().trim();
		player.setName(playerName);

	}
	
	private static void whatToDo(Player player, Room room, Scanner userInput){
		
		System.out.print("What would you like to do, " + player.getName() + "?\n");
		System.out.print("Options:");

		//output all of the available actions
		Action[] actionArray = new Actions().buildActionArray();
			
		for(Action action : actionArray) {
			System.out.print(" \"" + action.actionName + "\"");
		}
		System.out.print("\n");

		//get user input
		String event = userInput.nextLine().trim().toUpperCase();
		
		//handle user input
		if (event.contains("HELP")) {
			//print out the action's help text
			String currActionName = event.substring(5).toLowerCase();
			Action currAction = actionArray[0].getActionFromPhrase(currActionName, actionArray);
			if (currAction != null) {
				System.out.print(currAction.helpText + " \n");
			} else {
				System.out.print("That is not a valid action that I can help with. \n");
			}
		} else if (event.contains("EXAMINE")) {
			Item currItem = returnIfItemNearby(room, player, event.substring(8).toLowerCase());
				
			//if the item is in the room then you can examine it
			if (currItem != null) {
				currItem.examine();
			} else {
				System.out.print("You do not see that item. \n");
			}
			
		} else if (event.contains("GRAB")){
			String itemName = event.substring(5).toLowerCase();
			Item currItem = returnIfItemInRoom(room, itemName);
			
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
		} else if (event.contains("DROP")) {
			String itemName = event.substring(5).toLowerCase();
			
			if (player.checkForItemInHand(itemName)) {
				Item currItem = returnIfItemInHand(player, itemName);
				player.dropItem(room, currItem);
			} else {
				System.out.print("You are not holding that. \n");
			}
			
			
		} else if (event.contains("TALK")) {
			Item currItem = returnIfItemNearby(room, player, event.substring(5).toLowerCase());
			
			//if the item is in the room then you can examine it
			if (currItem != null) {
				currItem.talk();
			} else {
				System.out.print("You do not see that item. \n");
			}
			
		} else {
			switch (event) {
				case "LOOK AROUND":
					//looks for items in the room
					player.lookAround(room);
					break;
				case "CHECK INVENTORY": 
					//checks what is in the player's hands
					player.checkInventory();
					break;
				case "QUIT":
					//close the game
					closeGame(userInput, player);
				default:
					//handle invalid input
					System.out.print("Input was not recognized. \n");
			}
		}
	}
	
	private static Item returnIfItemNearby(Room room, Player player, String currItemName) {
		//look for the item in the room
		Item itemFound = returnIfItemInRoom(room, currItemName);
		//if you don't find the item in the room...
		if (itemFound == null) {
			//Check here to see if the item is in your hands			
			itemFound = returnIfItemInHand(player, currItemName);
		} 
		
		if (itemFound != null) { //return the found item
			return itemFound;
		} else {
			return null;

		}
	}
	
	private static Item returnIfItemInRoom(Room room, String currItemName) {
		//Check here to see if the item is in the room			
		Item[] roomItems = room.showItems();
		if (roomItems.length > 0) {
			for(Item checkItem : roomItems) {
				if (currItemName.equals(checkItem.name)) {
					return checkItem;
				}
			}	
		} 
		return null;
	}
	
	private static Item returnIfItemInHand(Player player, String currItemName) {
		Item[] invItems = player.showInventory();
		if (invItems.length > 0) {
			for(Item checkItem : invItems) {
				if (checkItem != null && currItemName.equals(checkItem.name)) {
					return checkItem;
				}
			}	
		}
		return null;
	}
	
	private static void closeGame(Scanner userInput, Player player) {
		System.out.print("Goodbye, " + player.getName());
		System.exit(0);
	}
}
