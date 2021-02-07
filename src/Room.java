
public class Room {
	protected String name;
	protected String size = randomRoomSize();
	Item screwdriver = new Item("screwdriver", true, "It is a flathead screwdriver with a black and yellow handle.");
	Item bed = new Item("bed", false, "It is a bed with white and blue bedding. It looks comfortable.");
	
	Window aWindow = new Window("window");
	
	
	protected Item[] items = { screwdriver, bed, aWindow };
	
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

	protected void removeItem(Item item) {
		Item[] arrayCopy = new Item[items.length -1];
		for(int i = 0, j = 0; i < items.length; i++) {
			if (item != items[i]) {
				arrayCopy[j++] = items[i];
			}
		}
		items = arrayCopy;
	}

}

