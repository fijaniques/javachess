package Pieces;

public class Rooks{ //W 2658 B 265E
	
	public Rook left;
	public Rook right;
	
	public Rooks(Color color) {
		left = new Rook(color);
		right = new Rook(color);
		setInitialPos(color);
	}
	
	private void setInitialPos(Color color) {
		int y = color == Color.WHITE ? 0 : 7;
		
		left.setInitialPos(y, 0);
		right.setInitialPos(y, 7);
	}
}