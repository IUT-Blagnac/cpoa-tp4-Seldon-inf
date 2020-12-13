package application.actionlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import action.Action;
import action.ActionContext;
import action.ActionList;
import application.AccesAgenceBancaire;
import application.actions.ActionAjouterCompte;
import application.actions.ActionDeposerArgentSurCompte;
import application.actions.ActionListeDesComptes;
import application.actions.ActionQuitterCeMenu;
import application.actions.ActionRetirerArgentSurCompte;
import application.actions.ActionSupprimerCompte;
import application.actions.ActionVoirCompteNumero;
import banque.AgenceBancaire;

public class ActionListGestionComptes implements ActionList {

	protected String title;
	protected List<Action> myMenu;
	protected String message;
	protected String code;
	
	public ActionListGestionComptes() {
		this.message="Menu gestion des comptes";
		this.code="4";
		this.title="Menu de " + AccesAgenceBancaire.getAgenceBancaire().getNomAgence() + " (" + AccesAgenceBancaire.getAgenceBancaire().getLocAgence() + ")";
		this.myMenu=new ArrayList<Action>();
		this.myMenu.add(new ActionAjouterCompte());
		this.myMenu.add(new ActionSupprimerCompte());
		this.myMenu.add(new ActionQuitterCeMenu());
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
		System.out.println(title);
		System.out.println(message);
		for(Action a : this.myMenu) {
			System.out.println(a.actionCode()+" - "+a.actionMessage());
		}
		System.out.print("Choix -> ");
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		String choix = lect.next();
		boolean valide=false;
		for(Action a : this.myMenu) {
			if(a.actionCode().equals(choix)) {
				valide=true;
				a.execute(ag);
			}
		}
		if(!valide) {
			System.out.println("Code non valide");
		}
	}

	@Override
	public String listTitle() {
		return title;
	}

	@Override
	public int size() {
		return this.myMenu.size();
	}

	@Override
	public boolean addAction(Action ac) {
		try {
			myMenu.add(ac);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
