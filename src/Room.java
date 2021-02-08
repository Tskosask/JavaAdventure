
public class Room {
	protected String roomId;
	protected String name;
	protected String size = randomRoomSize();
	protected Item[] items;
	
	public Room(String roomId, String roomName, Item[] roomItems) {
		this.roomId = roomId;
		this.name = roomName;
		this.items = roomItems;
	}

	public Item[] showItems() {
		return items;
	}
	
	protected void setRoomName(String roomName) {
		this.name = roomName;
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

