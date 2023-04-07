package Main;
import Pieces.Piece;
import java.util.ArrayList;
import java.util.Scanner;
import Pieces.Color;
import Pieces.Type;

public class Board {
	public static final String YELLOW = "\u001B[33m";
	public static final String TRANSPARENCY = "\u001B[33;8m";
	public static final String WHITE = "\u001B[37m";
	public static final String GREEN = "\u001B[32m";
	public static final String RESET = "\u001B[0m";
	
	public Type type;
	
	public boolean[][] possibleMovements = new boolean[8][8];
	public boolean[][] possibleCaptures = new boolean[8][8];
	
	Scanner scan;
	public Piece[][] squares = new Piece[8][8];
	
	public ArrayList<Piece> blackPieces;
	public ArrayList<Piece> whitePieces;
	
	public Board(ArrayList<Piece> blackPieces, ArrayList<Piece> whitePieces) {
		this.blackPieces = blackPieces;
		this.whitePieces = whitePieces;
		initializeBoard();
	}
	
	public void initializeBoard() {
		blackPieces.forEach(piece -> squares[piece.currentY][piece.currentX] = piece);
		whitePieces.forEach(piece -> squares[piece.currentY][piece.currentX] = piece);
	}
	
	public void printBoard(Piece selectedPiece) {
		if(selectedPiece != null) {
			selectedPiece.setPossibleMovements(this);
		}

		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				String p = "\u2659";
				String color = TRANSPARENCY;
				
				if(squares[y][x] != null) { //SE CASA ESTIVER OCUPADA
					p = squares[y][x].getSymbol();
					color = squares[y][x].getColor() == Color.WHITE ? WHITE : YELLOW;
				}else { //SE CASA ESTIVER VAZIA
					if(possibleMovements[y][x]) {
						p = selectedPiece.getSymbol();
						color = GREEN;
					}
				}				
				System.out.print("[" + color + p + RESET + "]");
			}
			System.out.println();
		}
	}
	
	public Piece getPiece(int currentY, int currentX) {
		return squares[currentY][currentX];
	}

	public boolean getPossibleMovements(int y, int x) {
		return squares[y][x] == null ? true: false;
	}
	
	public boolean getPossibleCaptures(int y, int x) {
		return possibleCaptures[y][x];
	}
	
	public void resetPossibleMovements() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				possibleMovements[y][x] = false;
			}
		}
	}
	
	public void resetPossibleCaptures() {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				possibleCaptures[y][x] = false;
			}
		}
	}
	
	public void setPossibleMovements(int y, int x, boolean possible) {
		possibleMovements[y][x] = possible;
	}
	
	public void setPossibleCaptures(int y, int x) {
		possibleCaptures[y][x] = true;
	}
	
	public int convertInput(String tile, Type type) {
		int n = 0;
		String letters = "ABCDEFGH";
		n = type == Type.Y ? letters.indexOf(tile.charAt(0)) : Integer.parseInt(String.valueOf(tile.charAt(1))) -1;
		
		return n;
	}
	
	public void movePiece(Piece p, int currentY, int currentX, int nextY, int nextX) {
		if(possibleMovements[nextY][nextX]) {
			squares[nextY][nextX] = p;
			p.currentY = nextY;
			p.currentX = nextX;
			p.setMoved(true);
			squares[currentY][currentX] = null;
		}else {
			System.out.println("Can't move " + p.getName() +" there!");
		}
	}
}
