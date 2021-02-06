
public class Room {
	protected String name;
	protected String size = randomRoomSize();
	protected String[] items = {};
	
	public String[] showItems() {
		return this.items;
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

