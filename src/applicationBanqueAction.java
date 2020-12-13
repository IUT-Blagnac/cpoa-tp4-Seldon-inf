

import java.util.Locale;
import java.util.Scanner;

import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;

public class applicationBanqueAction {
	
	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour r�cup�rer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag, String menu) {
		System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");
		
		if(menu.equals("o")) {
			System.out.println("Menu opérations sur comptes");
			System.out.println("1 - Déposer de l'argent sur un compte");
			System.out.println("2 - Retirer de l'argent sur un compte");
			System.out.println("0 - Pour quitter ce menu");
		}
		else if(menu.equals("g")) {
			System.out.println("Menu gestion des comptes");
			System.out.println("1 - Ajouter un compte");
			System.out.println("2 - Supprimer un compte");
			System.out.println("0 - Pour quitter ce menu");
		}
		else{
			System.out.println("Menu Général");
			System.out.println("1 - Liste des comptes de l'agence");
			System.out.println("2 - Voir un compte (par son num�ro)");
			//System.out.println("p - voir les comptes d'un Propri�taire (par son nom)");
			System.out.println("3 - Menu opérations sur comptes");
			System.out.println("4 - Menu gestion des comptes");
			System.out.println("0 - Quitter");
			
		}
		System.out.print("Choix -> ");
	}
	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}

	public static void main(String argv[]) {
		application(argv);
	}
	public static void application(String argv[]) {
		
		String choix;

		boolean continuer ;
		Scanner lect;
		AgenceBancaire monAg ;
		
		String nom, numero;		
		Compte c;
		double montant;
		
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		
		monAg = AccesAgenceBancaire.getAgenceBancaire();
		
		continuer = true;
		while (continuer) {
			applicationBanqueAction.afficherMenu(monAg, "m");
			choix = lect.next();
			choix = choix.toLowerCase();
			switch (choix) {
				case "0" :
					System.out.println("ByeBye");
					applicationBanqueAction.tempo();
					continuer = false;
					break;
				case "1" :
					monAg.afficher();
					applicationBanqueAction.tempo();
					break;	
				case "2" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					c = monAg.getCompte(numero);
					if (c==null) {
						System.out.println("Compte inexistant ...");
					} else {
						c.afficher();
					}
					applicationBanqueAction.tempo();
					break;
				case "3" :
					applicationBanqueAction.afficherMenu(monAg, "o");
					
					
					numero = lect.next();
					if(numero.equals("1")) {
						System.out.print("Num compte -> ");
						numero = lect.next();
						System.out.print("Montant � d�poser -> ");
						montant = lect.nextDouble();
						applicationBanqueAction.deposerSurUnCompte(monAg, numero, montant);
						applicationBanqueAction.tempo();
					}
					else if(numero.equals("2")) {
						System.out.print("Num compte -> ");
						numero = lect.next();
						System.out.print("Montant � retirer -> ");
						montant = lect.nextDouble();
						applicationBanqueAction.retirerSurUnCompte(monAg, numero, montant);
						applicationBanqueAction.tempo();
					}
					else if(numero.equals("0")) {
						application(argv);
					}
					break;	
				case "4" :
					applicationBanqueAction.afficherMenu(monAg, "g");
					
					numero = lect.next();
					if(numero.equals("1")) {
						
					}
					else if(numero.equals("2")) {
						
					}
					else if(numero.equals("0")) {
						application(argv);
					}
					else {
						
					}
					break;	
					
				case "p" :
					System.out.print("Propri�taire -> ");
					nom = lect.next();
					applicationBanqueAction.comptesDUnPropretaire (monAg, nom);
					applicationBanqueAction.tempo();
					break;		
				default :
					System.out.println("Erreur de saisie ...");
					applicationBanqueAction.tempo();
					break;
			}
		}
		
	}
	
	public static void comptesDUnPropretaire (AgenceBancaire ag, String nomProprietaire) {
		Compte []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte � ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
