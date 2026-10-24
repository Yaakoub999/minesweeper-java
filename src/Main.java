import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int request=0;

        while(request!=2){
            System.out.print("Enter 1 to play or 2 to exit: ");
            request = scanner.nextInt();
        
       
        if (request == 2) {
            System.out.println("Exiting...");
            scanner.close();
            return;
        }
        if (request == 1) {
            System.out.println("Starting the game...");
            
        }
        else{
            System.out.println("invalid input please enter 1 or 2");
            continue;
            
        }
    
        
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        Board board = new Board(rows, cols);
        board.makeBoard();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board.checkNeighbors(i, j);

            }
        }

        while (!board.isGameOver()) {
              if(board.minesplanted!=0){
            board.checkWinCondition();
        }
            board.printBoard();

            if (board.isGameOver()) {
                break;
            }

            System.out.print("Enter the row and column to reveal or flag (e.g. 1 2): ");
            if (!scanner.hasNextInt()) {
    System.out.println("Enter a valid number.");
    scanner.next();
    continue;
}
int row = scanner.nextInt();

if (!scanner.hasNextInt()) {
    System.out.println("Enter a valid number.");
    scanner.next();
    continue;
}
int col = scanner.nextInt();
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Invalid coordinates. Try again.");
             continue;
            }
            System.out.print("Enter 'R or r' to reveal or 'F or f' to flag: ");
            String action = scanner.next();
            
            
        
        
            if (action.equals("R") || action.equals("r")) {
                if(board.minesplanted==0){
                    board.makeMines();
                    if(board.getCell(row, col).hasMine()){
                       board.getCell(row, col).makeSafe(); 
                       board.minesplanted--;
                    }
                    for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board.checkNeighbors(i, j);
                }
            }
        }
                board.recursiveReveal(row, col);
            
        }
             else if (action.equals("F") || action.equals("f")) {
                board.toggleFlag(row, col);
            }
            else {
    System.out.println("Invalid action. Enter R or F.");
            }
        }

        
    }
    scanner.close();
}

}         