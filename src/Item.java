import java.util.Scanner;

public class Item {
	protected String itemId;
	protected String name;
	protected boolean canPickUp;
	protected String examineText;
	protected String grabText;
	
	public Item(String itemId, String name, boolean canPickUp, String examineText, String grabText) {
		this.itemId = itemId;
		this.name = name;
		this.canPickUp = canPickUp;
		this.examineText = examineText;
		this.grabText = grabText;
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
			grab();
		}
	}

	protected void grab() {
		if (grabText != null) {
			System.out.print(grabText + " \n");
		} else {
			System.out.print("You grab the " + this.name + ", but nothing interesting happens. \n");
		}
	}

	protected void talk() {
		System.out.print("You look like a crazy person trying to talk to the " + this.name + ". \n" );
	}

	protected void grab(Player player) {
		System.out.print("You grab the " + this.name + ", but nothing interesting happens. \n");
	}
	
	
}
