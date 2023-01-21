
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Board {


    public int ROWS = 5;
    public int COLS = 5;
    public char START = 'A';
    public char STOP = 'B';
    public char OBSTACLE = 'X';
    public char[][] board;
    public Random rand;

    public Board() {
        board = new char[ROWS][COLS];
        rand = new Random();
        initializeBoard();
    }

    public void initializeBoard() {
        // Set all fields to empty
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = ' ';
            }
        }

        // Randomly choose start and stop positions
        int startRow = rand.nextInt(ROWS);
        int startCol = rand.nextInt(COLS);
        int stopRow = rand.nextInt(ROWS);
        int stopCol = rand.nextInt(COLS);

        // Make sure start and stop are not next to each other
        while (Math.abs(startRow - stopRow) <= 1 && Math.abs(startCol - stopCol) <= 1) {
            stopRow = rand.nextInt(ROWS);
            stopCol = rand.nextInt(COLS);
        }

        // Place start and stop on board
        board[startRow][startCol] = START;
        board[stopRow][stopCol] = STOP;

        // Randomly place obstacles on board
        int obstacleCount = rand.nextInt(ROWS * COLS / 2);
        for (int i = 0; i < obstacleCount; i++) {
            int obstacleRow = rand.nextInt(ROWS);
            int obstacleCol = rand.nextInt(COLS);

            // Make sure obstacle is not placed on start or stop
            while (board[obstacleRow][obstacleCol] != ' ') {
                obstacleRow = rand.nextInt(ROWS);
                obstacleCol = rand.nextInt(COLS);
            }

            board[obstacleRow][obstacleCol] = OBSTACLE;
        }
    }

    public boolean isObstacle(int row, int col) {
        return board[row][col] == OBSTACLE;
    }


    public void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean move(int row, int col, boolean[][] visited) {
        // Check if current position is out of bounds or an obstacle
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || visited[row][col]) {
            return false;
        }

        // Check if current position is an obstacle
        if (board[row][col] == OBSTACLE) {
            return false;
        }

        // Check if current position is the stop position
        if (board[row][col] == STOP) {
            System.out.println("Reached the stop position!");
            return true;
        }

        // Mark current position as visited
        visited[row][col] = true;

        // Move up
        if (row - 1 >= 0) {
            if (move(row - 1, col, visited)) {
                return true;
            }
        }

        // Move down
        if (row + 1 < ROWS) {
            if (move(row + 1, col, visited)) {
                return true;
            }
        }

        // Move left
        if (col - 1 >= 0) {
            if (move(row, col - 1, visited)) {
                return true;
            }
        }

        // Move right
        if (col + 1 < COLS) {
            if (move(row, col + 1, visited)) {
                return true;
            }
        }

        return false;
    }

    public void moveWithKeyboardInput() {
        int currentRow = 0;
        int currentCol = 0;
        boolean[][] visited = new boolean[ROWS][COLS];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Find starting position
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == START) {
                    currentRow = row;
                    currentCol = col;
                    break;
                }
            }
        }

        while (true) {
            printBoard();
            System.out.println("You are currently at position (" + currentRow + ", " + currentCol + ").");
            System.out.println("Enter W to move up, S to move down, A to move left, D to move right, or Q to quit.");
            String input;
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            if (input.equals("W")) {
                if (currentRow - 1 >= 0 && !isObstacle(currentRow - 1, currentCol)) {
                    currentRow--;
                } else {
                    System.out.println("Cannot move up.");
                }
            } else if (input.equals("S")) {
                if (currentRow + 1 < ROWS && !isObstacle(currentRow + 1, currentCol)) {
                    currentRow++;
                } else {
                    System.out.println("Cannot move down.");
                }
            } else if (input.equals("A")) {
                if (currentCol - 1 >= 0 && !isObstacle(currentRow, currentCol - 1)) {
                    currentCol--;
                } else {
                    System.out.println("Cannot move left.");
                }
            } else if (input.equals("D")) {
                if (currentCol + 1 < COLS && !isObstacle(currentRow, currentCol + 1)) {
                    currentCol++;
                } else {
                    System.out.println("Cannot move right.");
                }
            } else if (input.equals("Q")) {
                System.out.println("Quitting...");
                return;
            } else {
                System.out.println("Invalid input. Try again.");
            }

            visited[currentRow][currentCol] = true;
            if (board[currentRow][currentCol] == STOP) {
                System.out.println("Reached the stop position!");
                return;
            }
        }
    }


}
