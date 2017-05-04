
package Regole;

public class Track {
	
	public NameTrack name;
	public int totalPos;
	
	public Track(NameTrack name){
		this.name = name;
		
		switch(name){
		
			case VictoryPoints:
				this.totalPos = 99;
				break;
			case FaithPoints:
				this.totalPos = 15;
				break;
			case MilitaryPoints:
				this.totalPos = 25;
				break;
			case TurnOrder:
				this.totalPos = 4;
				break;
			}
	}
					
}
