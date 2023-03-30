package Main;
import java.util.ArrayList;

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
			board.printBoard(selectedPiece);
			System.out.print("Choose the tile: ");
			String currentTile = board.getTile();
			int currentY = board.convertInput(currentTile, 'y');
			int currentX = board.convertInput(currentTile, 'x');
			selectedPiece = board.getPiece(currentY, currentX);
			board.printBoard(selectedPiece);

			System.out.printf("Tile to move to: ");
			String nextTile = board.getTile();
			int nextY = board.convertInput(nextTile, 'y');
			int nextX = board.convertInput(nextTile, 'x');
			board.movePiece(currentY, currentX, nextY, nextX);
			selectedPiece = null;
			System.out.println("_______________________________________");
			System.out.println("\033[2J");

			clearConsole();
		}
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
	
	private void clearConsole() {
	}
}
