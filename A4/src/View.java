/**
 * Author: Aamina Hussain
 * Revised: April 14, 2021
 *
 * Description: A view module that displays the status of the game 2048
 */

package src;


public class View{

   /**
	* @brief Displays a welcome message
	*/
	public static void printWelcomeMessage(){
		System.out.println("--------------------------------------");
		System.out.println("                 2048                 ");
		System.out.println("     Join the tiles, get to 2048!     ");
		System.out.println("--------------------------------------");
	}

   /**
	* @brief Displays the board of the game on the screen
	* @param b The given game board
	*/
	public static void printBoard(BoardT b){
		int[][] board = b.getBoard();
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++){
				System.out.printf("%7d", board[row][col]);
			}
			System.out.println();
		}
	}

   /**
	* @brief Displays a prompt asking the player what move they would like to make
	*/
	public static void printMovePrompt(){
		System.out.println("Enter r to move RIGHT, L to move LEFT, u to move UP, d to move DOWN, q to quit: ");
	}

   /**
	* @brief Displays the current score of the game
	* @param b The given game board
	*/
	public static void printScore(BoardT b){
		System.out.println("Score: " + b.getScore());
	}

	/**
	* @brief Displays the best score
	* @param b The given game board
	*/
	public static void printHighScore(BoardT b){
		System.out.println("Best Score: " + b.getHighScore());
	}

   /**
	* @brief Displays a message when the game is lost and displays a prompt asking the player if they would like to try again
	*/
	public static void printLosingMessage(){
		System.out.println("              ----------              ");
		System.out.println("              Game Over!              ");
		System.out.println("              Try Again?              ");
		System.out.println("              ----------              ");
		System.out.println("Enter t to try again, q to quit: ");
	}

   /**
	* @brief Displays a message when the game is won and displays a prompt asking the player if they would like to keep going
	*/
	public static void printWinningMessage(){
		System.out.println("       ------------------------       ");
		System.out.println("               You win!               ");
		System.out.println("       Keep Going or Try Again?       ");
		System.out.println("       ------------------------       ");
		System.out.println("Enter k to keep going, t to try again, q to quit: ");
	}

   /**
	* @brief Displays a message when the player decides to exit the game
	*/
	public static void printFarewellMessage(){
		System.out.println("--------------------------------------");
		System.out.println("        Thanks for Playing! :)        ");
		System.out.println("--------------------------------------");
	}
	
}