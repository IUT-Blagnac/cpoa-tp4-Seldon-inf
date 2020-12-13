package application;
import java.util.Locale;
import java.util.Scanner;

import action.ActionContext;
import application.actionlist.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class MenuClass {
	public static void allerAuMenuPrincipal(ActionContext<AgenceBancaire> ag) {
		//ActionContextAgenceBancaire actionContext=new ActionContextAgenceBancaire(AccesAgenceBancaire.getAgenceBancaire());
		System.out.println("Tapper un car + return pour continuer ... ");
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		String choix = lect.next();
		ActionListAgenceBancaire actionAB=new ActionListAgenceBancaire();
		try {
			actionAB.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
