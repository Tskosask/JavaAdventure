
public class Action {
	protected String actionName;
	protected String[] checkPhrases;
	protected String helpText;

	public Action(String actionName, String[] checkPhrases, String helpText) {
		this.actionName = actionName;
		this.checkPhrases = checkPhrases;
		this.helpText = helpText;
	}

	public Action getActionFromPhrase(String currActionName, Action[] actionArray) {
		//Check for an action by using its check phrases
		for (Action action : actionArray) {
			for(String phrase : action.checkPhrases) {
//				System.out.print(phrase.toLowerCase() + " vs " + currActionName);
				
				if (phrase.toLowerCase().equals(currActionName.toLowerCase())) {
					//if you find a matching check phrase, you found the action. Return it.
					return action;
				}
			}
		}
		return null;
	}
	
}
