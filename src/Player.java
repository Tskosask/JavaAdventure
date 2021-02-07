
public class Player {
	protected Item[] inventory  = {null, null};
	
	protected String name = "Player";
	
	public void lookAround(Room room){
		Item[] roomItems = room.showItems();
		System.out.print("You are standing in a " + room.size + " " + room.name + ". \n");
		
		if (roomItems.length > 0) {
			System.out.print("You see: ");
			//print out all items in the room
			for(int i = 0; i < roomItems.length; i++) {
				System.out.print(roomItems[i].name);
				//don't print comma for last item
				if (i != roomItems.length - 1) {
					System.out.print(", ");
				}
			}			
			
		} else {
			System.out.print("You don't see anything of importance.");
		}
	
		System.out.print("\n");
	}
	
	public void checkInventory() {
		String leftItem = "Nothing";
		String rightItem = "Nothing";

		if (inventory[0] != null) {
			leftItem = inventory[0].name;
		}
		
		if (inventory[1] != null) {
			rightItem = inventory[1].name;
		}
		
		System.out.print("Left Hand: " + leftItem + "\n");
		System.out.print("Right Hand: " + rightItem + "\n");

	}
	
	public Item[] showInventory() {
		return inventory;
	}
	
	public void addToInventory(Item itemToAdd, int handIndex) {
		this.inventory[handIndex] = itemToAdd;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.print("Nice to meet you, " + this.name + "\n");
	}
	
	public String getName( ) {
		return this.name;
	}

	public boolean checkForItemInHand(String itemName) {
		if (itemName.toLowerCase().equals(inventory[0].name.toLowerCase()) || itemName.toLowerCase().equals(inventory[1].name.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	
}
