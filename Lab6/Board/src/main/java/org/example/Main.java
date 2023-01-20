package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        final char START = 'A';
        final char STOP = 'B';
        Scanner scanner = new Scanner(System.in);

        // find start position
        for (int i = 0; i < board.ROWS; i++) {
            for (int j = 0; j < board.COLS; j++) {
                if(board.board[i][j] == START) {
                    row = i;
                    col = j;
                }
            }
        }

        board.printBoard();

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("w")) {
                if (row - 1 >= 0 && !board.isObstacle(row - 1, col)) {
                    row--;
                } else {
                    System.out.println("Nie można się ruszyć w górę");
                }
            } else if(input.equals("s")) {
                if (row + 1 < board.ROWS && !board.isObstacle(row + 1, col)) {
                    row++;
                } else {
                    System.out.println("Nie można się ruszyć w dół");
                }
            } else if(input.equals("a")) {
                if (col - 1 >= 0 && !board.isObstacle(row, col - 1)) {
                    col--;
                } else {
                    System.out.println("Nie można się ruszyć w lewo");
                }
            } else if(input.equals("d")) {
                if (col + 1 < board.COLS && !board.isObstacle(row, col + 1)) {
                    col++;
                } else {
                    System.out.println("Nie można się ruszyć w prawo");
                }
            }
            board.printBoard();
            if (board.board[row][col] == STOP) {
                System.out.println("Reached the stop position!");
                break;
            }
        }
    }
}
