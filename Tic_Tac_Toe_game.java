package Projects;

import java.util.Scanner;

public class Tic_Tac_Toe_game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0, i, j, m, n;
		String a[][] = new String[3][3];

		// Initialize the board
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				a[i][j] = "_";
			}
		}

		System.out.println("Enter name of person 1 (use X):");
		String p1Name = scan.next();
		System.out.println("Enter name of person 2 (use O):");
		String p2Name = scan.next();

		boolean gameRunning = true;

		while (gameRunning) {
			// Player 1's turn
			while (true) {
				System.out.println(p1Name + " (X), enter row and column where you want to place:");
				m = scan.nextInt();
				n = scan.nextInt();
				if (m < 0 || m >= 3 || n < 0 || n >= 3) {
					System.err.println("Invalid position! Please enter row and column between 0 and 2.");
				} 
				else if (a[m][n].equals("_")) {
					a[m][n] = "X";
					count++;
					if (checkConditions(a)) {
						System.out.printf("The winner is %s (X)!\n", p1Name);
						gameRunning = false;
					}
					break;
				} 
				else {
					System.err.println("Slot already filled. Choose another slot.");
				}
			}

			// Print board
			printBoard(a);

			// Check for tie
			if (count >= 9) {
				System.out.println("It's a tie!");
				break;
			}

			if (!gameRunning) break;

			// Player 2's turn
			while (true) {
				System.out.println(p2Name + " (O), enter row and column where you want to place:");
				m = scan.nextInt();
				n = scan.nextInt();
				if (m < 0 || m >= 3 || n < 0 || n >= 3) {
					System.err.println("Invalid position! Please enter row and column between 0 and 2.");
				} else if (a[m][n].equals("_")) {
					a[m][n] = "O";
					count++;
					if (checkConditions(a)) {
						System.out.printf("The winner is %s (O)!\n", p2Name);
						gameRunning = false;
					}
					break;
				} else {
					System.err.println("Slot already filled. Choose another slot.");
				}
			}

			// Print board
			printBoard(a);

			// Check for tie
			if (count >= 9 && gameRunning) {
				System.out.println("It's a tie!");
				break;
			}
		}
	}

	// Method to check winning conditions
	public static boolean checkConditions(String[][] a) {
		// Check rows
		for (int i = 0; i < 3; i++) {
			if (a[i][0].equals(a[i][1]) && a[i][1].equals(a[i][2]) && !a[i][0].equals("_")) {
				return true;
			}
		}

		// Check columns
		for (int j = 0; j < 3; j++) {
			if (a[0][j].equals(a[1][j]) && a[1][j].equals(a[2][j]) && !a[0][j].equals("_")) {
				return true;
			}
		}

		// Check diagonals
		if (a[0][0].equals(a[1][1]) && a[1][1].equals(a[2][2]) && !a[0][0].equals("_")) {
			return true;
		}

		if (a[0][2].equals(a[1][1]) && a[1][1].equals(a[2][0]) && !a[0][2].equals("_")) {
			return true;
		}

		return false;
	}

	// Method to print the board
	public static void printBoard(String[][] a) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
