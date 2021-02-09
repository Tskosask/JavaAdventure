
public class Door extends Item{
	protected boolean isLocked = true;
	protected Room[] connectedRooms;
	protected Item unlockItem;
	
	public Door(String doorId, String name, String examineText, Room[] connectedRooms, Item unlockItem) {
		//windows cannot be picked up
		super(doorId, name, false, examineText, null);
		this.connectedRooms = connectedRooms;
		//if there is no unlock item required, door is unlocked
		if (unlockItem != null) {
			this.unlockItem = unlockItem;
		} else {
			this.isLocked = false;
		}
	}
	
	protected void grab(Player player) {
		if (isLocked) {
			System.out.print("You try to turn the handle but the door won't budge. \n");
		} else {
			 //change the current room since the player walked through the door
			if (player.getCurrentRoom() == connectedRooms[0]) {
				player.setCurrentRoom(connectedRooms[1]);
			} else {
				player.setCurrentRoom(connectedRooms[0]);
			}
			
			//getting outside is the win condition
			if (name.equals("outsideDoor")) {
				System.out.print("The door swings open and you find yourself outside at last! Well done! \n");
				//close the game
				System.out.print("Goodbye, " + player.getName());
				System.exit(0);
			} else {
				System.out.print("The door swings open and you find yourself in a different room. \n");
			}
		}
	}
	
	protected void toggleDoorLock(Item tryUnlockItem) {
		//only try to unlock the door if its locked
		if (this.isLocked) {
			System.out.print("You try to unlock the " + this.name + " with the " + tryUnlockItem.name + ". \n");
			//check if you are trying to unlock the door with the correct item
			if (this.unlockItem == tryUnlockItem) {
				//handle custom open text
				if(tryUnlockItem.itemId == "brasskey") {
					System.out.print("You slide the key into the lock and hear a click as you turn it. \n");
				} else if (tryUnlockItem.itemId == "screwdriver"){
					System.out.print("You slip the screwdriver into the door jam and are able to flick the latch up. \n");
				} else if (tryUnlockItem.itemId == "crowbar"){
					System.out.print("You find yourself able to pry the board off of the door. \n");
				} else if (tryUnlockItem.itemId == "wd40"){
					System.out.print("You coat the handle and hinges with the liquid. \n");
				} else if (tryUnlockItem.itemId == "magicWand"){
					System.out.print("You say the only spell you know: ABRA-KADABRA! The magical force surrounding the door fades. \n");
				}

				//unlock the door
				isLocked = false;

				System.out.print("The door can now be opened. \n");
			} else {
				if ( tryUnlockItem.itemId == "magicWand") {
					//the magic wand can unlock any door.
					System.out.print("The magic of the wand compels the door to become unlocked. \n");
					isLocked = false;
					System.out.print("The door can now be opened. \n");
				} else {
					System.out.print("It is not successful. \n");
				}
				
			}
		} else {
			System.out.print("The " + this.name + " is not locked. \n");
		}
	}
	
}
