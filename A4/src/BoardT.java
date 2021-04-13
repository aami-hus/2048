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
	private boolean win;
	private boolean lose;

	public final static int size = 4;

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

	public ArrayList<ArrayList<Integer>> emptyCells(){
		return this.empty;
	}

	public boolean isGameWon(){
		return this.win;
	}

	public boolean isGameLost(){
		return this.lose;
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

	public void resetBoard(){
		BoardT temp = new BoardT();
		this.board = temp.board;
		temp = null;
	}

	public boolean isValidMoveRight(){
		for(int i = 0; i < this.size; i++){
			if(this.board[i][0] == 0 && this.board[i][1] == 0 && this.board[i][2] == 0){
				;
			}
			else if(this.board[i][0] == 0 && this.board[i][1] == 0 && this.board[i][2] != this.board[i][3]
				&& this.board[i][2] != 0 && this.board[i][3] != 0){
				;
			}
			else if(this.board[i][0] == 0 && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][1] != 0 &&
				this.board[i][2] != 0 && this.board[i][3] != 0){
				;
			}
			else if(this.board[i][0] != this.board[i][1] && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][0] != 0 && this.board[i][1] != 0
				&& this.board[i][2] != 0 && this.board[i][3] != 0){
				;
			}
			else{
				return true;
			}
		}
		return false;
	}

	public boolean isValidMoveLeft(){
		for(int i = 0; i < this.size; i++){
			if(this.board[i][3] == 0 && this.board[i][2] == 0 && this.board[i][1] == 0){
				;
			}
			else if(this.board[i][3] == 0 && this.board[i][2] == 0 && this.board[i][1] != this.board[i][0]
				&& this.board[i][1] != 0 && this.board[i][0] != 0){
				;
			}
			else if(this.board[i][3] == 0 && this.board[i][2] != this.board[i][1]
				&& this.board[i][1] != this.board[i][0] && this.board[i][2] != 0 &&
				this.board[i][1] != 0 && this.board[i][0] != 0){
				;
			}
			else if(this.board[i][0] != this.board[i][1] && this.board[i][1] != this.board[i][2]
				&& this.board[i][2] != this.board[i][3] && this.board[i][0] != 0 && this.board[i][1] != 0
				&& this.board[i][2] != 0 && this.board[i][3] != 0){
				;
			}
			else{
				return true;
			}
		}
		return false;
	}

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

		// call fxn to display "try again" or something
		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

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

		// call fxn to display "try again" or something
		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

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

		// call fxn to display "try again" or something
		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

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

		// call fxn to display "try again" or something
		if(!(this.isValidMoveRight() && this.isValidMoveLeft() && this.isValidMoveUp() && this.isValidMoveDown())){
			this.lose = true;
		}
	}

}
