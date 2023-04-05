package Pieces;

import Main.Board;

public class Rooks{ //W 2658 B 265E
	
	public Rook left;
	public Rook right;
	
	public Rooks(Color color) {
		left = new Rook(color);
		right = new Rook(color);
		setInitialPos(color);
	}
	
	private void setInitialPos(Color color) {
		int x = color == Color.WHITE ? 0 : 7;
		
		left.setInitialPos(0, x);
		right.setInitialPos(7, x);
	}
}