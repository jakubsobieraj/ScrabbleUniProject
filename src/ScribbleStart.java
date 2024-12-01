import java.util.Scanner;

/**
	 * A simple Scrabble game.
	 * @author Jakub Sobieraj
	 * @version 1.0
	 * A public class ScribbleStart containing the main method.
	 */

public class ScribbleStart {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ScribbleStart scribbleStart = new ScribbleStart();
        //initialize to 0
        int menuChoice = 0;
        //running our menu
        menuChoice = scribbleStart.getMenuChoice(menuChoice);
    }

    /* ### MENU ### */
    /**
     * menu for the user.
     * gives 3 choices for the user, and then runs the selected tasks
     * @param menuChoice as the task selected by the user
     */
    public int getMenuChoice(int menuChoice) {

        //scanner to listen for the users input
        Scanner input = new Scanner(System.in);

        //displaying the options to the user
        System.out.println(" ");
        System.out.println("");
        System.out.println("Welcome to Scribble. Enter a number from 1-3 to choose one of the below options:");
        System.out.println("'1' to start a new game");
        System.out.println("'2' to load a saved game");
        System.out.println("'3' to read the rules of the game");

        //assigning the users input to the choice variable
        menuChoice = input.nextInt();
        
        //creating instances of these 2 classes
        GameBoard gameBoard = new GameBoard();
        Game game = new Game(gameBoard);

        //for this switch case, the tasks that are run will depend on the users input.
        switch (menuChoice) {

            case 1:
            	
            	//generates a new board
            	gameBoard.genBoard();

            	//starts the game and passes scanner as @param
                game.startGame(input);

                break;
                
            case 2:
            	//starts a saved game and passes scanner as @param
            	game.startLoadedGame(input);
            	
            	break;
            	
            case 3:
            	
            	System.out.println("1. The player is offered a turn");
            	System.out.println("");
            	System.out.println("2. The player should provide a word that they want to add onto the board.");
            	System.out.println("");
            	System.out.println("3. The player should intimate where on the board the word should be placed, and whether it\n"
            			+ "should be placed vertically or horizontally. They can do this by specifying an [x, y] location\n"
            			+ "on the game board where their word starts or ends.");
            	System.out.println("");
            	System.out.println("4. After their word has been placed onto the board, the points for each letter they have used\n"
            			+ "can be calculated and added to that player’s score");
            	System.out.println("");
            	System.out.println("5. The turn of play can move to the next player.");
            	System.out.println("");
            	System.out.println("Each letter of the alphabet is assigned points based on how frequently it can be used. Some letters\n"
            			+ "(such as Z) are harder to use in words than others (such as A). Table 1 below shows a list of the\n"
            			+ "scores that are associated with each letter in the alphabet.\n"
            			+ "Table 1. Letter Scores\n"
            			+ "Letter(s) Worth (in points)\n"
            			+ "A, E, I, O, U, L, N, S, T, R 1 point\n"
            			+ "D, G 2 points\n"
            			+ "B, C, M, P 3 points\n"
            			+ "F, H, V, W, Y 4 points\n"
            			+ "K 5 points\n"
            			+ "J, X 8 points\n"
            			+ "Q, Z 10 points");
            	
            	//reloops the menu
            	getMenuChoice(menuChoice);;
            	
            	break;
            	
            default:

            	System.out.println("Invalid input. Enter a number from 1-3");
            	//reloops the menu
                getMenuChoice(menuChoice);
                
                
                input.close();
        }

        return menuChoice;
    }
}
