import java.util.Scanner;
/** CLASS
 * 
 * One of public classes players which will handle creation of player names
 * 
 */
public class Players {
	
	String player1 = "";
	String player2 = "";
	int player1score = 0;
	int player2score = 0;

	public Players() {
		
    }
    /* ### METHOD ### */
    /**
     * 
     * Creating the players by asking user for player names.
     * 
     */
	public void createPlayers() {
		
	    // ask the user to enter first players name
		System.out.println("Enter the name of the first player:");
		
	    // create a Scanner object ready to read information from the user
	    Scanner n = new Scanner(System.in);

	    // read in the name from the user using the Scanner
	    player1 = (n.nextLine());

	    // ask the user to enter second players name
		System.out.println("Enter the name of the second player:");
		
	    // create a Scanner object ready to read information from the user
	    Scanner p = new Scanner(System.in);

	    // read in the name from the user using the Scanner
	    player2 = (n.nextLine());
		
	}
    /* ### GET/SET METHOD(S) ### */
    /**
     * 
     * for getting and setting players
     * 
     */
	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	
	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
	
}
