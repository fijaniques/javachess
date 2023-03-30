package Pieces;

public class Bishop extends Piece{ //W 2657 B 265D
	public Bishop(Color color) {
		super(color);
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2657");
	}
	
	public boolean getPossibleMovements(int y, int x) {
		boolean possible = false;

		if(Math.abs(y - currentY) == Math.abs(x - currentX)) {
			possible = true;
		}

		return possible;
	}
}