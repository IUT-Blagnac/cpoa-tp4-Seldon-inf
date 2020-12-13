import application.AccesAgenceBancaire;
import application.ActionContextAgenceBancaire;
import application.actionlist.ActionListAgenceBancaire;

public class Main {

	public static void main(String[] args) {
		ActionListAgenceBancaire actionAB=new ActionListAgenceBancaire();
		ActionContextAgenceBancaire actionContext=new ActionContextAgenceBancaire(AccesAgenceBancaire.getAgenceBancaire());
		try {
			actionAB.execute(actionContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		actionContext.getContext().afficher();
	}

}
