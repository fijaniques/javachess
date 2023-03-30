package Pieces;
import java.util.ArrayList;

public class Pawns{ //W 2658 B 265E
	
	public ArrayList<Pawn> pawnsList;
	
	public Pawns(Color color) {
		pawnsList = new ArrayList<Pawn>();
		setInitialPos(color);
	}
	
	private void setInitialPos(Color color) {
		int y = color == Color.WHITE ? 1 : 6;
		
		for(int x = 0; x < 8; x++) {
			Pawn p = new Pawn(color);
			p.setInitialPos(y, x);
			pawnsList.add(p);
		}
	}
}