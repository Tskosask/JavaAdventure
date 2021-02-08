
public class Action {
	protected String actionName;
	protected String[] checkPhrases;
	protected String helpText;

	public Action(String actionName, String[] checkPhrases, String helpText) {
		this.actionName = actionName;
		this.checkPhrases = checkPhrases;
		this.helpText = helpText;
	}
}
