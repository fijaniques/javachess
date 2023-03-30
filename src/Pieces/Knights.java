package Pieces;

public class Knights{ //W 2658 B 265E
	
	public Knight left;
	public Knight right;
	
	public Knights(Color color) {
		left = new Knight(color);
		right = new Knight(color);
		setInitialPos(color);		
	}
	
	private void setInitialPos(Color color) {
		int y = color == Color.WHITE ? 0 : 7;
		
		left.setInitialPos(y, 1);
		right.setInitialPos(y, 6);
	}
}