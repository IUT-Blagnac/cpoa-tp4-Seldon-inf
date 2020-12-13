package application;

import java.util.List;

import action.Action;
import action.ActionContext;
import action.ActionList;
import banque.AgenceBancaire;

public class ActionListAB implements ActionList {

	protected String title;
	protected List<Action> myMenu;
	protected String dec;
	protected String decTwice;
	protected String numberOptSep;
	
	public ActionListAB(String m, String c, String t) {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String actionMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String actionCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(AgenceBancaire ag) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addAction(Action ac) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
