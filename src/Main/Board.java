package Main;
import Pieces.Piece;
import java.util.ArrayList;
import java.util.Scanner;
import Pieces.Color;

public class Board {
	public static final String YELLOW = "\u001B[33m";
	public static final String TRANS = "\u001B[33;8m";
	public static final String WHITE = "\u001B[37m";
	public static final String GREEN = "\u001B[32m";
	public static final String RESET = "\u001B[0m";
	
	private boolean[][] possibleMovements = new boolean[8][8];
	
	Scanner scan;
	public Piece[][] tiles;
	
	public ArrayList<Piece> blackPieces;
	public ArrayList<Piece> whitePieces;
	
	public Board(ArrayList<Piece> blackPieces, ArrayList<Piece> whitePieces) {
		tiles = new Piece[8][8];
		this.blackPieces = blackPieces;
		this.whitePieces = whitePieces;
		initializeBoard();
	}
	
	public void initializeBoard() {
		blackPieces.forEach(piece -> tiles[piece.currentY][piece.currentX] = piece);
		whitePieces.forEach(piece -> tiles[piece.currentY][piece.currentX] = piece);
	}
	
	public void printBoard(Piece selectedPiece) {		
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				possibleMovements[y][x] = false;
				String p = "\u2659";
				String c = TRANS;
				
				if(tiles[y][x] != null) {
					p = tiles[y][x].getSymbol();
					c = tiles[y][x].getColor() == Color.WHITE ? WHITE : YELLOW;
				}else {
					if(selectedPiece != null) {
						boolean possible = selectedPiece.getPossibleMovements(y, x);
						if(possible) {
							this.possibleMovements[y][x] = true;
							p = selectedPiece.getSymbol();
							c = GREEN;
						}
					}
				}
				
				System.out.print("[" + c + p + RESET + "]");
			}
			System.out.println();
		}
	}
	
	public String getTile() {
		scan = new Scanner(System.in);
		String tile = scan.nextLine();
		return tile;
	}
	
	public Piece getPiece(int currentY, int currentX) {
		return tiles[currentY][currentX];
	}
	
	public int convertInput(String tile, char type) {
		int n = 0;
		if(type == 'x') {
			String letters = "ABCDEFGH";
			n = letters.indexOf(tile.charAt(0));
		}else {
			n = Integer.parseInt(String.valueOf(tile.charAt(1))) -1;
		}
		
		return n;
	}
	
	public void movePiece(int currentY, int currentX, int nextY, int nextX) {
		Piece p = tiles[currentY][currentX];
		
		if(this.possibleMovements[nextY][nextX]) {
			tiles[nextY][nextX] = p;
			p.currentY = nextY;
			p.currentX = nextX;
			p.setMoved(true);
			tiles[currentY][currentX] = null;
		}else {
			System.out.println("Can't move there!");
		}
		
		
	}
}
