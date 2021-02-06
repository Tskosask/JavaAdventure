import java.util.Scanner;
 
public class Start {
	public static void main(String args[]) {
		//Initialize Player and the starting room. 
		Player player = new Player();
		Room room = new Room();
		
		//The player wakes up in a bedroom
		room.setRoomName("bedroom");
		
		System.out.print("Welcome. \n");
		System.out.print("What is your name? \n");
		
		//Get and set the player's name
		Scanner userInput = new Scanner(System.in);
		String playerName = userInput.nextLine();
		player.setName(playerName);
		
		//Start game play loop until the user quits
		while (true) {
			whatToDo(player, room, userInput);
		}
	}
	
	private static void whatToDo(Player player, Room room, Scanner userInput){
		String[] actionArray = {"Look Around", "Check Inventory", "Examine [Item]", "Quit"};
		
		System.out.print("What would you like to do, " + player.getName() + "?\n");
		System.out.print("Options: \"Look Around\", \"Check Inventory\", \"Examine [Item]\", \"Quit\" \n");

		String event = userInput.nextLine().trim().toUpperCase();
		
		if (event.contains("EXAMINE")) {
			String currItemName = event.substring(8).toLowerCase();
			Item currItem = new Item(currItemName);
			currItem.examine();
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
	
	private static void closeGame(Scanner userInput, Player player) {
		System.out.print("Goodbye, " + player.getName());
		userInput.close();
		System.exit(0);
	}
}
