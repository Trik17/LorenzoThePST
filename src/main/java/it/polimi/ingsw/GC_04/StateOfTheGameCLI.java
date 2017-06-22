package it.polimi.ingsw.GC_04;

import java.util.List;

import it.polimi.ingsw.GC_04.model.card.DevelopmentCard;

public class StateOfTheGameCLI {

	public StateOfTheGameCLI() {
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
	
	public static String nameCard(DevelopmentCard card, int cont) {
		try {
			String name = cont+")"+card.getName();
			return name;
		}catch (NullPointerException e) {
			String name = cont+")TAKEN";
			return name;
		}
		
	}
	
	public static void printCards(DevelopmentCard[] tCards,DevelopmentCard[] cCards,DevelopmentCard[] bCards,DevelopmentCard[] vCards) {
		int cont = 1;
		print("");
		print("Territory Cards		Character Cards		Building Cards		Venture Cards");
		for(int i = 0; i < 4; i++) {
			print(nameCard(tCards[i],cont)+"		"+nameCard(cCards[i],cont)+"		"+cont+")"+nameCard(bCards[i],cont)+"		"+nameCard(vCards[i],cont));
			cont++;
		}
	}
		/*cont = 1;
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
	}	*/

}
