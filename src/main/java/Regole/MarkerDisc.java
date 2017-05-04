package Regole;

public class MarkerDisc {
	
	public FamilyColor color;
	public NameTrack track; //abbiamo eliminato la classe TRACK ma rivediamola quando facciamo la GUI
	public int position;
	
	public MarkerDisc(FamilyColor color, NameTrack track){
		this.color = color;
		this.track = track;
		
	}
	
	
	public void advancePos(int pos){
		
		this.position += pos;

		return;
	}

}
