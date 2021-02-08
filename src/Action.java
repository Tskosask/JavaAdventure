
public class Action {
	protected String actionId;
	protected String actionName;
	//check phrases must be listed in order from longest to shortest
	protected String[] checkPhrases;
	protected String helpText;

	public Action(String actionId, String actionName, String[] checkPhrases, String helpText) {
		this.actionId = actionId;
		this.actionName = actionName;
		this.checkPhrases = checkPhrases;
		this.helpText = helpText;
	}
}
