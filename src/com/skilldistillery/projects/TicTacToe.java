package com.skilldistillery.projects;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {

		char[][] board = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' }, };

		Scanner kb = new Scanner(System.in);

		System.out.print("Player 1 'X' or 'O' : ");
		String player1XO = kb.next();

		char player1Mark = 'X';
		char player2Mark = 'O';

		if (player1XO.startsWith("X") == false) {
			player1Mark = 'O';
			player2Mark = 'X';

		}

		printBoard(board);

		while (true) {

			populateBoard(board, kb, player1Mark, 1);
			if ((isWinHorizontal(board)) || (isWinVertical(board)) || isWinDiagonal(board)) {
				System.out.print("Player 1 Wins!..");
				break;
			}
			populateBoard(board, kb, player2Mark, 2);
			if ((isWinHorizontal(board)) || (isWinVertical(board)) || isWinDiagonal(board)) {
				System.out.println("Player 2 Wins!..");
				break;
			}

		}
		kb.close();

	}

	public static void printBoard(char[][] board) {
		System.out.println("— — — — — — -");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("— — — — — — -");
		}
	}

	public static void populateBoard(char[][] board, Scanner kb, char mark, int player) {
		int row;
		int col;
		do {
			System.out.print("Player " + player + " Enter Row (0-2) : ");
			row = kb.nextInt();
			System.out.print("Player " + player + " Enter Column (0-2) : ");
			col = kb.nextInt();
			if (board[row][col] != '_') {
				System.out.print("Already Taken! ");
			}

		} while (board[row][col] != '_');

		board[row][col] = mark;

		printBoard(board);

	}

	public static boolean isWinHorizontal(char[][] board) {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] != '_' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
				return true;
			}

		}

		return false;
	}

	public static boolean isWinVertical(char[][] board) {
		for (int col = 0; col < 3; col++) {
			if (board[0][col] != '_' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
				return true;
			}

		}

		return false;
	}

	public static boolean isWinDiagonal(char[][] board) {
		if ((board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
				|| (board[2][0] != '_' && board[2][0] == board[1][1] && board[1][1] == board[0][2])) {
			return true;
		}

		return false;
	}

	public static boolean isDraw(char[][] board) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; row++) {
				if (board[row][col] == '_') {
					return false;
				}
			}
		}
		return true;
	}

}
