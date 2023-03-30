package Pieces;
import java.util.ArrayList;

public class Pawn extends Piece{ // W 2659 B 265F
	
	public Pawn(Color color) {
		super(color);
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2659");
	}
	
	public boolean getPossibleMovements(int y, int x) {
		int xRange = 0;
		int yRange = 1;
		
		boolean possible = false;
		
		if(!getMoved()) {
			yRange = 2;
		}else {
			yRange = 1;
		}
		
		if(color == color.WHITE) {
			if((y - currentY <=  yRange && y - currentY > 0 ) && (x == currentX)) {
				possible = true;
			}		
		}else {
			if((currentY - y <=  yRange && currentY - y > 0) && (x == currentX)) {
				possible = true;
			}		
		}
		
		return possible;
	}
}
