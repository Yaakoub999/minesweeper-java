public class Cell {
    private boolean revealed;
    private boolean flagged;
    private boolean hasMine;
    private int neighboringMines;

    public Cell() {
        this.revealed = false;
        this.flagged = false;
        this.hasMine = false;
        this.neighboringMines = 0;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void reveal() {
        if (this.revealed) {
            return;
        }

        if (this.flagged) {
            return;
        }

        this.revealed = true;
    }

    public void toggleFlag() {
        if (this.revealed) {
            return;
        }

        if (this.flagged) {
            this.flagged = false;
        } else {
            this.flagged = true;
        }
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public void setMine() {
        this.hasMine = true;
    }

    public int getNeighboringMines() {
        return neighboringMines;
    }

    public void setNumber(int mines) {
        this.neighboringMines = mines;
    }
    public void makeSafe(){
        this.hasMine=false;
    }
}