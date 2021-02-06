
public class Player {
	protected String[] inventory  = {"Nothing", "Nothing"};
	
	protected String name;
	
	public void lookAround(Room room){
		Item[] roomItems = room.showItems();
		System.out.print("You are standing in a " + room.size + " " + room.name + ". \n");
		
		if (roomItems.length > 0) {
			System.out.print("You see: ");

			for(int i = 0; i < roomItems.length; i++) {
				System.out.print(roomItems[i].name);
			}			
		} else {
			System.out.print("You don't see anything of importance.");
		}
	
		System.out.print("\n");
	}
	
	public void checkInventory() {
		System.out.print("Left Hand: " + inventory[0] + "\n");
		System.out.print("Right Hand: " + inventory[1] + "\n");

	}
	
	public void setName(String name) {
		this.name = name;
		System.out.print("Hello, " + this.name + ". \n");
	}
	
	public String getName( ) {
		return this.name;
	}
	
	
}
