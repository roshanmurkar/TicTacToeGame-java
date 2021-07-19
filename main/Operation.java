package main;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Operation {
	Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	String result;
	
	public static void printGameBoard(char [][] gameBoard) {
		for(char[] row :gameBoard) {
			for(char c : row) {
				System.out.print(c);	
			}
			System.out.println();
		}
		
	}
	
	public static void placePiece(char [][] gameBoard ,int pos , String user) {
		char symbol = ' ';
		if(user.equals("player1")) {
				symbol = 'X';
				playerPositions.add(pos);
		}else if(user.equals("cpu")) {
				symbol = 'O';
				cpuPositions.add(pos);
		}
	
		
		switch (pos) {
			case 1:
				gameBoard[0][0] = symbol;
				System.out.println("add you choice at 1st position");
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;	
			default:
				break;
		}
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		
		List leftDig = Arrays.asList(1,5,9);
		List rightDig = Arrays.asList(3,5,9);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(leftDig);
		winning.add(rightDig);
		
		for(List l : winning) {
			if(playerPositions.containsAll(l)) {
				return "Congo you won";
			}else if(cpuPositions.containsAll(l)) {
				return "CPU won";
			}else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "Tie";
			}
		}
		
		return "";
		
	}
	
	public static void gameMain(char [][] gameBoard) {
		
	while(true) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number between 1-9 :");
		int playerPos = scan.nextInt();
		while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
			System.out.println("position taken! Enter aonther position");
			playerPos = scan.nextInt();
		}
		placePiece(gameBoard, playerPos, "player1");
		printGameBoard(gameBoard);
		String result=checkWinner();
		if(result.length()>0) {
			System.out.println(result);		
			break;
		}
		
		
		Random random = new Random();
		int cpuPos = random.nextInt(9) +1;
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
			//System.out.println("position taken! Enter aonther position");
			cpuPos = random.nextInt(9) +1;
		}
		placePiece(gameBoard, cpuPos, "cpu");
			
		result= checkWinner();
		System.out.println("hiiiii");
		if(result.length()>0) {
			System.out.println(result);		
			break;
			}
		printGameBoard(gameBoard);
		System.out.println("hiiiii");
		
	}
	}
}