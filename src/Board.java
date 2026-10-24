import java.util.Random;

public class Board {
    private int rows;
    private int cols;
    private Cell[][] board;
    private Random random = new Random();
    private int mines;
    private boolean gameOver;
    public int minesplanted = 0;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Cell[rows][cols];
        this.mines = (int) (rows * cols * 0.15);
        this.gameOver = false;
    }

    public void makeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void makeMines() {
        for (int i = 0; i < mines; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (board[row][col].hasMine()) {
                i--;
            } else {
                board[row][col].setMine();
                minesplanted++;
            }
        }
    }

    public int checkNeighbors(int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {

                if (i < 0 || i >= rows || j < 0 || j >= cols) {
                    continue;
                }

                if (i == row && j == col) {
                    continue;
                }

                if (board[i][j].hasMine()) {
                    count++;
                }
            }
        }

        board[row][col].setNumber(count);
        return count;
    }

    public void printBoard() {
        // Column numbers
        System.out.print("    ");

        for (int j = 0; j < cols; j++) {
            System.out.print(" " + j + "  ");
        }

        System.out.println();

        // Top separator
        System.out.print("    ");

        for (int j = 0; j < cols; j++) {
            System.out.print("+---");
        }

        System.out.println("+");

        // Rows
        for (int i = 0; i < rows; i++) {

            System.out.print(" " + i + "  ");

            for (int j = 0; j < cols; j++) {

                if (board[i][j].isFlagged()) {
                    System.out.print("| F ");
                } else if (!board[i][j].isRevealed()) {
                    System.out.print("|   ");
                } else if (board[i][j].hasMine()) {
                    System.out.print("| * ");
                } else {
                    System.out.print("| " + board[i][j].getNeighboringMines() + " ");
                }
            }

            System.out.println("|");

            // Separator
            System.out.print("    ");

            for (int j = 0; j < cols; j++) {
                System.out.print("+---");
            }

            System.out.println("+");
        }
    }

    public void toggleFlag(int row, int col) {
        board[row][col].toggleFlag();
    }

    public void reveal(int row, int col) {
        board[row][col].reveal();
    }

    public void recursiveReveal(int row, int col) {
        if (board[row][col].isRevealed() || board[row][col].isFlagged()) {
            return;
        }

        reveal(row, col);

        if (board[row][col].hasMine()) {
            System.out.println(
                "Game Over! You hit a mine at (" + row + ", " + col + ")."
            );
            gameOver = true;
            return;
        }

        int count = checkNeighbors(row, col);

        if (count == 0) {
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {

                    if (i < 0 || i >= rows || j < 0 || j >= cols) {
                        continue;
                    }

                    if (i == row && j == col) {
                        continue;
                    }

                    recursiveReveal(i, j);
                }
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void checkWinCondition() {
        int minesFound = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j].hasMine() && board[i][j].isFlagged()) {
                    minesFound++;
                }
            }
        }

        if (minesFound == minesplanted) {
            System.out.println("Congrats! You found the mines!");
            gameOver = true;
        }
    }
    public Cell getCell(int row, int col) {
        return board[row][col];
    }
}