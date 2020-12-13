package application;

import action.Action;
import action.ActionContext;
import banque.AgenceBancaire;

public abstract class GenericActionAgenceBancaire implements Action{
	String lineMessage;
	String code;
	public GenericActionAgenceBancaire(String m, String c) {
		this.lineMessage=m;
		this.code=c;
	}
	public String actionMessage() {
		return this.lineMessage;
	}
	public String actionCode() {
		return this.code;
	}
}
