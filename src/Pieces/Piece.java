package Pieces;
import java.util.ArrayList;
import Main.Board;

public class Piece {
	
	//POSIÇÃO
	public int currentX;
	public int currentY;
	private boolean blocked;
	
	//PLAYER
	public Color color;
	
	//PIECE
	public String name; //VAI COMPLICAR: USAR GETTYPE
	private String symbol;
	public boolean moved = false;
	
	//BOARD
	public Board board;
	
	public Piece(Color color) {
		this.color = color;
		this.name = name;
		
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean getMoved() {
		return this.moved;
	}
	
	public int getCurrentY() {
		return currentY;
	}
	
	public int getCurrentX() {
		return currentX;
	}
	
	public boolean getBlocked(int currentY, int currentX, int nextY, int nextX) {
		return blocked;
	}
	
	public void setPossibleMovements(Board board) {
	}
	
	public void setInitialPos(int y, int x) {
		this.currentY = y;
		this.currentX = x;
	}
	
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}	
}
