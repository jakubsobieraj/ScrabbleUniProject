import java.util.Scanner;
/** CLASS
 * 
 * One of public classes words which will deal with scores, entering words and placement of the words
 * 
 */
public class Words {

	private String userWord;
	private int userWordCol;
	private int userWordRow;
	private String userWordDirection;
	private int wordScore;
	
	public Words() {
		
		setUserWord("");
		setUserWordCol(0);
		setUserWordRow(0);
		setUserWordDirection("");

	}
    /* ### METHOD ### */
    /**
     * 
     * This will ask for a word tobe entered
     * 
     */
	public void enterWord() {
		

		System.out.println("To save the game, enter 'save!', to exit the game enter 'exit!'.");
		System.out.println("To continue playing, enter a word to be placed on the board:");
		
	    Scanner n = new Scanner(System.in);

	    setUserWord(n.nextLine());
	    
	    while (getUserWord().length() < 2) {
	    	
			System.out.println("Word needs to be more than 2 letters long.");
			
		    Scanner b = new Scanner(System.in);

		    setUserWord(b.nextLine());
		    
	    }
		
	}
    /* ### METHOD ### */
    /**
     * 
     * This will ask for the x,y coordinates of where to place the board
     * 
     */
	public void enterPlacement() {

		System.out.println("Enter the row on which you want to place your word");

	    Scanner r = new Scanner(System.in);

	    setUserWordRow(r.nextInt());
	    
	    while (getUserWordRow() > 15 || getUserWordRow() < 1) {
	    	
			System.out.println("invalid input. Enter a row from 1 to 15");
			
		    Scanner b = new Scanner(System.in);

		    setUserWordCol(b.nextInt());
	    	
	    }

		System.out.println("Enter the column on which you want to place your word");

	    Scanner c = new Scanner(System.in);

	    setUserWordCol(c.nextInt());

	    while (getUserWordCol() > 15 || getUserWordCol() < 1) {

			System.out.println("invalid input. Enter the column from 1 to 15");

		    Scanner b = new Scanner(System.in);

		    setUserWordCol(b.nextInt());
	    	
	    }

		System.out.println("Enter the direction of your word on the board (left, right, up, down)");

	    Scanner d = new Scanner(System.in);

	    setUserWordDirection(d.nextLine());
	    
	    System.out.println(userWordDirection);
	    
	    while (!(userWordDirection.equals("left") || userWordDirection.equals("right") || userWordDirection.equals("down") || userWordDirection.equals("up"))) {
		   
			System.out.println("Invalid placement. Enter left, right, up, down");

		    Scanner e = new Scanner(System.in);

		    setUserWordDirection(e.nextLine());
		    
		    System.out.println(userWordDirection);
		   
	   }
	    
	}
    /* ### METHOD ### */
    /**
     * 
     * This will calculate the word score depending on the word entered
     * 
     */
	public void calculatePoints() {
		
		wordScore = 0;
		//the entered word by the user is split into a char array
		char[] temp = userWord.toCharArray();

		//the loop runs and checks each array index and searches for character of the word. depending on the letter, appropriate score is added
		for (int i = 0; i < temp.length; i++) {

			if (temp[i] == 'A' || temp[i] == 'E'|| temp[i] == 'I'|| temp[i] == 'O' || temp[i] == 'U'|| temp[i] == 'L'|| temp[i] == 'N'|| temp[i] == 'S'|| temp[i] == 'T'|| temp[i] == 'R') {
				
				wordScore = wordScore + 1;
				
			}
				
			else if (temp[i] == 'D' || temp[i] == 'G') {
					
				wordScore = wordScore + 2;
				
				}
			
			else if (temp[i] == 'B' || temp[i] == 'C' || temp[i] == 'M' || temp[i] == 'P') {
				
				wordScore = wordScore + 3;
				
				}
			
			else if (temp[i] == 'F' || temp[i] == 'H' || temp[i] == 'B' || temp[i] == 'W'|| temp[i] == 'Y') {
				
				wordScore = wordScore + 4;
				
				}
			
			else if (temp[i] == 'K') {
				
				wordScore = wordScore + 5;
				
				}
			
			else if (temp[i] == 'J' || temp[i] == 'X') {
				
				wordScore = wordScore + 8;
				
				}
			
			else if (temp[i] == 'Q' || temp[i] == 'Z') {
				
				wordScore = wordScore + 10;
				
				}
			
			}
		
		System.out.println("Total score for this word: " + wordScore);
		
	}
    /* ### GET/SET METHOD(S) ### */
    /**
     * 
     * for getting words, placement and score
     * 
     */
	public String getUserWord() {
		return userWord;
	}

	public void setUserWord(String userWord) {
		this.userWord = userWord.toUpperCase();
	}
	
	
	public int getUserWordCol() {
		return userWordCol;
	}

	public void setUserWordCol(int userWordCol) {
		this.userWordCol = userWordCol;
	}
	
	public int getUserWordRow() {
		return userWordRow;
	}

	public void setUserWordRow(int userWordRow) {
		this.userWordRow = userWordRow;
	}
	
	public String getUserWordDirection() {
		return userWordDirection;
	}

	public void setUserWordDirection(String userWordDirection) {
		this.userWordDirection = userWordDirection.toLowerCase();
	}
	
	public int getWordScore() {
		return wordScore;
	}
	
}
