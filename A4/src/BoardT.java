/**
 * Author: Aamina Hussain
 * Revised: April 13, 2021
 *
 * Description: A model module for storing the state and status of the game 2048
 */

package src;

// Import java libraries
import java.util.*;

/**
 * @brief An ADT that represents a board of the game 2048
 * @details The board is represented as a 2D integer array and keeps track of the score
 */
public class BoardT{
	
	// State Variables
	private int[][] board;
	private int score;
	private static int highscore = 0;
	private ArrayList<ArrayList<Integer>> empty;
	private boolean win;
	private boolean lose;

	// Exported Constants
	public final static int size = 4;

   /**
	* @brief Initializes a board object
	* @details creates a board with two 2's or one 2 and one 4 in random cells
	*/
	public BoardT(){
		this.board = new int[4][4];
		this.score = 0;
		this.win = false;
		this.lose = false;
		this.empty = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				ArrayList<Integer> cell = new ArrayList<Integer>();
				cell.add(i);
				cell.add(j);
				this.empty.add(cell);
			}
		}

		// Makes a random cell a 2 or a 4, then removes it from the empty cells set.
		int randomCell = randomGenerator(0, this.empty.size()-1);
		int randomInt = randomGenerator(0,1);
		if(randomInt == 0){
			randomInt = 2;
		}
		else{
			randomInt = 4;
		}
		this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = randomInt;
		this.empty.remove(randomCell);

		// If the previous random cell is already a 4, then make the next random cell a 2, then remove
		// it from the set of empty cells.
		// If not, then it makes another random cell a 2 or a 4, then removes it from the empty cells set.
		if(randomInt == 4){
			randomCell = randomGenerator(0, this.empty.size()-1);
			this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = 2;
			this.empty.remove(randomCell);
		}

		else{
			randomCell = randomGenerator(0, this.empty.size()-1);
			randomInt = randomGenerator(0,1);
			if(randomInt == 0){
				randomInt = 2;
			}
			else{
				randomInt = 4;
			}
			this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = randomInt;
			this.empty.remove(randomCell);
		}
	}

   /**
	* @brief Gets the current state of the board
	* @return The current state of the board
	*/
	public int[][] getBoard(){
		return this.board;
	}

   /**
	* @brief Gets the current score
	* @return The current score
	*/
	public int getScore(){
		return this.score;
	}

   /**
	* @brief Gets the best score
	* @return The best score
	*/
	public int getHighScore(){
		return this.highscore;
	}

   /**
	* @brief Gets the the set of empty cells that are on the board
	* @return The set of empty cells
	*/
	public ArrayList<ArrayList<Integer>> emptyCells(){
		return this.empty;
	}

   /**
	* @brief Gets whether the game has been won or not
	* @return True if the game has been won
	*/
	public boolean isGameWon(){
		return this.win;
	}

   /**
	* @brief Gets whether the game has been lost or not
	* @return True if the game has been lost
	*/
	public boolean isGameLost(){
		return this.lose;
	}

   /**
	* @brief Sets the board to a predefined board
	* @details Makes it easier for testing purposes since values are not random
	* @param b a board that has already been created
	* @throws IllegalArgumentException - if the entered 2D array is not 4x4
	*/
	public void setBoard(int[][] b){
		if(b.length != 4){
			throw new IllegalArgumentException("Board must be 4x4.");
		}
		for(int i = 0; i < b.length; i++){
			if(b[i].length != 4){
				throw new IllegalArgumentException("Board must be 4x4.");
			}
		}
		this.board = b;
	}

   /**
	* @brief Restarts/reinitializes the current game
	*/
	public void resetBoard(){
		BoardT temp = new BoardT();
		this.board = temp.board;
		this.score = 0;
		this.win = false;
		this.lose = false;
		temp = null;
	}

   /**
	* @brief Generates a random number between (and including) two given numbers
	* @param min The lower bound of the range
	* @param max The upper bound of the range
	* @return The randomly generated number
	*/
	public int randomGenerator(int min, int max){
		int randomNum = (int)Math.floor(Math.random()*(max-min+1)+min);
		return randomNum;
	}

   /**
	* @brief Checks if the player can make a move right
	* @return True if the player can move right
	*/
	public boolean isValidMoveRight(){
		for(int i = 0; i < this.size; i++){
			if(this.board[i][0] == 0 && this.board[i][1] == 0 && this.board[i][2] == 0){}

			else if(this.board[i][0] == 0 && this.board[i][1] == 0 && this.board[i][2] != this.board[i][3]
				&& this.board[i][2] != 0 && this.board[i][3] != 0){}

			else if(this.board[i][0] == 0 && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][1] != 0 &&
				this.board[i][2] != 0 && this.board[i][3] != 0){}

			else if(this.board[i][0] != this.board[i][1] && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][0] != 0 && this.board[i][1] != 0
				&& this.board[i][2] != 0 && this.board[i][3] != 0){}

			else{
				return true;
			}
		}
		return false;
	}

   /**
	* @brief Checks if the player can make a move left
	* @return True if the player can move left
	*/
	public boolean isValidMoveLeft(){
		for(int i = 0; i < this.size; i++){
			if(this.board[i][3] == 0 && this.board[i][2] == 0 && this.board[i][1] == 0){}

			else if(this.board[i][3] == 0 && this.board[i][2] == 0 && this.board[i][1] != this.board[i][0]
				&& this.board[i][1] != 0 && this.board[i][0] != 0){}

			else if(this.board[i][3] == 0 && this.board[i][2] != this.board[i][1]
				&& this.board[i][1] != this.board[i][0] && this.board[i][2] != 0 &&
				this.board[i][1] != 0 && this.board[i][0] != 0){}

			else if(this.board[i][0] != this.board[i][1] && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][0] != 0 && this.board[i][1] != 0
				&& this.board[i][2] != 0 && this.board[i][3] != 0){}

			else{
				return true;
			}
		}
		return false;
	}

   /**
	* @brief Checks if the player can make a move up
	* @return True if the player can move up
	*/
	public boolean isValidMoveUp(){
		for(int i = 0; i < this.size; i++){

			if(this.board[1][i] == 0 && this.board[2][i] == 0 && this.board[3][i] == 0){}

			else if(this.board[3][i] == 0 && this.board[2][i] == 0 && this.board[1][i] != this.board[0][i]
				&& this.board[1][i] != 0 && this.board[0][i] != 0){}

			else if(this.board[3][i] == 0 && this.board[2][i] != this.board[1][i]
				&& this.board[1][i] != this.board[0][i] && this.board[2][i] != 0 &&
				this.board[1][i] != 0 && this.board[0][i] != 0){}

			else if(this.board[0][i] != this.board[1][i] && this.board[1][i] != this.board[2][i]
				&& this.board[2][i] != this.board[3][i] && this.board[0][i] != 0 && this.board[1][i] != 0
				&& this.board[2][i] != 0 && this.board[3][i] != 0){}

			else{
				return true;
			}
		}
		return false;
	}

   /**
	* @brief Checks if the player can make a move down
	* @return True if the player can move down
	*/
	public boolean isValidMoveDown(){
		for(int i = 0; i < this.size; i++){
			
			if(this.board[0][i] == 0 && this.board[1][i] == 0 && this.board[2][i] == 0){}

			else if(this.board[0][i] == 0 && this.board[1][i] == 0 && this.board[2][i] != this.board[3][i]
				&& this.board[2][i] != 0 && this.board[3][i] != 0){}

			else if(this.board[0][i] == 0 && this.board[1][i] != this.board[2][i]
				&& this.board[2][i] != this.board[3][i] && this.board[1][i] != 0 &&
				this.board[2][i] != 0 && this.board[3][i] != 0){}

			else if(this.board[0][i] != this.board[1][i] && this.board[1][i] != this.board[2][i]
				&& this.board[2][i] != this.board[3][i] && this.board[0][i] != 0 && this.board[1][i] != 0
				&& this.board[2][i] != 0 && this.board[3][i] != 0){}

			else{
				return true;
			}
		}
		return false;
	}

   /**
	* @brief Executes the move to the right
	* @details Shifts tiles over to the right, combines tiles with the same value, updates the score, and checks if the player won or lost.
	*/
	public void moveRight(){

		if(!(isValidMoveRight())){
			return;
		}

		for(int i = 0; i < this.size; i++){
			if(this.board[i][2] == 0 && this.board[i][3] == 0){
				this.board[i][2] = this.board[i][0];
				this.board[i][3] = this.board[i][1];
				this.board[i][0] = 0;
				this.board[i][1] = 0;
			}
			else if(this.board[i][1] == 0 && this.board[i][2] == 0){
				this.board[i][2] = this.board[i][0];
				this.board[i][0] = 0;
			}
			for(int j = 0; j < this.size; j++){
				if(this.board[i][3-j] == 0){
					for(int k = 0; k < 3-j; k++){
						this.board[i][3-j-k] = this.board[i][3-j-k-1];
					}
					this.board[i][0] = 0;
				}
			}
		}

		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size-1; j++){
				if(this.board[i][3-j] == this.board[i][3-j-1]){
					this.board[i][3-j] = this.board[i][3-j-1]*2;
					if(this.board[i][3-j-1]*2 == 2048){
						this.win = true;
					}
					this.score += this.board[i][3-j-1]*2;
					if(this.score > this.highscore){
						this.highscore = this.score;
					}
					for(int k = 1; k < 3-j; k++){
						this.board[i][3-j-k] = this.board[i][3-j-k-1];
					}
					this.board[i][0] = 0;
				}
			}
		}

		this.empty.clear();
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				if(this.board[i][j] == 0){
					ArrayList<Integer> cell = new ArrayList<Integer>();
					cell.add(i);
					cell.add(j);
					this.empty.add(cell);
				}
			}
		}
		int randomCell = randomGenerator(0, this.empty.size()-1);
		this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = 2;
		this.empty.remove(randomCell);

		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

   /**
	* @brief Executes the move to the left
	* @details Shifts tiles over to the left, combines tiles with the same value, updates the score, and checks if the player won or lost.
	*/
	public void moveLeft(){

		if(!(isValidMoveLeft())){
			return;
		}

		for(int i = 0; i < this.size; i++){
			if(this.board[i][0] == 0 && this.board[i][1] == 0){
				this.board[i][0] = this.board[i][2];
				this.board[i][1] = this.board[i][3];
				this.board[i][2] = 0;
				this.board[i][3] = 0;
			}
			else if(this.board[i][1] == 0 && this.board[i][2] == 0){
				this.board[i][1] = this.board[i][3];
				this.board[i][3] = 0;
			}
			for(int j = 0; j < this.size; j++){
				if(this.board[i][j] == 0){
					for(int k = 0; k < 3-j; k++){
						this.board[i][j+k] = this.board[i][j+k+1];
					}
					this.board[i][3] = 0;
				}
			}
		}

		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size-1; j++){
				if(this.board[i][j] == this.board[i][j+1]){
					this.board[i][j] = this.board[i][j+1]*2;
					if(this.board[i][j+1]*2 == 2048){
						this.win = true;
					}
					this.score += this.board[i][j+1]*2;
					if(this.score > this.highscore){
						this.highscore = this.score;
					}
					for(int k = 1; k < 3-j; k++){
						this.board[i][j+k] = this.board[i][j+k+1];
					}
					this.board[i][3] = 0;
				}
			}
		}

		this.empty.clear();
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				if(this.board[i][j] == 0){
					ArrayList<Integer> cell = new ArrayList<Integer>();
					cell.add(i);
					cell.add(j);
					this.empty.add(cell);
				}
			}
		}
		int randomCell = randomGenerator(0, this.empty.size()-1);
		this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = 2;
		this.empty.remove(randomCell);

		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

   /**
	* @brief Executes the move up
	* @details Shifts tiles up, combines tiles with the same value, updates the score, and checks if the player won or lost.
	*/
	public void moveUp(){

		if(!(isValidMoveUp())){
			return;
		}

		for(int i = 0; i < this.size; i++){
			if(this.board[0][i] == 0 && this.board[1][i] == 0){
				this.board[0][i] = this.board[2][i];
				this.board[1][i] = this.board[3][i];
				this.board[2][i] = 0;
				this.board[3][i] = 0;
			}
			else if(this.board[1][i] == 0 && this.board[2][i] == 0){
				this.board[1][i] = this.board[3][i];
				this.board[3][i] = 0;
			}
			for(int j = 0; j < this.size; j++){
				if(this.board[j][i] == 0){
					for(int k = 0; k < 3-j; k++){
						this.board[j+k][i] = this.board[j+k+1][i];
					}
					this.board[3][i] = 0;
				}
			}
		}

		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size-1; j++){
				if(this.board[j][i] == this.board[j+1][i]){
					this.board[j][i] = this.board[j+1][i]*2;
					if(this.board[j+1][i]*2 == 2048){
						this.win = true;
					}
					this.score += this.board[j+1][i]*2;
					if(this.score > this.highscore){
						this.highscore = this.score;
					}
					for(int k = 1; k < 3-j; k++){
						this.board[j+k][i] = this.board[j+k+1][i];
					}
					this.board[3][i] = 0;
				}
			}
		}

		this.empty.clear();
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				if(this.board[i][j] == 0){
					ArrayList<Integer> cell = new ArrayList<Integer>();
					cell.add(i);
					cell.add(j);
					this.empty.add(cell);
				}
			}
		}
		int randomCell = randomGenerator(0, this.empty.size()-1);
		this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = 2;
		this.empty.remove(randomCell);

		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

   /**
	* @brief Executes the move down
	* @details Shifts tiles down, combines tiles with the same value, updates the score, and checks if the player won or lost.
	*/
	public void moveDown(){

		if(!(isValidMoveRight())){
			return;
		}

		for(int i = 0; i < this.size; i++){
			if(this.board[2][i] == 0 && this.board[3][i] == 0){
				this.board[2][i] = this.board[0][i];
				this.board[3][i] = this.board[1][i];
				this.board[0][i] = 0;
				this.board[1][i] = 0;
			}
			else if(this.board[1][i] == 0 && this.board[2][i] == 0){
				this.board[2][i] = this.board[0][i];
				this.board[0][i] = 0;
			}
			for(int j = 0; j < this.size; j++){
				if(this.board[3-j][i] == 0){
					for(int k = 0; k < 3-j; k++){
						this.board[3-j-k][i] = this.board[3-j-k-1][i];
					}
					this.board[0][i] = 0;
				}
			}
		}

		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size-1; j++){
				if(this.board[3-j][i] == this.board[3-j-1][i]){
					this.board[3-j][i] = this.board[3-j-1][i]*2;
					if(this.board[3-j-1][i]*2 == 2048){
						this.win = true;
					}
					this.score += this.board[3-j-1][i]*2;
					if(this.score > this.highscore){
						this.highscore = this.score;
					}
					for(int k = 1; k < 3-j; k++){
						this.board[3-j-k][i] = this.board[3-j-k-1][i];
					}
					this.board[0][i] = 0;
				}
			}
		}

		this.empty.clear();
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				if(this.board[i][j] == 0){
					ArrayList<Integer> cell = new ArrayList<Integer>();
					cell.add(i);
					cell.add(j);
					this.empty.add(cell);
				}
			}
		}
		int randomCell = randomGenerator(0, this.empty.size()-1);
		this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = 2;
		this.empty.remove(randomCell);

		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

}
