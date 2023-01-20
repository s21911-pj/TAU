package org.example;

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
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || board[row][col] == OBSTACLE || visited[row][col]) {
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
        if (row-1 >= 0) {
            if (move(row-1, col, visited)) {
                return true;
            }
        }

        // Move down
        if (row+1 < ROWS) {
            if (move(row+1, col, visited)) {
                return true;
            }
        }

        // Move left
        if (col-1 >= 0) {
            if (move(row, col-1, visited)) {
                return true;
            }
        }

        // Move right
        if (col+1 < COLS) {
            if (move(row, col+1, visited)) {
                return true;
            }
        }

        return false;
    }
}
/*        // Recursively move to all possible next positions
        if (move(row - 1, col, visited) || move(row + 1, col, visited) || move(row, col - 1, visited) || move(row, col + 1, visited)) {
            return true;
        }

        return false;
    }





}*/

