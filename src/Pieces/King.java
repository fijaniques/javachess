package Pieces;
import Main.Board;

public class King extends Piece{ //W 2654 B 265A
	public King(Color color) {
		super(color);
		name = getClass().getCanonicalName();		
		setSymbol(color);
		setInitialPos(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2654");
	}
	
	private void setInitialPos(Color color) {
		int x = color == Color.WHITE ? 0 : 7;
		int y = 3;
		
		setInitialPos(y, x);
	}
	
	public void setPossibleMovements(Board board) {
		this.board = board;

		int nextY = currentY;
		int nextX = currentX;
		
		if(currentX > 0) { //UP
			nextX -= 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextX = currentX;
		
		if(currentX < 7) { //DOWN
			nextX += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextX = currentX;
		
		if(currentY > 0) { //LEFT
			nextY -= 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		
		if(currentY < 7) { //RIGHT
			nextY += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		
		if(currentX > 0 && currentY < 7) { //UP RIGHT
			nextX -= 1;
			nextY += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextX = currentX;
		nextY = currentY;
		
		if(currentX > 0 && currentY > 0) { //UP LEFT
			nextX -= 1;
			nextY -= 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextX = currentX;
		nextY = currentY;
		
		if(currentX < 7 && currentY < 7) { //DOWN RIGHT
			nextY += 1;
			nextX += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextX = currentX;
		nextY = currentY;
		
		if(currentX < 7 && currentY > 0) { //DOWN LEFT
			nextY -= 1;
			nextX += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
	}
}
