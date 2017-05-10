package it.polimi.ingsw.GC_04;

public class Resource {
	
	protected int quantity;
	
	public Resource(int quantity){
		
		this.quantity = quantity;
	}
	
	public void modifyQuantity(int nrOfResources){
		this.quantity += nrOfResources;
	}
	
	public int getQuantity(){
		return quantity;
	}
}
