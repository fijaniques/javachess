package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Pieces.*;

public class Match {
	private boolean exit = false;
	private ArrayList<Piece> blackPieces;
	private ArrayList<Piece> whitePieces;
	
	String letters = "ABCDEFGH";
	
	Piece selectedPiece = null;
	
	public Board board;
	
	private Color turn = Color.WHITE;
	
	public Match() {
		blackPieces = createPieces(Color.BLACK);
		whitePieces = createPieces(Color.WHITE);
		board = new Board(blackPieces, whitePieces);
		

		while(!exit) {			
			boolean unblocked = false;
			boolean rightColor = false;
			int currentX = 0;
			int currentY = 0;
			
			board.printBoard(selectedPiece); //PRINT NULL
			
			while(!unblocked) {
				while(!rightColor) {
					board.resetPossibleMovements();
					System.out.print("Choose the square: ");	
					String currentSquare = getSquare(); //PICK THE SQUARE
					currentY = board.convertInput(currentSquare, Type.Y);
					currentX = board.convertInput(currentSquare, Type.X);
					
					selectedPiece = board.getPiece(currentY, currentX); //GET THE PIECE IN THAT SQUARE
					
					if(selectedPiece.color == turn) {
						rightColor = true;
						board.printBoard(selectedPiece); //PRINT WITH SELECTED PIECE
					    
					    unblocked = getUnblocked(currentY, currentX);
					    
					    if(!unblocked) {
					    	rightColor = false;
					    	System.out.println("The " + 
					    			turn.toString().toLowerCase() + " " +
					    				selectedPiece.getName().replace("Pieces.", "").toLowerCase() + 
					    					" can't move" );
					    }
					}else {
						System.out.println("It's " + turn.toString().toLowerCase() + "'s turn.");
					}
				}
			}

			System.out.print("Move " + 
					turn.toString().toLowerCase() + " " 
						+ selectedPiece.getName().replace("Pieces.", "").toLowerCase() + 
							" from " +
								letters.charAt(selectedPiece.getCurrentY()) + 
									(selectedPiece.getCurrentX() +1) + " to: ");
			String nextSquare = getSquare(); //PICK TILE TO MOVE TO
			int nextY = board.convertInput(nextSquare, Type.Y);
			int nextX = board.convertInput(nextSquare, Type.X);
			board.movePiece(selectedPiece, currentY, currentX, nextY, nextX); //MOVE SELECTED PIECE TO THAT SQUARE
			board.resetPossibleMovements();
			selectedPiece = null;
			System.out.println("_______________________________________");
			
			if(turn == Color.WHITE) {
				turn = Color.BLACK;
			}else {
				turn = Color.WHITE;
			}
		}
	}
	
	public String getSquare() {
		Scanner scan = new Scanner(System.in);
		String square = scan.nextLine().toUpperCase();
		return square;
	}
	
	public boolean getUnblocked(int currentY, int currentX) {
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
