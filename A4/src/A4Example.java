package src;

import java.util.*;
//import BoardT;

public class A4Example{

	public static void main(String[] args){

		// Testing BoardT Module and View module
		View.printWelcomeMessage();

		BoardT game = new BoardT();
		System.out.println("first state of board: " + Arrays.deepToString(game.getBoard()));

		int[][] ownGame = new int[][] {{2,4,8,2}, {4,2,2,0}, {8,2,2,16}, {32,4,8,16}};
		game.setBoard(ownGame);
		System.out.println("board has been set: ");
		View.printBoard(game);

		View.printMovePrompt();
		game.moveRight();
		View.printBoard(game);
		View.printScore(game);

		game.resetBoard();
		System.out.println("reset board: " + Arrays.deepToString(game.getBoard()));
		View.printScore(game);
		View.printHighScore(game);

		View.printFarewellMessage();
	}

}