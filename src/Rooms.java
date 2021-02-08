
public class Rooms {
	protected Room[] roomsMap;
	public void buildRoomsMap() {
		Item screwdriver = new Item("screwdriver", true, "It is a flathead screwdriver with a black and yellow handle.");
		Item bed = new Item("bed", false, "It is a bed with white and blue bedding. It looks comfortable.");
		Item doorKey = new Item("key", true, "It is a standard brass key. It could be useful.");
		AnimateItem cat = new AnimateItem("cat", "It is an adorable cat. So long as you don't touch it.", "The cat is so soft, but it hisses and bites at you.", "Meow.");
		Window aWindow = new Window("window");
		Item[] bedroom1Items = { screwdriver, bed, aWindow, doorKey, cat};
		
		Room bedroom1 = new Room("bedroom1", "bedroom", bedroom1Items);
		Room bedroom2 = new Room("bedroom2", "bedroom", null);
		Room diningRoom = new Room("diningRoom", "dining room", null);
		Room livingRoom = new Room("livingRoom", "living room", null);
		Room kitchen = new Room("kitchen", "kitchen", null);
		Room bathroom = new Room("bathroom", "bathroom", null);
		Room frontRoom = new Room("frontRoom", "front room", null);
		Room[] tmpMap = {bedroom1, bedroom2, diningRoom, livingRoom, kitchen, bathroom, frontRoom};
		roomsMap = tmpMap;
	}
	public Room[] getRoomMap() {
		return roomsMap;
	}

}
