/**
 * Author: Aamina Hussain, hussaa54
 * Revised: March 29, 2021
 * 
 * Description: Testing AttributeT class
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import src.BoardT;
import java.util.*;

public class TestBoardT{

	private BoardT game;
	private BoardT game2;
	private int[][] ownGame;
	private int[][] winningGame;
	private int[][] losingGame;
	private int[][] noMoves;
	private int[][] right;
	private int[][] left;
	private int[][] up;
	private int[][] down;
	private int[][] wrongBoard;
	private int[][] wrongBoard2;

	@Before
    public void setUp()
    {
        game = new BoardT();
        game2 = new BoardT();
        ownGame = new int[][] {{2,4,8,2}, {4,2,2,0}, {8,2,2,16}, {32,4,8,16}};
        winningGame = new int[][] {{2,4,8,2}, {4,2,4,0}, {8,1024,1024,16}, {32,4,8,16}};
        losingGame = new int[][] {{8,4,8,0}, {16,32,64,128}, {256,4,2,512}, {32,16,8,16}};
       	noMoves = new int[][] {{8,4,8,4}, {16,32,64,128}, {256,4,2,512}, {32,16,8,16}};
       	right = new int[][] {{4,0,0,0}, {2,2,2,2}, {4,0,2,0}, {4,0,2,2}};
       	left = new int[][] {{0,0,0,4}, {2,2,2,2}, {0,2,0,4}, {2,2,0,4}};
       	up = new int[][] {{0,2,0,2}, {0,2,2,2}, {0,2,0,0}, {4,2,4,4}};
       	down = new int[][] {{4,2,2,4}, {0,2,0,0}, {0,2,4,2}, {0,2,0,2}};
       	wrongBoard = new int[][] {{2,2,2,4}, {2,2,2,4}, {2,2,2,4}, {2,2,2,4}, {2,2,2,4}};
       	wrongBoard2 = new int[][] {{2,2,2,4}, {2,2,2,4}, {2,2,2,4,2}, {2,2,2,4}};
    }

    @After
    public void tearDown()
    {
        game = null;
        game2 = null;
        ownGame = null;
        winningGame = null;
        losingGame = null;
        noMoves = null;
        right = null;
        left = null;
        up = null;
        down = null;
        wrongBoard = null;
        wrongBoard2 = null;
    }

    @Test
    public void testgetBoard()
    {
    	int counter = 0;
    	int twoCounter = 0;
    	int fourCounter = 0;
    	for(int i = 0; i < game.size; i++){
    		for(int j = 0; j < game.size; j++){
    			if(game.getBoard()[i][j] == 0){
    				counter++;
    			}
    			else if(game.getBoard()[i][j] == 2){
    				twoCounter++;
    			}
    			else if(game.getBoard()[i][j] == 4){
    				fourCounter++;
    			}
    		}
    	}
        assertTrue((counter == 14 && twoCounter == 1 && fourCounter == 1) || (counter == 14 && twoCounter == 2));
    }

    @Test
    public void testgetScore()
    {
    	game.setBoard(ownGame);
    	game.moveRight();
        assertTrue(game.getScore() == 8);
    }

    @Test
    public void testemptyCells()
    {
        assertTrue(game.emptyCells().size() == 14);
        assertFalse(game.emptyCells().size() != 14);
    }

    @Test
    public void testisGameWon()
    {
    	if(!(game.isGameWon())){
    		game.setBoard(winningGame);
    		game.moveRight();
    	}
    	
        assertTrue(game.isGameWon());
        assertFalse(game2.isGameWon());
    }

    @Test
    public void testisGameLost()
    {
    	if(!(game.isGameLost())){
    		game.setBoard(losingGame);
    		game.moveRight();
    	}
    	
        assertTrue(game.isGameLost());
        assertFalse(game2.isGameLost());
    }

    @Test
    public void testsetBoard()
    {
    	boolean a = true;
    	game.setBoard(ownGame);
    	for(int i = 0; i < game.size; i++){
    		for(int j = 0; j < game.size; j++){
    			if(!(game.getBoard()[i][j] == ownGame[i][j])){
    				a = false;
    			}
    		}
    	}
        assertTrue(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsetBoardException1()
    {
    	game.setBoard(wrongBoard);
    }

   	@Test(expected = IllegalArgumentException.class)
    public void testsetBoardException2()
    {
    	game.setBoard(wrongBoard2);
    }

    @Test
    public void testresetBoard()
    {
    	game.setBoard(ownGame);
    	game.moveRight();
    	game.resetBoard();

    	int counter = 0;
    	int twoCounter = 0;
    	int fourCounter = 0;
    	for(int i = 0; i < game.size; i++){
    		for(int j = 0; j < game.size; j++){
    			if(game.getBoard()[i][j] == 0){
    				counter++;
    			}
    			else if(game.getBoard()[i][j] == 2){
    				twoCounter++;
    			}
    			else if(game.getBoard()[i][j] == 4){
    				fourCounter++;
    			}
    		}
    	}
        assertTrue((counter == 14 && twoCounter == 1 && fourCounter == 1) || (counter == 14 && twoCounter == 2));
        assertTrue(game.getScore() == 0 && !(game.isGameLost()) && !(game.isGameWon()));
    }

    @Test
    public void testisValidMoveRight()
    {
    	game.setBoard(noMoves);
    	game2.setBoard(ownGame);
        assertFalse(game.isValidMoveRight());
        assertTrue(game2.isValidMoveRight());
        game2.setBoard(losingGame);
        assertTrue(game2.isValidMoveRight());
    }

    @Test
    public void testisValidMoveLeft()
    {
    	game.setBoard(noMoves);
    	game2.setBoard(ownGame);
        assertFalse(game.isValidMoveLeft());
        assertTrue(game2.isValidMoveLeft());
    }

    @Test
    public void testisValidMoveUp()
    {
    	game.setBoard(noMoves);
    	game2.setBoard(ownGame);
        assertFalse(game.isValidMoveUp());
        assertTrue(game2.isValidMoveUp());
    }

    @Test
    public void testisValidMoveDown()
    {
    	game.setBoard(noMoves);
    	game2.setBoard(ownGame);
        assertFalse(game.isValidMoveDown());
        assertTrue(game2.isValidMoveDown());
    }

    @Test
    public void testmoveRight()
    {
    	game.setBoard(right);
    	game.moveRight();
    	boolean a = false;
    	if(game.getBoard()[0][3] == 4 && game.getBoard()[1][2] == 4 && game.getBoard()[1][3] == 4 && 
    		game.getBoard()[2][2] == 4 && game.getBoard()[2][3] == 2 && game.getBoard()[3][2] == 4 && 
    		game.getBoard()[3][3] == 4){
    		a = true;
    	}
        assertTrue(a && game.emptyCells().size() == 8 && game.getScore() == 12 && !(game.isGameLost()) && !(game.isGameWon()));
    }

    @Test
    public void testmoveLeft()
    {
    	game.setBoard(left);
    	game.moveLeft();
    	boolean a = false;
    	if(game.getBoard()[0][0] == 4 && game.getBoard()[1][0] == 4 && game.getBoard()[1][1] == 4 && 
    		game.getBoard()[2][0] == 2 && game.getBoard()[2][1] == 4 && game.getBoard()[3][0] == 4 && 
    		game.getBoard()[3][1] == 4){
    		a = true;
    	}
        assertTrue(a && game.emptyCells().size() == 8 && game.getScore() == 12 && !(game.isGameLost()) && !(game.isGameWon()));
    }

    @Test
    public void testmoveUp()
    {
    	game.setBoard(up);
    	game.moveUp();
    	boolean a = false;
    	if(game.getBoard()[0][0] == 4 && game.getBoard()[0][1] == 4 && game.getBoard()[0][2] == 2 && 
    		game.getBoard()[0][3] == 4 && game.getBoard()[1][1] == 4 && game.getBoard()[1][2] == 4 && 
    		game.getBoard()[1][3] == 4){
    		a = true;
    	}
        assertTrue(a && game.emptyCells().size() == 8 && game.getScore() == 12 && !(game.isGameLost()) && !(game.isGameWon()));
    }

    @Test
    public void testmoveDown()
    {
    	game.setBoard(down);
    	game.moveDown();
    	boolean a = false;
    	if(game.getBoard()[2][1] == 4 && game.getBoard()[2][2] == 2 && game.getBoard()[2][3] == 4 && 
    		game.getBoard()[3][0] == 4 && game.getBoard()[3][1] == 4 && game.getBoard()[3][2] == 4 && 
    		game.getBoard()[3][3] == 4){
    		a = true;
    	}
        assertTrue(a && game.emptyCells().size() == 8 && game.getScore() == 12 && !(game.isGameLost()) && !(game.isGameWon()));
    }


}