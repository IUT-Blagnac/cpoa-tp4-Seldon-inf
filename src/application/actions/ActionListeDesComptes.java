package application.actions;

import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionContext;
import application.GenericActionAgenceBancaire;
import application.MenuClass;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class ActionListeDesComptes implements Action{

	String message;
	String code;
	
	public ActionListeDesComptes() {
		this.message="Liste des comptes de l'agence";
		this.code="1";
	}

	@Override
	public String actionMessage() {
		return message;
	}

	@Override
	public String actionCode() {
		return code;
	}

	@Override
	public void execute(ActionContext<AgenceBancaire> ag) throws Exception {
		ag.getContext().afficher();
		MenuClass.allerAuMenuPrincipal(ag);
	}
	
	
}
