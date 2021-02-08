import java.util.Scanner;

public class Item {
	String name;
	boolean canPickUp;
	String examineText;
	
	public Item(String name, boolean canPickUp, String examineText) {
		this.name = name;
		this.canPickUp = canPickUp;
		this.examineText = examineText;
	}

	protected void examine() {
		if (this.examineText != null) {
			System.out.print(this.examineText + "\n");
		} else {
			System.out.print("It is a " + this.name + ". \n");
		}
	}
	
	protected void grab(Player player, Room room, Scanner userInput) {
		if (this.canPickUp) {
			System.out.print("Which hand would you like to grab the " + this.name + " with? [Left/Right] \n");
			String handChoice = userInput.nextLine().trim().toLowerCase();

			if (handChoice.contains("left") || handChoice.equals("l")) {
				player.addToInventory(this, 0, room);
				room.removeItem(this);
				System.out.print("You grab the " + this.name + " in your left hand. \n");

			} else if (handChoice.contains("right") || handChoice.equals("r")) {
				player.addToInventory(this, 1, room);
				room.removeItem(this);
				System.out.print("You grab the " + this.name + " in your right hand. \n");

			} else {
				System.out.print("You decide to not grab the " + this.name + ". \n");
			}
			
		} else {
			System.out.print("You grab the " + this.name + ", but nothing interesting happens. \n");
		}
	}

	protected void grab() {
		System.out.print("You grab the " + this.name + ", but nothing interesting happens. \n");
	}
	
	
}
