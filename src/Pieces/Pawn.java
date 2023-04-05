package Pieces;
import java.util.ArrayList;
import Main.Board;

import Main.Board;

public class Pawn extends Piece{ // W 2659 B 265F
	Board board;
	
	public Pawn(Color color) {
		super(color);
		name = getClass().getCanonicalName();
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2659");
	}
	
	public void setPossibleMovements(Board board) {
		this.board = board;

		int nextY = currentY;
		int nextX = currentX;

		//WHITE
		if(color == Color.WHITE) {
			nextX++;
			if(board.getPiece(currentY, nextX) == null) {
				board.setPossibleMovements(currentY, nextX, true);
				if(!moved) {
					nextX++;
					if(board.getPiece(currentY, nextX) == null) {
						board.setPossibleMovements(currentY, nextX, true);
					}
				}
			}
		}else {
			nextX--;
			if(board.getPiece(currentY, nextX) == null) {
				board.setPossibleMovements(currentY, nextX, true);
				if(!moved) {
					nextX--;
					if(board.getPiece(currentY, nextX) == null) {
						board.setPossibleMovements(currentY, nextX, true);
					}
				}
			}
		}
	}
}
