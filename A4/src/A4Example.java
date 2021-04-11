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
		game.setBoard(ownGame2);
		// System.out.println(Arrays.deepToString(game.getBoard()));
		System.out.println(game.isValidMoveRight());


	}

}