
public class Item {
	String name;
	boolean canPickUp;
	String examineText;
	
	public Item(String name, boolean canPickUp, String examineText) {
		this.name = name;
		this.canPickUp = canPickUp;
		this.examineText = examineText;
	}

	protected void examine() {
		if (this.examineText != null) {
			System.out.print(this.examineText + "\n");
		} else {
			System.out.print("It is a " + this.name + ". \n");
		}
	}
	
	protected void grab() {
		if (this.canPickUp) {
			System.out.print("You grab the " + this.name + ". \n");
		} else {
			System.out.print("You grab the " + this.name + ", but nothing interesting happens. \n");
		}
		
	}
}
