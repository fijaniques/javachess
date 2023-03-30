package Pieces;

import java.util.ArrayList;

public class Piece {
	
	//POSIÇÃO
	public int currentX;
	public int currentY;
	
	//PLAYER
	public Color color;
	
	//PIECE
	private String name;
	private String symbol; //VAI COMPLICAR: USAR GETTYPE	
	private boolean moved = false;
	
	public Piece(Color color) {
		this.color = color;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public boolean getMoved() {
		return this.moved;
	}
	
	public boolean getPossibleMovements(int x, int y) {
		int xRange = 0;
		int yRange = 1;		
		boolean possible = false;
		return possible;
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
