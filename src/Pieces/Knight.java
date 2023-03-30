package Pieces;

public class Knight extends Piece{ //W 2658 B 265E
	
	public Knight(Color color) {
		super(color);
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2658");
	}
	
	public boolean getPossibleMovements(int y, int x) {
		boolean possible = false;

		if(x == currentX -1 || x == currentX +1) {
			if(y == currentY +2 || y == currentY -2) {
				possible = true;
			}			
		}else if(x == currentX -2 || x == currentX +2) {
			if(y == currentY +1 || y == currentY -1) {
				possible = true;
			}	
		}

		return possible;
	}
}