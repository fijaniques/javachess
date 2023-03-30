package Pieces;

public class King extends Piece{ //W 2654 B 265A
	public King(Color color) {
		super(color);
		setSymbol(color);
		setInitialPos(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2654");
	}
	
	private void setInitialPos(Color color) {
		int y = color == Color.WHITE ? 0 : 7;
		int x = 4;
		
		setInitialPos(y, x);
	}
	
	public boolean getPossibleMovements(int y, int x) {
		boolean possible = false;

		if(x == currentX -1 || x == currentX || x == currentX +1) {
			if(y == currentY -1 || y == currentY || y == currentY +1)
			possible = true;
		}

		return possible;
	}
}
