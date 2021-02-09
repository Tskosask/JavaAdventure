
public class AnimateItem extends Item {
	//This class is for items that are living beings

	protected String dialogText = "They don't have much to say.";
	
	public AnimateItem(String itemId, String name, String examineText, String grabText, String dialogText) {
		super(itemId, name, false, examineText, grabText);
		
		if (dialogText != null) {
			this.dialogText = dialogText;
		}
	}
	

	protected void talk() {
		System.out.print(dialogText + " \n");
	}
		
}
