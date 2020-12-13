package application.actions;

import java.util.Scanner;

import action.Action;
import action.ActionContext;
import application.MenuClass;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionAjouterCompte implements Action {

	String message;
	String code;
	
	public ActionAjouterCompte() {
		this.message="Ajouter un compte";
		this.code="1";
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
		System.out.print("Nom propietaire -> ");
		String proprio = lect.next();
		Compte c = ag.getContext().getCompte(numero);
		if (!(c==null)) {
			System.out.println("Compte déjà existant ...");
		} else {
			c = new Compte(numero, proprio);
			try {
				ag.getContext().addCompte(c);
				System.out.println("Compte ajouter");
			}
			catch(Exception e) {
				System.out.println("Erreur le compte n'a pas pu être ajouter");
			}
		}
		MenuClass.allerAuMenuPrincipal(ag);
	}

}
