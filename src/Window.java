
public class Window extends Item{
	public Window(String name) {
		//windows cannot be picked up
		super(name, false, null);
	}

	boolean isOpen = false;
	
	protected void examine() {
		//Get the user's location
		//Determine weather
		if (this.isOpen) {
			System.out.print("The window is open and you can feel the wind on your face. ");
		} else {
			System.out.print("The window is shut. ");
		}
		System.out.print("The sun is shining on a freshly cut lawn. \n");
	}
	
	protected void grab() {
		if (isOpen) {
			System.out.print("The window slides shut with ease. \n");
			this.isOpen = false;
		} else {
			System.out.print("The window opens with a little bit of effort. You feel a breeze flow in. \n");
			this.isOpen = true;
		}
	}
	
}
