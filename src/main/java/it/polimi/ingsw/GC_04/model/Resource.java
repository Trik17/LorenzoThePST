package it.polimi.ingsw.GC_04.model;

public class Resource {
	
	private int quantity;
	
	public Resource(int quantity){
		
		this.quantity = quantity;
	}
	
	public void modifyQuantity(int nOfResources){
		this.quantity += nOfResources;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	
}
