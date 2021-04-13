/**
 * Author: Aamina Hussain, hussaa54
 * Revised: April 12, 2021
 */

package src;

//import BoardT;

public class View{

	public static void printWelcomeMessage(){
		System.out.println("--------------------------------------");
		System.out.println("                 2048                 ");
		System.out.println("     Join the tiles, get to 2048!     ");
		System.out.println("--------------------------------------");
	}

	// spacing based on highest tile ever was 5 digits
	public static void printBoard(BoardT b){
		int[][] board = b.getBoard();
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				System.out.printf("%7d", board[row][col]);
			}
			System.out.println();
		}
	}

	public static void printMovePrompt(){
		System.out.println("Enter r to move RIGHT, L to move LEFT, u to move UP, d to move DOWN, q to quit: ");
	}

	public static void printScore(BoardT b){
		System.out.println("Score: " + b.getScore());
	}

	public static void printLosingMessage(){
		System.out.println("              ----------              ");
		System.out.println("              Game Over!              ");
		System.out.println("              Try Again?              ");
		System.out.println("              ----------              ");
		System.out.println("Enter t to try again, q to quit: ");
	}

	public static void printWinningMessage(){
		System.out.println("       ------------------------       ");
		System.out.println("               You win!               ");
		System.out.println("       Keep Going or Try Again?       ");
		System.out.println("       ------------------------       ");
		System.out.println("Enter k to keep going, t to try again, q to quit: ");
	}
	
	public static void printFarewellMessage(){
		System.out.println("--------------------------------------");
		System.out.println("        Thanks for Playing! :)        ");
		System.out.println("--------------------------------------");
	}
	
}