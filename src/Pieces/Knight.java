package Pieces;
import Main.Board;

public class Knight extends Piece{ //W 2658 B 265E
	
	public Knight(Color color) {
		super(color);
		name = this.getClass().getName();
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2658");
	}
	
	public void setPossibleMovements(Board board) {
		this.board = board;

		int nextY = currentY;
		int nextX = currentX;
		
		if(currentX > 1 && currentY > 0) { //UP UP LEFT
			nextX -= 2;
			nextY -= 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX > 0 && currentY > 1) { //UP LEFT LEFT
			nextX -= 1;
			nextY -= 2;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX > 1 && currentY < 7) { //UP UP RIGHT
			nextX -= 2;
			nextY += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX > 0 && currentY < 6) { //UP RIGHT RIGHT
			nextX -= 1;
			nextY += 2;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX < 6 && currentY > 0) { //DOWN DOWN LEFT
			nextX += 2;
			nextY -= 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX < 7 && currentY > 1) { //DOWN LEFT LEFT
			nextX += 1;
			nextY -= 2;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX < 6 && currentY < 7) { //DOWN DOWN RIGHT
			nextX += 2;
			nextY += 1;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
		
		nextY = currentY;
		nextX = currentX;
		
		if(currentX < 7 && currentY < 6) { //DOWN RIGHT RIGHT
			nextX += 1;
			nextY += 2;
			if(board.getPiece(nextY, nextX) == null) {
				board.setPossibleMovements(nextY, nextX, true);
			}
		}
	}
}