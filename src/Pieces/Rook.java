package Pieces;
import Main.Board;

public class Rook extends Piece{ //W 2656 B 265C
	public Rook(Color color) {
		super(color);
		name = getClass().getCanonicalName();
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2656");
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
	}
}
