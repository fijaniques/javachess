package Pieces;

public class Rook extends Piece{ //W 2656 B 265C
	public Rook(Color color) {
		super(color);
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2656");
	}

	public boolean getPossibleMovements(int y, int x) {
		boolean possible = false;

		if(y == currentY) {
			possible = true;
		}else if(x == currentX) {
			possible = true;
		}

		return possible;
	}
}
