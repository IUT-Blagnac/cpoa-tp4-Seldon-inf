package application;

import action.ActionContext;
import banque.AgenceBancaire;

public class ActionContextAgenceBancaire implements ActionContext<AgenceBancaire>{

	AgenceBancaire theAg;
	
	public ActionContextAgenceBancaire(AgenceBancaire ag) {
		super();
		this.theAg=ag;
	}

	@Override
	public AgenceBancaire getContext() {
		return this.theAg;
	}

}
