
public class Door extends Item{
	protected boolean isLocked = false;
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
				System.out.print("The door swings open and you find yourself outside at last! \n");
				//close the game
				System.out.print("Goodbye, " + player.getName());
				System.exit(0);
			} else {
				System.out.print("The door swings open and you find yourself in a new room. \n");
			}
		}
	}
	
	protected void toggleDoorLock() {
		isLocked = false;
		System.out.print("The door can now be opened.");
	}
	
}
