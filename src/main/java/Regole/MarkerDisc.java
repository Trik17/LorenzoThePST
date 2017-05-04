package Regole;

public class MarkerDisc {
	
	public FamilyColor color;
	public Track track;
	public int position;
	
	public MarkerDisc(FamilyColor color, Track track){
		this.color = color;
		this.track = track;
		
	}
	
	
	public void advancePos(int pos){
		int finalPos = position + pos;
		
		if(finalPos > this.track.totalPos){
			
			System.out.println("C'è stato un errore");
			return;
		}
		
		this.position = finalPos;
		return;
	}

}
