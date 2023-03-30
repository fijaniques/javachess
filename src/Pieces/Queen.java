package Pieces;

public class Queen extends Piece{ //W 2655 B 265B
	public Queen(Color color) {
		super(color);
		setSymbol(color);
		setInitialPos(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2655");
	}
	
	private void setInitialPos(Color color) {
		int y = color == Color.WHITE ? 0 : 7;
		int x = 3;
		
		setInitialPos(y, x);
	}
	
	public boolean getPossibleMovements(int y, int x) {
		boolean possible = false;

		if(Math.abs(y - currentY) == Math.abs(x - currentX)) {
			possible = true;
		}else if(y == currentY) {
			possible = true;
		}else if(x == currentX) {
			possible = true;
		}

		return possible;
	}
}
