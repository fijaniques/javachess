package Pieces;
import Main.Board;

public class Bishop extends Piece{ //W 2657 B 265D
	public Bishop(Color color) {
		super(color);
		name = this.getClass().getCanonicalName();
		setSymbol(color);
	}
	
	private void setSymbol(Color color) {
		setSymbol("\u2657");
	}
	
	public void setPossibleMovements(Board board) {
		this.board = board;

		int nextY = currentY;
		int nextX = currentX;
		
		for(int i = 0; i < 8; i++) { //UP+RIGHT
			if(nextX > 0 && nextY < 7) {
				nextX--;
				nextY++;
				if(board.getPiece(nextY, nextX) == null) {
					board.setPossibleMovements(nextY, nextX, true);
				}else if(board.getPiece(nextY, nextX) != null && 
						board.getPiece(nextY, nextX).getColor() != getColor()){
					board.setPossibleCaptures(nextY, nextX);
					break;
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
				}else if(board.getPiece(nextY, nextX) != null && 
						board.getPiece(nextY, nextX).getColor() != getColor()){
					board.setPossibleCaptures(nextY, nextX);
					break;
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
				}else if(board.getPiece(nextY, nextX) != null && //SE TIVER PEÇA
						board.getPiece(nextY, nextX).getColor() != getColor()){ //SE A COR FOR DIFERENTE
					board.setPossibleCaptures(nextY, nextX);
					break;
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
				}else if(board.getPiece(nextY, nextX) != null && 
						board.getPiece(nextY, nextX).getColor() != getColor()){
					board.setPossibleCaptures(nextY, nextX);
					break;
				}else {
					break;
				}
			}else {
				break;
			}
		}
	}
}