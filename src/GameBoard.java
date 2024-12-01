import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {

	public char[][] gameBoard;
	private int[] rows = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private int[] cols = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	
	
	public GameBoard() {
		
		this.genBoard();
		
	}
	
    /* ### METHOD ### */
    /**
     * 
     * This will generate a board for the players to play on, if a new game is started
     * 
     */
	public void genBoard() {
		
		//this will be a 15x15 char 2d array
		this.setGameBoard(new char[15][15]);
		
        for (int i = 0; i < 15; i++) {
          for (int k = 0; k < 15; k++) {
        	  
        	  //each array element is filed with '-0', except + which marks the middle of the board
        	  this.getGameBoard()[i][k] = '-';
        	  this.getGameBoard()[7][7] = '+';

          }
          
        }
        
	}
    /* ### METHOD ### */
    /**
     * 
     * This will load a previously saved game
     * 
     */
	public void loadBoard() {
		//new instance of load
		Load load = new Load();

		//loads the game from board.txt
        load.loadBoard("board.txt");
        
        //assigns the loaded board to the current gameboard.
        this.gameBoard = load.getLoadedBoard();
        
         }
    /* ### METHOD ### */
    /**
     * 
     * This will print out the current board to the console
     * 
     */
       public void showBoard() {

        //layout for the board
        System.out.println("---------------------------------------------------------------");
        System.out.println("Scribble:");
        System.out.println("---------------------------------------------------------------");
        
        for (int i = 0; i < 1; i++) {
            System.out.printf("%-5s", " "); // Print the row
            for (int k = 0; k < 15; k++) {	
                // print every character on the game board 
                System.out.printf("%-5s", cols[k]);
            }
            System.out.println(); // Move to the next line after printing a row
            
        }
        

        for (int i = 0; i < 15; i++) {
        	System.out.printf("%-5d", rows[i]);
            for (int k = 0; k < 15; k++) {	
                // print every character on the game board 
                System.out.printf("%-5s", getGameBoard()[i][k]);
            }
            System.out.println(); // Move to the next line after printing a row
            
        }

	}

       /* ### GET/SET METHOD(S) ### */
       /**
        * 
        * for getting the gameboard
        * 
        */
	public char[][] getGameBoard() {
		return gameBoard;
	}

    /**
     * Set the gameboard
     * 
     * @param gameboard 2d array
     */
	public void setGameBoard(char[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	
}
