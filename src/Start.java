import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 
public class Start {
	public static void main(String args[]) throws InterruptedException {
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
			TimeUnit.SECONDS.sleep(2);
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
		Actions actions = new Actions();
		Action[] actionArray = actions.buildActionArray();
			
		for(Action action : actionArray) {
			System.out.print(" \"" + action.actionName + "\"");
		}
		System.out.print("\n");

		//get user input
		String event = userInput.nextLine().trim().toUpperCase();
		
		//handle user input
		
		//This process takes the user input, runs it through all action's valid phrases and gets a usable Action ID
		//which is used to then handle the action
		int[] actionIndexAndLength = actions.getActionFromPhrase(event);
		
		String tmpActionId = null;
		String secondPhrase = null;

		try { //try to get and set the action and parse the phrase the user entered
			Action eventAction = actionArray[actionIndexAndLength[0]];
			//get the secondary or the word that comes after the action, but only if there is more to the input
			if (event.length() > actionIndexAndLength[1]) {
				// you get the substring start based on how long the action check phrase was, returned by getActionFromPhase
				secondPhrase = event.substring(actionIndexAndLength != null ? actionIndexAndLength[1] + 1 : 0).toLowerCase();	
			}
			tmpActionId = eventAction.actionId.toUpperCase();
			actions.handleAction(tmpActionId, secondPhrase, player, room, userInput);
			
		} catch (Exception e){ //if you can't parse it properly
			System.out.print("Input was not recognized. \n");
		}
	}
}
