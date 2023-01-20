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
