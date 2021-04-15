package src;

import java.util.*;
//import BoardT;

public class A4Example{

	public static void main(String[] args){

		BoardT game = new BoardT();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// game.resetBoard();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		int[][] ownGame = new int[][] {{1,2,2,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int[][] ownGame2 = new int[][] {{3,1,8,4}, 
										{1,1024,1024,4}, 
										{8,1024,8,4}, 
										{2,2,0,4}};
		int[][] incorrectGame = new int[][] {{1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4}};
		// game.setBoard(ownGame2);
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveRight();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveDown();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveLeft();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveUp();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveRight();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveDown();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveLeft();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveUp();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveRight();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveDown();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveLeft();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		game.moveUp();
		System.out.println(Arrays.toString(game.getBoard()[0]));
		System.out.println(Arrays.toString(game.getBoard()[1]));
		System.out.println(Arrays.toString(game.getBoard()[2]));
		System.out.println(Arrays.toString(game.getBoard()[3]));
		System.out.println("score:" + game.getScore());
		// System.out.println(game.getHighScore());
		// game.resetBoard();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// game.setBoard(ownGame);
		// game.moveRight();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// System.out.println(game.getScore());
		// System.out.println(game.getHighScore());
		// View.printWelcomeMessage();
		// View.printBoard(game);
		// View.printMovePrompt();
		// View.printScore(game);
		// View.printLosingMessage();
		// View.printWinningMessage();
		// View.printFarewellMessage();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// game.resetBoard();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// System.out.println(game.isGameWon());
		// System.out.println(game.isGameLost());
		// game.moveDown();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// System.out.println(game.getScore());
		// System.out.println(game.isGameWon());
		// System.out.println(game.isGameLost());
		// game.moveLeft();
		// System.out.println(Arrays.toString(game.getBoard()[0]));
		// System.out.println(Arrays.toString(game.getBoard()[1]));
		// System.out.println(Arrays.toString(game.getBoard()[2]));
		// System.out.println(Arrays.toString(game.getBoard()[3]));
		// System.out.println(game.getScore());
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// System.out.println(game.isGameWon());
		// System.out.println(game.emptyCells());
		// System.out.println(game.getScore());



	}

}