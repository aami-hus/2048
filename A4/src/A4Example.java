package src;

import java.util.*;
//import BoardT;

public class A4Example{

	public static void main(String[] args){

		BoardT game = new BoardT();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// game.resetBoard();
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// int[][] ownGame = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int[][] ownGame2 = new int[][] {{1,0,4,4}, 
										{5,8,0,8}, 
										{2,2,2,2}, 
										{0,16,0,16}};
		game.setBoard(ownGame2);
		// System.out.println(Arrays.deepToString(game.getBoard()));
		// game.moveRight();
		game.moveLeft();
		System.out.println(Arrays.deepToString(game.getBoard()));
		// System.out.println(game.isGameWon());
		// System.out.println(game.emptyCells());
		// System.out.println(game.getScore());



	}

}