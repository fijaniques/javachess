package Pieces;
import java.util.ArrayList;

import Main.Board;

public class Pawns{ //W 2658 B 265E
	Board board;
	
	public ArrayList<Pawn> pawnsList;
	
	public Pawns(Color color) {
		pawnsList = new ArrayList<Pawn>();
		setInitialPos(color);
	}
	
	private void setInitialPos(Color color) {
		int x = color == Color.WHITE ? 1 : 6;
		
		for(int y = 0; y < 8; y++) {
			Pawn p = new Pawn(color);
			p.setInitialPos(y, x);
			pawnsList.add(p);
		}
	}
}