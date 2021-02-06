import java.util.Scanner;
 
public class Start {
	public static void main(String args[]) {
		Player player = new Player();
		Room room = new Room();
		room.setRoomName("Bedroom");
		
		System.out.print("Welcome. \n");
		System.out.print("What is your name? \n");
		
		Scanner userInput = new Scanner(System.in);
		String playerName = userInput.nextLine();
		
		player.setName(playerName);
		
		while (true) {
			whatToDo(player, room, userInput);
		}
	}
	
	private static void whatToDo(Player player, Room room, Scanner userInput){
		System.out.print("What would you like to do, " + player.getName() + "?\n");
		System.out.print("Options: \"Look Around\", \"Check Inventory\", \"Quit\" \n");

		String event = userInput.nextLine();
		
		switch (event.trim().toUpperCase()) {
		case "LOOK AROUND":
			player.lookAround(room);
			break;
		case "CHECK INVENTORY": 
			player.checkInventory();
			break;
		case "QUIT":
			closeGame(userInput, player);
			
		default:
			System.out.print("Input was not recognized. \n");
		}
	}
	
	private static void closeGame(Scanner userInput, Player player) {
		System.out.print("Goodbye, " + player.getName());
		userInput.close();
		System.exit(0);
	}
}
