package Pieces;

import Main.Board;

public class Knights{ //W 2658 B 265E
	
	public Knight left;
	public Knight right;
	
	public Knights(Color color) {
		left = new Knight(color);
		right = new Knight(color);
		setInitialPos(color);		
	}
	
	private void setInitialPos(Color color) {
		int x = color == Color.WHITE ? 0 : 7;
		
		left.setInitialPos(1, x);
		right.setInitialPos(6, x);
	}
}