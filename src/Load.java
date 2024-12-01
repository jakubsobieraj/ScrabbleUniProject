import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/** CLASS
 * 
 * One of public classes load which will handle loading the game from a text file
 * 
 */

public class Load {
	
	GameBoard board = new GameBoard();
	
	String player1Name;
	String player2Name;
	int player1score;
	int player2score;
	private char[][] loadedBoard;
    /* ### METHOD ### */
    /**
     * 
     * This will load the board from an entered text file
     * @param fileName that will be the name of the board
     */
    public void loadBoard(String fileName) {
    	
        int i = 0;
        //creates a temporary board
        loadedBoard = new char[15][15];
        
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
        	
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            
            for(String nextLine = bufferedReader.readLine(); nextLine != null && i < 15; nextLine = bufferedReader.readLine()) {
            	//each line in the text file is split into separate characters
                String[] temp = nextLine.split("");

                for(int j = 0; j < 15; ++j) {
                	//each character is assigned into this board
                	loadedBoard[i][j] = temp[j].charAt(0);
                }

                ++i;
            }

            System.out.println("File loaded.");
            
        } catch (IOException e) {
            System.out.println("Error opening or reading from the file");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file");
                }
            }

        }
        
    }
    /* ### METHOD ### */
    /**
     * 
     * This will load the names. board and players are separate to make this process easier
     * 
     */
    public void loadNames() {
    	
    	try (BufferedReader reader = new BufferedReader(new FileReader("players.txt"))) {
           
            player1Name = reader.readLine().trim(); 

            player1score = Integer.parseInt(reader.readLine().trim());

            player2Name = reader.readLine().trim(); 
            player2score = Integer.parseInt(reader.readLine().trim()); 
            
        	System.out.println(player1Name);
        	System.out.println(player1score);
        	System.out.println(player2Name);
        	System.out.println(player2score);
            

        } catch (IOException e) {
        	
            System.out.println("Error reading file: " + e.getMessage());

        } 

    }
    /* ### GET/SET METHOD(S) ### */
    /**
     * 
     * for getting players and boards
     * 
     */
	public String getPlayer1() {
		return player1Name;
	}

	public void setPlayer1(String player1Name) {
		this.player1Name = player1Name;
	}
	
	public String getPlayer2() {
		return player2Name;
	}

	public void setPlayer2(String player2Name) {
		this.player2Name = player2Name;
	}
	
	public int getPlayer1score() {
		return player1score;
	}
	
	public int getPlayer2score() {
		return player2score;
	}
	
	public void setPlayer1score(int player1score) {
		this.player1score = player1score;
	}
    
	public void setPlayer2score(int player2score) {
		this.player2score = player2score;
	}
	
	
	public char[][] getLoadedBoard() {
		return loadedBoard;
	}
	
	public void setLoadedBoard(char[][] loadedBoard) {
		this.loadedBoard = loadedBoard;
	}



}
