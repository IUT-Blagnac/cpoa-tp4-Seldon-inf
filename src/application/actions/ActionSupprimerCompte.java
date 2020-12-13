package application.actions;

import java.util.Scanner;

import action.Action;
import action.ActionContext;
import application.MenuClass;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionSupprimerCompte implements Action {

	String message;
	String code;
	
	public ActionSupprimerCompte() {
		this.message="Supprimer un compte";
		this.code="2";
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
		System.out.print("Num compte -> ");
		Scanner lect;
		lect = new Scanner ( System.in );
		String numero = lect.next();
		Compte c = ag.getContext().getCompte(numero);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			ag.getContext().removeCompte(numero);
			System.out.println("Compte supprimer");
		}
		MenuClass.allerAuMenuPrincipal(ag);
	}

}
