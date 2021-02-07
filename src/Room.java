
public class Room {
	protected String name;
	protected String size = randomRoomSize();
	Item screwdriver = new Item("screwdriver");
	
	Window aWindow = new Window("window");
	
	protected Item[] items = { screwdriver, aWindow };
	
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

}

