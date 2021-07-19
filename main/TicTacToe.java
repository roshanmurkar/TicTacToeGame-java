package main;
import java.util.*;
import main.Operation;

public class TicTacToe {
	public static void main(String[] args) {
		Operation printBoard = new Operation();
		Operation game=new Operation();
		
		char [][] gameBoard = {{' ','|',' ','|',' ' },
				{'-','+','-','+','-' },
				{' ','|',' ','|',' ' },
				{'-','+','-','+','-' },
				{' ','|',' ','|',' ' }};
		printBoard.printGameBoard(gameBoard);
		game.gameMain(gameBoard);
	}
	
}		

