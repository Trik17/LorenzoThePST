package it.polimi.ingsw.GC_04.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.GC_04.server.model.card.BuildingCard;
import it.polimi.ingsw.GC_04.server.model.card.CharacterCard;
import it.polimi.ingsw.GC_04.server.model.card.DevelopmentCard;
import it.polimi.ingsw.GC_04.server.model.card.LeaderCard;
import it.polimi.ingsw.GC_04.server.model.card.TerritoryCard;
import it.polimi.ingsw.GC_04.server.model.card.VentureCard;
import it.polimi.ingsw.GC_04.server.model.resource.Coins;
import it.polimi.ingsw.GC_04.server.model.resource.FaithPoints;
import it.polimi.ingsw.GC_04.server.model.resource.MilitaryPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Resource;
import it.polimi.ingsw.GC_04.server.model.resource.Servants;
import it.polimi.ingsw.GC_04.server.model.resource.Stones;
import it.polimi.ingsw.GC_04.server.model.resource.VictoryPoints;
import it.polimi.ingsw.GC_04.server.model.resource.Woods;

//TODO: alla fine di ogni azione controllo le leader card dei giocatori e vedo se si attivano. 
//aggiungi un boolean che dice se la carta è già attivata e non la controlli più.
//le carte quelle tutte uguali aggiungono il loro effetto in bonus e io lo aggiungo a tutti gli effetti 
//dell'azione quando faccio applyEffects. L'arrayList è già inizializzato.

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7992514360884500251L;
	private String name;
	private FamilyMember[] family;
	private ExtraDice extraDice;
	private Discount discount;	
	private List<DevelopmentCard> tCards;
	private List<DevelopmentCard> vCards;
	private List<DevelopmentCard> bCards;
	private List<DevelopmentCard> cCards;
	private List<Resource> resources;
	private List<Resource> malus;
	private List<Resource> bonusAction;
	private List<Boolean> deleteVPointsCardsEffect;
	private boolean actionSpacePenality;
	private boolean disconnected=false;	
	private List<Harvest> harvestList;
	private List<Production> productionList;
	private Model model;
	private List<LeaderCard> leaderCards;
	
	
	public boolean isDisconnected(){
		return disconnected;
	}
	
	public void disconnect(){
		this.disconnected=true;
	}
	public void reConnect(){
		this.disconnected=false;
	}
	
	
	
	public Player(String name, int turn, Model model){
		this.model=model;
		// 1<=turn<=4 only for initial coins
		// 0<=id<=4
		this.name = name;
		
		
		resources = new ArrayList<>();
		
		resources.add(new Woods(2));
		resources.add(new Stones(2));
		resources.add(new Servants(3));
		resources.add(new MilitaryPoints(0));
		resources.add(new VictoryPoints(0));
		resources.add(new FaithPoints(0));
		resources.add(new Coins(turn+4));
		
		extraDice = new ExtraDice();
		harvestList = new ArrayList<>();
		productionList = new ArrayList<>();
		discount = new Discount();
		
		deleteVPointsCardsEffect = new ArrayList<>();
		deleteVPointsCardsEffect.add(false);
		deleteVPointsCardsEffect.add(false);
		deleteVPointsCardsEffect.add(false);
		deleteVPointsCardsEffect.add(false);
		
		tCards = new ArrayList<>();
		vCards = new ArrayList<>();
		bCards = new ArrayList<>();
		cCards = new ArrayList<>();
		
		malus = new ArrayList<>();
		bonusAction = new ArrayList<>();
		
		
		
		actionSpacePenality = false; 
	}
	
	public Discount getDiscount(){
		return discount;
	}
	
	public boolean getActionSpacePenality() {
		return actionSpacePenality;
		
	}
	
	public void setActionSpacePenality() {
		actionSpacePenality = true;
		
	}
	
	public FamilyMember getFamilyMember(DiceColor diceColor) {
		if (diceColor.equals(DiceColor.BLACK))
			return family[1];
		else if (diceColor.equals(DiceColor.WHITE))
			return family[2];
		else if (diceColor.equals(DiceColor.ORANGE))
			return family[3];
		else
			return family[0];
		
		
	}
	public ExtraDice getExtraDice(){
		return extraDice;
	}

	
	public List<DevelopmentCard> getCards(DevelopmentCard dC){
		if (dC instanceof TerritoryCard) 
			return tCards;
		else if (dC instanceof BuildingCard) 
			return bCards;
		else if (dC instanceof VentureCard) 
			return vCards;
		else if (dC instanceof CharacterCard) 
			return cCards;
		else 
			return new ArrayList<>();
	}
	
	
	public Resource getResource(Resource resource) {
		if (resource instanceof Woods)
			return resources.get(0);
		if (resource instanceof Stones)
			return resources.get(1);
		if (resource instanceof Servants)
			return resources.get(2);
		if (resource instanceof MilitaryPoints)
			return resources.get(3);
		if (resource instanceof VictoryPoints)
			return resources.get(4);
		if (resource instanceof FaithPoints)
			return resources.get(5);
		else
			return resources.get(6);
	}
	
	public List<Resource> getResources(){
		return resources;
	}
	
	public String getName() {
		return name;
		
	}
	public void setFamily(FamilyMember[] fMembers) {
		this.family = fMembers;
	}
	
	public FamilyMember[] getFamily() {
		return family;
		
	}
	
	public List<Harvest> getHarvest() {
		return harvestList;
	}
	public List<Production> getProduction() {
		return productionList;
	}
	public List<Resource> getMalus() {
		return malus;
	}
	public boolean isDeleteCardsEffectActive(DevelopmentCard dC) {
		if (dC instanceof TerritoryCard) 
			return deleteVPointsCardsEffect.get(0);
		else if (dC instanceof CharacterCard) 
			return deleteVPointsCardsEffect.get(1);
		else if (dC instanceof BuildingCard)
			return deleteVPointsCardsEffect.get(2);
		else
			return deleteVPointsCardsEffect.get(3);
	}
	public void setDeleteCardsEffectActive(DevelopmentCard dC) {
		if (dC instanceof TerritoryCard) 
			deleteVPointsCardsEffect.set(0, true);
		else if (dC instanceof CharacterCard) 
			deleteVPointsCardsEffect.set(1, true);
		else if (dC instanceof BuildingCard)
			deleteVPointsCardsEffect.set(2, true);
		else 
			deleteVPointsCardsEffect.set(3, true);
	}

	public List<LeaderCard> getLeaderCards() {
		return leaderCards;
	}

	public void setLeaderCards(List<LeaderCard> leaderCards) {
		this.leaderCards = leaderCards;
	}
	
	
}
