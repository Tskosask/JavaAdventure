
public class Room {
	protected String name;
	protected String size = randomRoomSize();
	Item screwdriver = new Item("screwdriver", true, "It is a flathead screwdriver with a black and yellow handle.");
	Item bed = new Item("bed", false, "It is a bed with white and blue bedding. It looks comfortable.");
	Item doorKey = new Item("key", true, "It is a standard brass key. It could be useful.");
	
	AnimateItem cat = new AnimateItem("cat", "It is an adorable cat. So long as you don't touch it.", "The cat is so soft, but it hisses and bites at you.", "Meow.");
	Window aWindow = new Window("window");
	
	
	protected Item[] items = { screwdriver, bed, aWindow, doorKey, cat};
	
	public Item[] showItems() {
		return items;
	}
	
	protected void setRoomName(String roomName) {
		this.name = roomName;
	}
	
	protected Room getRoom() {
		return this;
	}

	private String randomRoomSize() {
		double tempNum = Math.random();
		if (tempNum > 0.5) {
			return "big";
		} else {
			return "small";
		}
	}

	protected void removeItem(Item itemToRemove) {
		Item[] arrayCopy = new Item[items.length - 1];
		for(int i = 0, j = 0; i < items.length; i++) {
			if (itemToRemove != items[i]) {
				arrayCopy[j++] = items[i];
			}
		}
		items = arrayCopy;
	}

	public void addItem(Item itemToAdd) {
		Item[] arrayCopy = new Item[items.length + 1];
		for(int i = 0; i < items.length ; i++) {
			arrayCopy[i] = items[i];
		}
		arrayCopy[items.length] = itemToAdd;
		
		items = arrayCopy;
	}

}

