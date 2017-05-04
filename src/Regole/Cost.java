package Regole;

public class Cost {
	
	/*
	 * ALTERNATIVA: faccio una lista di risorse/punti richiesti, potrebbe essere più comodo se volessi usare
	 * questa classe anche per gli effetti delle carte. In questo caso però dovrei cambiare anche la PersonalBoard credo.
	 * 
	 */
	
	public int woods;
	public int stones;
	public int servants;
	public int coins;
	public int faithPenality;
	public int victoryPenality;
	public int militaryPenality;

	public Cost(int woods, int stones, int servants, int coins, int faithPenality, int victoryPenality, int militaryPenality){
		
		this.woods = woods;
		this.stones = stones;
		this.servants = servants;
		this.coins = coins;
		this.faithPenality = faithPenality;
		this.victoryPenality = victoryPenality;
		this.militaryPenality = militaryPenality;
	}
	
	
	
	
	
	
}
