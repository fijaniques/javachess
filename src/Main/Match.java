package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Pieces.*;

public class Match {
	private boolean exit = false;
	private ArrayList<Piece> blackPieces;
	private ArrayList<Piece> whitePieces;
	
	Piece selectedPiece = null;
	
	public Board board;
	
	public Match() {
		blackPieces = createPieces(Color.BLACK);
		whitePieces = createPieces(Color.WHITE);
		board = new Board(blackPieces, whitePieces);

		while(!exit) {
			boolean unblocked = false;
			int currentX = 0;
			int currentY = 0;
			
			board.printBoard(selectedPiece); //PRINT NULL
			
			while(!unblocked) {
				board.resetPossibleMovements();
				System.out.print("Choose the tile: ");	
				String currentTile = getTile(); //PICK THE SQUARE
				currentY = board.convertInput(currentTile, Type.Y);
				currentX = board.convertInput(currentTile, Type.X);
				
				selectedPiece = board.getPiece(currentY, currentX); //GET THE PIECE IN THAT SQUARE
				
				board.printBoard(selectedPiece); //PRINT WITH SELECTED PIECE
				
			    //printTest();
			    
			    unblocked = checkUnblocked(currentY, currentX);
			    
			    if(!unblocked) {
			    	System.out.printf("This %s can't move%n", selectedPiece.getName());
			    }			    
			}			

			System.out.printf("Tile to move to: ");
			String nextTile = getTile(); //PICK TILE TO MOVE TO
			int nextY = board.convertInput(nextTile, Type.Y);
			int nextX = board.convertInput(nextTile, Type.X);
			board.movePiece(selectedPiece, currentY, currentX, nextY, nextX); //MOVE SELECTED PIECE TO THAT TILE
			board.resetPossibleMovements();
			selectedPiece = null;
			System.out.println("_______________________________________");
		}
	}
	
	public String getTile() {
		Scanner scan = new Scanner(System.in);
		String tile = scan.nextLine();
		return tile;
	}
	
	public ArrayList<Piece> createPieces(Color color) {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		
		pieces.add(new King(color));
		pieces.add(new Queen(color));
		
		Knights knights = new Knights(color);
		pieces.add(knights.left);
		pieces.add(knights.right);
		
		Bishops bishops = new Bishops(color);
		pieces.add(bishops.left);
		pieces.add(bishops.right);
		
		Rooks rooks = new Rooks(color);
		pieces.add(rooks.left);
		pieces.add(rooks.right);
		
		Pawns pawns = new Pawns(color);
		pieces.addAll(pawns.pawnsList);
		
		return pieces;
	}
	
	public boolean checkUnblocked(int currentY, int currentX) {
		boolean unblocked = false;
		for(int x = 0; x < 8; x++) { 
			for(int y = 0; y < 8; y++) {
				if(board.possibleMovements[y][x]) {
					unblocked = true;
				}
			}
		}
		return unblocked;
	}
	
	public void printTest() {
		for(int x = 0; x < 8; x++) { 
			for(int y = 0; y < 8; y++) {
				if(board.possibleMovements[y][x]) {
					System.out.print("[o]");
				}
				else {
					System.out.print("[x]");
				}				
			}
			System.out.println();
		}
	}
}
