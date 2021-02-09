public class Window extends Item{
	
	protected boolean canOpen;
	protected boolean isOpen = false;

	
	public Window(String itemId, String name, boolean canOpen) {
		//windows cannot be picked up
		super(itemId, name, false, null, null);
		this.canOpen = canOpen;
	}

	
	protected void examine() {
		if (this.canOpen) {
			if (this.isOpen) {
				System.out.print("The window is open and you can feel the wind on your face. ");
			} else {
				System.out.print("The window is shut. ");
			}
		}
		
		
		System.out.print("The sun is shining on a freshly cut lawn. \n");
	}
	
	protected void grab() {
		if (this.canOpen) {
			if (isOpen) {
				System.out.print("The window slides shut with ease. \n");
				this.isOpen = false;
			} else {
				System.out.print("The window opens with a little bit of effort. You feel a breeze flow in. \n");
				this.isOpen = true;
			}
		} else {
			System.out.print("You see no way to open this window. It definitely doesn't open. \n");
		}
	}
	
}
