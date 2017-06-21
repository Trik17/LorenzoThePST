package it.polimi.ingsw.GC_04;

import java.util.List;

import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public class StateOfTheGameCLI {

	public StateOfTheGameCLI() {
	}
	
	public void print(String string) {
		System.out.println(string);
	}
	
	public void printCards(List<DevelopmentCard> cards) {
		int cont = 1;
		print("");
		print("Territory Cards");
		for(int i = 0; i < 4; i++) {
			try {
				print(cont+")"+cards.get(i).getName());
				cont++;
			} catch (NullPointerException e) {
				print(cont+")TAKEN");
				cont++;
			}
		}
		cont = 1;
		print("");
		print("Character Cards");
		for(int i = 4; i < 8; i++) {
			try {
				print(cont+")"+cards.get(i).getName());
				cont++;
			} catch (NullPointerException e) {
				print(cont+")TAKEN");
				cont++;
			}
		}
		cont = 1;
		print("");
		print("Building Cards");
		for(int i = 8; i < 12; i++) {
			try {
				print(cont+")"+cards.get(i).getName());
				cont++;
			} catch (NullPointerException e) {
				print(cont+")TAKEN");
				cont++;
			}
		}
		cont = 1;
		print("");
		print("Venture Cards");
		for(int i = 12; i < 16; i++) {
			try {
				print(cont+")"+cards.get(i).getName());
				cont++;
			} catch (NullPointerException e) {
				print(cont+")TAKEN");
				cont++;
			}
		}
	}	

}
