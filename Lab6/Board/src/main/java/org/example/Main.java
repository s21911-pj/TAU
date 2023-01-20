package org.example;
import java.util.Random;

public class Main {
    private static final int ROWS = 5;
    private static final int COLS = 5;


    public static void main(String[] args) {

        Board board = new Board();
        int startRow = 0;
        int startCol = 0;
        int stopRow = 0;
        int stopCol = 0;
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        final char START = 'A';
        final char STOP = 'B';

        // find start position
        for (int i = 0; i < board.ROWS; i++) {
            for (int j = 0; j < board.COLS; j++) {
                if(board.board[i][j] == START) {
                    startRow = i;
                    startCol = j;
                }
                else if(board.board[i][j] == STOP) {
                    stopRow = i;
                    stopCol = j;
                }
            }
        }
        board.printBoard();
        System.out.println(board.move(startRow, startCol, visited));



    }
}


