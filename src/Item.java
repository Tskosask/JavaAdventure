
public class Item {
	String name;
	
	public Item(String name) {
		this.name = name;
	}

	protected void examine() {
		System.out.print("It is a " + this.name + ". \n");
	}
}
