package application.actions;

import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionContext;
import application.MenuClass;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class ActionDeposerArgentSurCompte implements Action {

	String message;
	String code;
	
	public ActionDeposerArgentSurCompte() {
		this.message="Déposer de l'argent sur un compte";
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
		AgenceBancaire agence = ag.getContext();
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		System.out.print("Num compte -> ");
		String numCompte = lect.next();
		System.out.print("Montant à déposer -> ");
		String montant = lect.next();
		switch(numCompte){
			case("0"):
				ActionListAgenceBancaire actionAB=new ActionListAgenceBancaire();
				try {
					actionAB.execute(ag);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				agence.getCompte(numCompte).deposer(Double.parseDouble(montant));;
				break;
		}
		MenuClass.allerAuMenuPrincipal(ag);
	}

}
