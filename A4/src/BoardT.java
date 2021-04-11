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
	private ArrayList<ArrayList<int>> empty;

	public final static int size = 4;

	public BoardT(){
		this.board = new int[4][4];
		this.score = 0;
		this.empty = new ArrayList<ArrayList<int>>();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				ArrayList<int> cell = new ArrayList<int>();
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
			int randomCell = randomGenerator(0, this.empty.size()-1);
			this.board[this.empty.get(randomCell).get(0)][this.empty.get(randomCell).get(1)] = 2;
			this.empty.remove(randomCell);
		}

		else{
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
		}
	}

	// assumption: input will always be 4x4 array
	public void setBoard(int[][] b){
		this.board = b;
	}

	public int randomGenerator(int min, int max){
		int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
		return randomInt;
	}

	public void resetBoard(){
		this.board = new int[4][4];
		this.score = 0;
		
	}
}
