package ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [][]gameboard = {{' ','|',' ','|',' '},	
								{'-','+','-','+','-'},
								{' ','|',' ','|',' '},
								{'-','+','-','+','-'},
								{' ','|',' ','|',' '}};
		printGameboard(gameboard); 
		
		while(true) {
			Scanner sc =new Scanner(System.in);

			System.out.println("enter your placement from 0 to 9");
			int playerPos=sc.nextInt();
			while(playerPositions.contains(playerPos)||cpuPositions.contains(playerPositions)) {
				System.out.println("position taken enter correct position");
				playerPos=sc.nextInt();
			}
			
			placePiece(gameboard,playerPos,"player");
			
			Random rand = new Random();
			int cpupos = rand.nextInt(9)+1;
			while(playerPositions.contains(cpupos)||cpuPositions.contains(cpupos)) {
				System.out.println("position taken enter correct position");
				cpupos = rand.nextInt(9)+1;
			}
			placePiece(gameboard,cpupos,"cpu");
			
			printGameboard(gameboard);
			
			String result = checkWinner();
			
			System.out.println(result);
		}
		
	}
	public static void printGameboard(char [][]gameboard){
		for(char[] row : gameboard) {
			for(char c :row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void placePiece(char [][]gameboard,int pos,String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='X';
			playerPositions.add(pos);
		}
		else if(user.equals("cpu")){
			symbol='O';
			cpuPositions.add(pos);
		} 
		switch(pos){
			case 1:
				gameboard[0][0]=symbol;
				break;
			case 2:
				gameboard[0][2]=symbol;
				break;
			case 3:
				gameboard[0][4]=symbol;
				break;
			case 4:
				gameboard[2][0]=symbol;
				break;
			case 5:
				gameboard[2][2]=symbol;
				break;
			case 6:
				gameboard[2][4]=symbol;
				break;
			case 7:
				gameboard[4][0]=symbol;
				break;
			case 8:
				gameboard[4][2]=symbol;
				break;
			case 9:
				gameboard[4][4]=symbol;
				break;
			default:
				break;
		}
	}
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftcol = Arrays.asList(1,4,7);
		List midcol = Arrays.asList(2,5,8);
		List rightcol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		List<List>winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(playerPositions.containsAll(l)) {
				return "congrulations you won!";
			}
			else if(cpuPositions.containsAll(l)) {
				return "CPU wins";
			}
			else if(playerPositions.size()+cpuPositions.size()==9) {
				return "draw";
			}
		}
		return "";
	}

}
