package Pieces;
import Main.Board;

public class Queen extends Piece{ //W 2655 B 265B
	public Queen(Color color) {
		super(color);
		name = getClass().getCanonicalName();
		setSymbol(color);
		setInitialPos(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2655");
	}
	
	private void setInitialPos(Color color) {
		int x = color == Color.WHITE ? 0 : 7;
		int y = 4;
		
		setInitialPos(y, x);
	}
	
	public void setPossibleMovements(Board board) {
		this.board = board;

		int nextY = currentY;
		int nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //UP
			if(nextX > 0) {
				nextX--;
				if(board.getPiece(currentY, nextX) == null) {
					board.setPossibleMovements(currentY, nextX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
		
		nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //DOWN
			if(nextX < 7) {
				nextX++;
				if(board.getPiece(currentY, nextX) == null) {
					board.setPossibleMovements(currentY, nextX, true);
				}
				else {
					break;
				}
			}else {
				break;
			}
		}
		
		nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //LEFT
			if(nextY > 0) {
				nextY--;
				if(board.getPiece(nextY, currentX) == null) {
					board.setPossibleMovements(nextY, currentX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
		
		nextY = currentY;
		
		for(int i = 0; i < 8; i++) { //RIGHT
			if(nextY < 7) {
				nextY++;
				if(board.getPiece(nextY, currentX) == null) {
					board.setPossibleMovements(nextY, currentX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
		
		//BISHOP MOVEMENT
		nextY = currentY;
		nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //UP+RIGHT
			if(nextX > 0 && nextY < 7) {
				nextX--;
				nextY++;
				if(board.getPiece(nextY, nextX) == null) {
					board.setPossibleMovements(nextY, nextX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //UP+LEFT
			if(nextX > 0 && nextY > 0) {
				nextX--;
				nextY--;
				if(board.getPiece(nextY, nextX) == null) {
					board.setPossibleMovements(nextY, nextX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //DOWN+RIGHT
			if(nextX < 7 && nextY < 7) {
				nextX++;
				nextY++;
				if(board.getPiece(nextY, nextX) == null) {
					board.setPossibleMovements(nextY, nextX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //DOWN+LEFT
			if(nextX < 7 && nextY > 0) {
				nextX++;
				nextY--;
				if(board.getPiece(nextY, nextX) == null) {
					board.setPossibleMovements(nextY, nextX, true);
				}else {
					break;
				}
			}else {
				break;
			}
		}
	}
}
