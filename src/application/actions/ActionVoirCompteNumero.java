package application.actions;

import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionContext;
import application.MenuClass;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class ActionVoirCompteNumero implements Action {

	String message;
	String code;
	
	public ActionVoirCompteNumero() {
		this.message="Voir un compte (par son numéro)";
		this.code="2";
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
		AgenceBancaire agence = ag.getContext();
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		System.out.print("Num compte -> ");
		String num = lect.next();
		switch(num){
			case("0"):
				break;
			default:
				try {
				agence.getCompte(num).afficher();
				}
				catch(Exception e) {
					System.out.println("Compte inexistant ...");
				}
				break;
		}
		MenuClass.allerAuMenuPrincipal(ag);
	}

}
