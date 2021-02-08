
public class AnimateItem extends Item {
	//This class is for items that are living beings

	protected String grabText = "You don't think they would like that very much.";
	protected String dialogText = "They don't have much to say.";
	
	public AnimateItem(String name, String examineText, String grabText, String dialogText) {
		super(name, false, examineText);
		if (grabText != null) {
			this.grabText = grabText;
		}
		
		if (dialogText != null) {
			this.dialogText = dialogText;
		}
	}
	
	protected void grab() {
		System.out.print(grabText + " \n");
	}
	
	protected void talk() {
		System.out.print(dialogText + " \n");
	}
		
}
