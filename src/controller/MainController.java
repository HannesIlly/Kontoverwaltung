package controller;

import model.Bank;
import model.Person;
import view.MainView;

public class MainController {

	private Bank bank;
	private MainView view;

	public MainController() {
		this.bank = new Bank("SRH Bank", new Person("Stefan", "Nowak"));
		this.view = new MainView("Kontoverwaltung: " + bank.getManager().getInitials() + "@" + bank.getName(), 500, 400);
	}
			
	
	public static void main(String[] args) {
		new MainController();
	}

}
