
public class Player {
	protected Item[] inventory = { null, null };

	protected String name = "Player";
	protected Room currentRoom;

	protected void setCurrentRoom(Room newRoom) {
		this.currentRoom = newRoom;
	}

	protected Room getCurrentRoom() {
		return this.currentRoom;
	}

	protected void lookAround(Room room) {
		Item[] roomItems = room.showItems();
		System.out.print("You are standing in a " + room.size + " " + room.name + ". \n");

		if (roomItems != null && roomItems.length > 0) {
			System.out.print("You see: ");
			// print out all items in the room
			for (int i = 0; i < roomItems.length; i++) {
				System.out.print(roomItems[i].name);
				// don't print comma for last item
				if (i != roomItems.length - 1) {
					System.out.print(", ");
				}
			}

		} else {
			System.out.print("You don't see anything of importance.");
		}

		System.out.print("\n");
	}

	protected void checkInventory() {
		String leftItem = "nothing";
		String rightItem = "nothing";

		if (inventory[0] != null) {
			leftItem = inventory[0].name;
		}

		if (inventory[1] != null) {
			rightItem = inventory[1].name;
		}

		System.out.print("Left Hand: " + leftItem + "\n");
		System.out.print("Right Hand: " + rightItem + "\n");

	}

	protected Item[] showInventory() {
		return inventory;
	}

	protected void addToInventory(Item itemToAdd, int handIndex, Room room) {
		// check if the inventory spot is empty
		if (inventory[handIndex] != null) {
			// if it is not, drop the item first
			dropItem(room, inventory[handIndex]);
		}

		// add item to inventory
		this.inventory[handIndex] = itemToAdd;
	}

	private void removeItemFromInv(int invIndex) {
		inventory[invIndex] = null;
	}

	protected void setName(String name) {
		this.name = name;
		System.out.print("Nice to meet you, " + this.name + "\n");
	}

	protected String getName() {
		return this.name;
	}

	protected boolean checkForItemInHand(String itemName) {
		if (inventory[0] != null && itemName.toLowerCase().equals(inventory[0].name.toLowerCase())) {
			return true;
		}
		if (inventory[1] != null && itemName.toLowerCase().equals(inventory[1].name.toLowerCase())) {
			return true;
		}
		return false;
	}

	protected Item returnIfItemInHand(String currItemName) {

		for(Item checkItem : inventory) {
			if (checkItem != null && currItemName.equals(checkItem.name)) {
				return checkItem;
			}
		}	
		return null;
	}
	
	private int checkWhichHandItemIsIn(Item item) {
		if (inventory[0] != null && item == inventory[0]) {
			return 0;
		}
		if (inventory[1] != null && item == inventory[1]) {
			return 1;
		}
		return -1;
	}

	protected void dropItem(Room room, Item itemToDrop) {
		// check which hand it is in
		int handIndex = checkWhichHandItemIsIn(itemToDrop);

		// remove the item from the hand
		if (handIndex != -1) {
			removeItemFromInv(handIndex);
		} else {
			// handle error if item was not found in the inventory
			System.out.print("An error has occurred when trying to drop the item. \n");
			return;
		}

		// add the item to the room
		room.addItem(itemToDrop);

		String handString = "right";
		if (handIndex == 0) {
			handString = "left";
		}

		System.out.print("You drop the " + itemToDrop.name + " that was in your " + handString + " hand. \n");

	}

}
