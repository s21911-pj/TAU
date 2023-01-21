<<<<<<< HEAD
import org.example.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    Board board;

    @Before
    public void setUp() {

        board = new Board();
        board.board[3][3] = board.OBSTACLE;

    }


    @Test
    public void testMoveUp() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[0][2] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }

    @Test
    public void testMoveDown() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][2] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }

    @Test
    public void testMoveLeft() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[2][0] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }

    @Test
    public void testMoveRight() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[2][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }
    @Test
    public void testMoveOutOfBoundsTop() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(-1, 2, visited)); // Try to move above the top edge
    }

    @Test
    public void testMoveOutOfBoundsBottom() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(board.ROWS, 2, visited)); // Try to move below the bottom edge
    }

    @Test
    public void testMoveOutOfBoundsLeft() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(2, -1, visited)); // Try to move left of the left edge
    }

    @Test
    public void testMoveOutOfBoundsRight() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(2, board.COLS, visited)); // Try to move right of the right edge
    }


    @Test
    public void testIsObstacle() {

        board.board[3][3] = board.OBSTACLE;
        assertTrue(board.isObstacle(3, 3));
        /*assertFalse(board.isObstacle(0, 0));*/
    }


    @Test
    public void testMoveOffBoard() {

        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(-1, -1, visited)); // Try to move off the board
        assertFalse(board.move(board.ROWS, board.COLS, visited)); // Try to move off the board
    }
    @Test
    public void testMoveOutOfBounds() {

        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(-1, 0, visited)); // Check moving up out of bounds
        assertFalse(board.move(board.ROWS, 0, visited)); // Check moving down out of bounds
        assertFalse(board.move(0, -1, visited)); // Check moving left out of bounds
        assertFalse(board.move(0, board.COLS, visited)); // Check moving right out of bounds
    }


    @Test
    public void testMoveWithObstacle() {
        int obstacleRow = -1, obstacleCol = -1;
        // Find the obstacle
        outerloop:
        for (int row = 0; row < board.ROWS; row++) {
            for (int col = 0; col < board.COLS; col++) {
                if (board.isObstacle(row, col)) {
                    obstacleRow = row;
                    obstacleCol = col;
                    break outerloop;
                }
            }
        }
        // Make sure an obstacle was found
        assertNotEquals(-1, obstacleRow);
        assertNotEquals(-1, obstacleCol);

        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        // Check if it's possible to move to obstacle
        assertFalse(board.move(obstacleRow, obstacleCol, visited));
    }


}
=======
import org.example.Board;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void testMoveUp() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[0][2] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }

    @Test
    public void testMoveDown() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][2] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }

    @Test
    public void testMoveLeft() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[2][0] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }

    @Test
    public void testMoveRight() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[2][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertTrue(board.move(2, 2, visited));
    }
    @Test
    public void testMoveOutOfBoundsTop() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(-1, 2, visited)); // Try to move above the top edge
    }

    @Test
    public void testMoveOutOfBoundsBottom() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(board.ROWS, 2, visited)); // Try to move below the bottom edge
    }

    @Test
    public void testMoveOutOfBoundsLeft() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(2, -1, visited)); // Try to move left of the left edge
    }

    @Test
    public void testMoveOutOfBoundsRight() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        assertFalse(board.move(2, board.COLS, visited)); // Try to move right of the right edge
    }
    @Test
    public void testIsObstacle() {
        Board board = new Board();
        board.board[3][3] = board.OBSTACLE;
        assertTrue(board.isObstacle(3, 3));
        assertFalse(board.isObstacle(0, 0));
    }




/*    @Test
    public void testMoveNoPath() {
        Board board = new Board();
        board.board[2][2] = board.START; // Set fixed start position
        board.board[4][4] = board.STOP; // Set fixed stop position
        board.board[3][3] = board.OBSTACLE; // Add obstacle
        boolean[][] visited = new boolean[board.ROWS][board.COLS];
        boolean result = board.move(2, 2, visited);
        assertFalse(result);
    }*/

}
>>>>>>> 9cb6bf464491773d9b58566633cb64305ac93b03
