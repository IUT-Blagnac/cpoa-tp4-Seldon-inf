package application.actions;

import action.Action;
import action.ActionContext;
import application.MenuClass;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class ActionQuitterCeMenu implements Action {

	String message;
	String code;
	
	public ActionQuitterCeMenu() {
		this.message="Pour quitter ce menu";
		this.code="0";
	}
	
	@Override
	public String actionMessage() {
		return this.message;
	}

	@Override
	public String actionCode() {
		return this.code;
	}

	@Override
	public void execute(ActionContext<AgenceBancaire> ag) throws Exception {
		ActionListAgenceBancaire actionAB=new ActionListAgenceBancaire();
		try {
			actionAB.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
