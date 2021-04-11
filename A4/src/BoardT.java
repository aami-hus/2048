/**
 * Author: Aamina Hussain, hussaa54
 * Revised: April 12, 2021
 */

package src;

import src.MoveT;
import java.util.*;

public class BoardT{
	
	private int[][] board;
	private int score;
	private ArrayList<ArrayList<Integer>> empty;

	public final static int size = 4;

	public BoardT(){
		this.board = new int[4][4];
		this.score = 0;
		this.empty = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				ArrayList<Integer> cell = new ArrayList<Integer>();
				cell.add(i);
				cell.add(j);
				this.empty.add(cell);
			}
		}

		// Makes one random cell a 2 or a 4, then removes it from the empty set
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

	public int[][] getBoard(){
		return this.board;
	}

	public int getScore(){
		return this.score;
	}

	// assumption: input will always be 4x4 array
	// assumption: all numbers in array will be correct (aka 0 or a power of 2 (not including 1))
	public void setBoard(int[][] b){
		this.board = b;
	}

	public int randomGenerator(int min, int max){
		int randomNum = (int)Math.floor(Math.random()*(max-min+1)+min);
		return randomNum;
	}

	// not complete yet
	public void resetBoard(){
		this.board = new int[4][4];
		this.score = 0;

	}

	public boolean isValidMoveRight(){
		boolean valid;
		for(int i = 0; i < this.size; i++){
			if(this.board[i][0] == 0 && this.board[i][1] == 0 && this.board[i][2] == 0){
				;
			}
			else if(this.board[i][0] == 0 && this.board[i][1] == 0 && this.board[i][2] != this.board[i][3]
				&& this.board[i][2] != 0 && this.board[i][3] != 0){
				
			}
			else if(this.board[i][0] == 0 && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][1] != 0 &&
				this.board[i][2] != 0 && this.board[i][3] != 0){
				valid = false;
			}
			else if(this.board[i][0] != this.board[i][1] && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][0] != 0 && this.board[i][1] != 0
				&& this.board[i][2] != 0 && this.board[i][3] != 0){
				valid = false;
			}
			else{
				return true;
			}
		}
		return false;
	}



}
