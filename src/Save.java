import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/** CLASS
 * 
 * One of public classes save which will save current state of the game to a text file
 * 
 */
public class Save {
    /* ### METHOD ### */
    /**
     * savePlayers will save the info of the current players
     * 
     * 
     * @parama is an instance of game passed into the method so it can read the values in
     */
        public void savePlayers(Game game) {
            FileOutputStream outputStream = null;
            PrintWriter printWriter = null;
            
            try {
                outputStream = new FileOutputStream("players.txt");
                printWriter = new PrintWriter(outputStream);
                //saves the values in separate lines in the text file
                        printWriter.print(game.getPlayer1() + "\n");
                        printWriter.print(game.getPlayer1Score() + "\n");
                        printWriter.print(game.getPlayer2() + "\n");
                        printWriter.print(game.getPlayer2Score() + "\n");
 
            } catch (IOException e) {
                System.out.println("Error opening or writing to the file");
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }

            }

            System.out.println("File saved to: players.txt");
        }
        /* ### METHOD ### */
        /**
         * saveBoard will save the info of the current board values
         * 
         * @parama boardName is the name of the board to be saved to
         * @paramb is an instance of board passed into the method so it can read the values in
         */
        public void saveBoard(GameBoard board) {
            FileOutputStream outputStream = null;
            PrintWriter printWriter = null;
            
            try {
                outputStream = new FileOutputStream("board.txt");
                printWriter = new PrintWriter(outputStream);
                
                for (int i = 0; i < 15; i++) {
                    for (int k = 0; k < 15; k++) {
                    	
                        printWriter.print(board.getGameBoard()[i][k]);
                        if (k == 14) {
                            printWriter.print("\n");
                        }
                    }
                    
                  }

            } catch (IOException e) {
                System.out.println("Error opening or writing to the file");
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }

            }

            System.out.println("File saved to: board.txt");
        }
        
        
	
}
