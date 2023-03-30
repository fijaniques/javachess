package Pieces;

public class Bishops{ //W 2658 B 265E
	
	public Bishop left;
	public Bishop right;
	
	public Bishops(Color color) {
		left = new Bishop(color);
		right = new Bishop(color);
		setInitialPos(color);
	}
	
	private void setInitialPos(Color color) {
		int y = color == Color.WHITE ? 0 : 7;
		
		left.setInitialPos(y, 2);
		right.setInitialPos(y, 5);
	}
}