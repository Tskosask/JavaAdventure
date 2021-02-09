
public class Rooms {
	protected Room[] roomsMap;
	public void buildRoomsMap() {

		//initialize rooms
		
		Room bedroom = new Room("bedroom", "bedroom");
		Room office = new Room("office", "bedroom");
		Room livingRoom = new Room("livingRoom", "living room");
		Room kitchen = new Room("kitchen", "kitchen");
		Room bathroom = new Room("bathroom", "bathroom");
		Room frontRoom = new Room("frontRoom", "front room");
		Room outside = new Room("outside", "outside");
		
		//initialize items
		
		//bedroom
		Item screwdriver = new Item("screwdriver", "screwdriver", true, "It is a flathead screwdriver with a black and yellow handle.", null);
		Item bed = new Item("bed", "bed", false, "It is a bed with white and blue bedding. It looks comfortable.", null);
		Item brassKey = new Item("brassKey", "key", true, "It is a standard brass key. It could be useful.", null);
		Item eyedrops = new Item("eyedrops", "eyedrops", true, "High quaility lubricating eyedrops.", null);
		AnimateItem cat = new AnimateItem("Lena", "cat", "It is an adorable cat. So long as you don't touch it.", "The cat is so soft, but it hisses and bites at you.", "Meow.");
		Window bedroomWindow = new Window("bedroomWindow", "window", true);
		
		//office
		Item crowbar = new Item("crowbar", "crowbar", true, "A heavy red tool for removing nails with ease.", null);
		Item pencil = new Item("pencil", "pencil", true, "A basic writing tool of the number 2 variety.", null);
		Item desk = new Item("desk", "desk", false, "A place to get some work done. Setup for remote work.", null);
		Window officeWindow = new Window("officeWindow", "window", true);

		//living room
		Item couch = new Item("couch", "couch", false, "A large grey L-shaped couch from ArtVan. It exudes style.", "Feeling it makes you want to lay down.");
		Item tv = new Item("tv", "tv", false, "A large flatscreen television hanging on the wall.", "Who ever hung this knew what they were doing.");
		Item toy = new Item("toy", "toy", true, "A small mouse toy.", null);
		Window livingRoomWindow = new Window("livingRoomWindow", "window", false);
		
		//kitchen
		Item fridge = new Item("fridge", "fridge", false, "A calendar and some old Chistmas cards hang on the front of it. When are you supposed to throw those out?", "It opens and you see it filled with healthy fruits and vegatables ... And a pizza box. You find nothing of use.");
		Item kitchenSink = new Item("kitchensink", "sink", false, "An elegant farmhouse style sink. It is spotless.", "Now is as good a time as any to wash your hands right?");
		Item oven = new Item("oven", "oven", false, "Perfect for warming up the pizza in the fridge.", null);
		Item coffeePot = new Item("coffeePot", "coffeePot", false, "It is a black coffee pot filled to the brim with hot coffee.", "Nothing like a good cup of coffee. Especially when you are locked in your own house. \nYou pour yourself a cup.");
		Item spatula = new Item("spatula", "spatula", true, "I didn't know it was spelled that way either. It has black handle and is long and flat. Perfect for flipping eggs.", null);
		Window kitchenWindow = new Window("kitchenWindow", "window", true);

		//bathroom
		Item bathroomSink = new Item("bathroomSink", "sink", false, "A simple white bathroom sink. It has a spot of toothpaste on the side.", "Now is as good a time as any to wash your hands right?");
		Item toilet = new Item("toilet", "toilet", false, "This thing could flush a beer can.", "Fllllluuuushhhhhhhhh");
		Item hairspray = new Item("hairspray", "hairspray", true, "The first ingredent for a homemade flamethrower.", null);
		Item magicWand = new Item("magicWand", "magicWand", true, "It is carved of rich mahogony. It emits magical power.", null);
		Item toothbrush = new Item("toothbrush", "toothbrush", true, "9 out of 10 dentists recommend.", null);

		//front room
		Item litterBox = new Item("litterBox", "litterBox", false, "The box has a slight odor. Likely the cat has been using it.", "Woah woah. What are you doing?");
		Item wd40 = new Item("wd40", "wd40", true, "The superior lubricant. The blue and yellow can is full.", null);
		Window frontWindow = new Window("frontWindow", "window", true);	
		
		
		//build doors
		
		Room[] bedroomDoorRooms = {bedroom, livingRoom};
		Door bedroomDoor = new Door("bedroomDoor", "bedroomDoor", "It is a white door with a brass door handle.", bedroomDoorRooms, brassKey);
		Room[] officeDoorRooms = {office, livingRoom};
		Door officeDoor = new Door("officeDoor", "officeDoor", "It is a white door that looks like it slides into the wall. You can see the latch through the door crack.", officeDoorRooms, screwdriver);
		Room[] kitchenDoorRooms = {livingRoom, kitchen};
		Door kitchenDoor = new Door("kitchenDoor", "kitchenDoor", "It is brown swinging door. It reminds you of your favorite restaurant.", kitchenDoorRooms, null);
		Room[] bathroomDoorRooms = {kitchen, bathroom};
		Door bathroomDoor = new Door("bathroomDoor", "bathroomDoor", "It is a small door. The hinges and handle are very rusty. Hope it isn't an emergency.", bathroomDoorRooms, wd40);
		Room[] frontRoomDoorRooms = {livingRoom, frontRoom};
		Door frontRoomDoor = new Door("frontRoomDoor", "frontRoomDoor", "It is a beautifully crafted door, but someone has nailed a board across it.", frontRoomDoorRooms, crowbar);
		Room[] outsideDoorRooms = {frontRoom, outside};
		Door outsideDoor = new Door("outsideDoor", "outsideDoor", "Through a window in the door you can see outside. This is the way out, but there is something magical about it.", outsideDoorRooms, magicWand);
		
		
		//put items in the rooms
		
		Item[] bedroomItems = { bedroomDoor, screwdriver, bed, bedroomWindow, brassKey, cat, eyedrops};
		bedroom.setRoomItems(bedroomItems);
		
		Item[] officeItems = { officeDoor, officeWindow, crowbar, pencil, desk };
		office.setRoomItems(officeItems);
		
		Item[] livingRoomItems = {bedroomDoor, kitchenDoor, officeDoor, frontRoomDoor, livingRoomWindow, couch, tv, toy};
		livingRoom.setRoomItems(livingRoomItems);
				
		Item[] kitchenItems = {kitchenDoor, bathroomDoor, kitchenWindow, fridge, kitchenSink, coffeePot, oven, spatula};
		kitchen.setRoomItems(kitchenItems);
		
		Item[] bathroomItems = { bathroomDoor, bathroomSink, toilet, hairspray, magicWand, toothbrush};
		bathroom.setRoomItems(bathroomItems);
		
		Item[] frontRoomItems = { frontRoomDoor, outsideDoor, litterBox, wd40, frontWindow };
		frontRoom.setRoomItems(frontRoomItems);
		
		Room[] tmpMap = {bedroom, office, livingRoom, kitchen, bathroom, frontRoom, outside};
		roomsMap = tmpMap;
	}
	public Room[] getRoomMap() {
		return roomsMap;
	}

}
