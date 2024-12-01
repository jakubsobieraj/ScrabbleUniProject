import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	
	Words words = new Words();
	GameBoard board = new GameBoard();
	Players players = new Players();
	String player1 = "";
	String player2 = "";
	int player1score = 0;
	int player2score = 0;
	boolean game = true;
	boolean firstMove = true;
	String userWord = "";
	String direction = "";
	int row = 0;
	int col = 0;
	int lastTile = 0;
	int turnCounter = 0;
	char[] temp;
	private GameBoard gameBoard;
	boolean validWord = false;
	
	public Game(GameBoard gameBoard) {
		
		this.gameBoard = gameBoard;
		
	}
	
    /* ### METHOD ### */
    /**
     * 
     * This will run when a new game is started
     * @param scanner passes the scanner, used in early stage to deal with exception errors "elementexceptions"
     */
	public void startGame(Scanner scanner) {
		
		players.createPlayers();
		
		player1 = players.getPlayer1();
		player2 = players.getPlayer2();
		
		System.out.println("Player 1 name is is: " + player1);
		System.out.println("Player 2 name is is: " + player2);
		System.out.println(player1 + "'s current score is: " + player1score);
		System.out.println(player2 + "'s current score is: " + player2score);
		
		//the game runs until score 100 is reached by either player
		while (game == true && player1score < 100 && player2score < 100) {
			
		board.showBoard();
		//this loop acts as a turn counter. if the number is even, players1 turn. after each turn counter +1, so will be odd, therefore switching turns 
		if ((turnCounter % 2) == 0) {
			
			System.out.println(player1 + "'s turn!");
			
			placeWord();
			
			player1score = player1score + words.getWordScore();
			
			turnCounter++;
			
			} else {
				
			System.out.println(player2 + "'s turn!");
			
			placeWord();
			
			player2score = player2score + words.getWordScore();
			
			turnCounter++;
			
			}
		
		System.out.println(player1 + "'s current score is: " + player1score);
		System.out.println(player2 + "'s current score is: " + player2score);
		
		}
		//runs when score 100 is reached by either player
		if (player1score >= 100) {
			
			System.out.println(player1 + "'s the winner. Congratulations.");
			
		} else if (player2score >= 100) {
			
			System.out.println(player2 + "'s the winner. Congratulations.");
			
		}
		
	}
    /* ### METHOD ### */
    /**
     * 
     * This will run when a loaded game when started
     * @param scanner passes the scanner, used in early stage to deal with exception errors with elementexceptions
     */
	public void startLoadedGame(Scanner scanner) {
		//instance of load
    	Load load = new Load();
    	//loads the names first
    	load.loadNames();
    	//assigns loaded values
		player1 = load.getPlayer1();
		player2 = load.getPlayer2();
		player1score = load.getPlayer1score();
		player2score = load.getPlayer2score();
		//loads the board into this temp array and assigns to the current gameboard
		char[][] loadedBoard = load.getLoadedBoard();
		board.setGameBoard(loadedBoard);
		
		System.out.println("Player 1 name is is: " + player1);
		System.out.println("Player 2 name is is: " + player2);
		System.out.println(player1 + "'s current score is: " + player1score);
		System.out.println(player2 + "'s current score is: " + player2score);
		
		board.loadBoard();
		//sets first move to false as the game has probably already started
		firstMove = false;
		//the game runs until score 100 is reached by either player
		while (game == true && player1score < 100 && player2score < 100) {
			
		board.showBoard();
		//this loop acts as a turn counter. if the number is even, players1 turn. after each turn counter +1, so will be odd, therefore switching turns 
		if ((turnCounter % 2) == 0) {
			
			System.out.println(player1 + "'s turn!");
			
			placeWord();
			
			player1score = player1score + words.getWordScore();
			
			turnCounter++;
			
			} else {
				
			System.out.println(player2 + "'s turn!");
			
			placeWord();
			
			player2score = player2score + words.getWordScore();
			
			turnCounter++;
			
			}
		
		System.out.println(player1 + "'s current score is: " + player1score);
		System.out.println(player2 + "'s current score is: " + player2score);
		
		}
		//runs when score 100 is reached by either player
		if (player1score >= 100) {
			
			System.out.println(player1 + "'s the winner. Congratulations.");
			
		} else if (player2score >= 100) {
			
			System.out.println(player2 + "'s the winner. Congratulations.");
			
		}
		
	}
    /* ### METHOD ### */
    /**
     * 
     * This is the method where word is entered and most of validation checks are done
     * 
     */
	public void placeWord() {
		//initially, word is invalid before checking it in the dictionary
		validWord = false;

		words.enterWord();
		
		userWord = words.getUserWord();
		//word is passed into the dictionary method to be validated
		dictionary(userWord);
		//starts the save process
	    if (userWord.equals("save!".toUpperCase())) {
	    	
	    	Save save = new Save();

            save.savePlayers(this);

            save.saveBoard(board);

	    	System.exit(0);
	    	//starts if exit! is entered
	    } else if (userWord.equals("exit!".toUpperCase())) {
	    	
	    	System.exit(0);
	    	
	    }
	    //if dictionary check fails, program keeps asking for a word until it will be valid.
	    while (!validWord) {
	    	
	    	System.out.println("Word is not in dictionary. Enter a valid word.");
	    	
			words.enterWord();
			
			userWord = words.getUserWord();
			
			dictionary(userWord);
	    	
	    }
		//then asks for x,y coordinates and direction of the turn
		words.enterPlacement();

		row = words.getUserWordRow();
		col = words.getUserWordCol();
		
		direction = words.getUserWordDirection();
		
		char[] temp = userWord.toCharArray();

		System.out.println("Current move details:");
		System.out.println("Word entered: " +userWord);
		System.out.println("Starting row: " + row + " and starting column: " + col);
		System.out.println("Direction this turn: " + direction);
		//runs when move isn't the first and word placed isn't touching first or last letter 
		if(!firstMove && !validateNextWord()) {
			
			while(!validateNextWord()) {
				
				board.showBoard();
				
				System.out.println("Invalid placement. Try again.");
				words.enterWord();
				
				userWord = words.getUserWord();
				
				words.enterPlacement();

				row = words.getUserWordRow();
				col = words.getUserWordCol();
				
				direction = words.getUserWordDirection();
				
				temp = userWord.toCharArray();
			}
			
		}
		
		validateFall();

		validateCenter(direction, col, row, temp.length);
		//this only runs when move is the first, to validate if word is in the center.. runs until valid placement is entered
		while (firstMove) {
			
			board.showBoard();
			
			System.out.println("Word does not pass the centre of the board. Try again");
			
			words.enterWord();
			
			userWord = words.getUserWord();
			
			words.enterPlacement();

			row = words.getUserWordRow();
			col = words.getUserWordCol();
			
			direction = words.getUserWordDirection();
			
			temp = userWord.toCharArray();
			
			validateCenter(direction, col, row, temp.length);
			
		}
		
		words.calculatePoints();
		//this switch case calculates which direction to place the word on the board
		switch (direction) {
		//WORD GOING RIGHT
			case "right":
				
	        for (int i = 0; i < temp.length; i++) {
	        	
	        	 board.getGameBoard()[row - 1][col - 1] = temp[i];
	        	  
	        	 col++;
	        	 
	        	}
	        break;
        //WORD GOING LEFT
			case "left":

        	for (int i = 0; i < temp.length; i++) {

        		board.getGameBoard()[row - 1][col - 1] = temp[i];
       	  
        		col--;
         
        	}
        	break;
        //WORD GOING DOWN
			case "down":

        	for (int i = 0; i < temp.length; i++) {

        		board.getGameBoard()[row - 1][col - 1] = temp[i];
       	 
        		row++;
         
        	}
        	break;
        
        //WORD GOING DOWN
		case "up":

        	for (int i = 0; i < temp.length; i++) {
        	
        		board.getGameBoard()[row - 1][col - 1] = temp[i];
       	  
        		row--;
         
        	}
        	break;
        	
        	default: 
        		
        		System.out.println("Invalid direction. Try again");
        		
        }

	}
    /* ### METHOD ### */
    /**
     * 
     * This will check if the word will not fall of the board when entered. e.g., ending at column 20 when board is only 15x15
     * 
     */
	public void validateFall() {
		//invalid until checked if it is correct
	    boolean validPlacement = false;

	    while (!validPlacement) {
	        //this switch case checks the placement for each direction for the fall
	        switch (direction.toLowerCase()) {
	            case "right":
	                lastTile = col + userWord.length() - 1; 
	                if (lastTile <= 15) {
	                    validPlacement = true;
	                } else {
	                    System.out.println("Word falls off to the right. Try again.");
	                }
	                break;

	            case "left":
	                lastTile = col - userWord.length() + 1; 
	                if (lastTile >= 1) {
	                    validPlacement = true;
	                } else {
	                    System.out.println("Word falls off to the left. Try again.");
	                }
	                break;

	            case "down":
	                lastTile = row + userWord.length() - 1;
	                if (lastTile <= 15) {
	                    validPlacement = true;
	                } else {
	                    System.out.println("Word falls off the bottom. Try again.");
	                }
	                break;

	            case "up":
	                lastTile = row - userWord.length() + 1; 
	                if (lastTile >= 1) {
	                    validPlacement = true;
	                } else {
	                    System.out.println("Word falls off the top. Try again.");
	                }
	                break;

	            default:
	                System.out.println("Invalid direction. Valid directions are 'right', 'left', 'down', 'up'. Try again.");
	                break;
	        }

	        // If placement is not valid, prompt user for another input
	        if (!validPlacement) {
	        	
	            board.showBoard();
	            
	            System.out.println("Invalid placement. Enter your word again:");
	            
	            words.enterWord();
	            
	            userWord = words.getUserWord();
	            
	            System.out.println("Enter placement details again:");
	            
	            words.enterPlacement();
	            
	            row = words.getUserWordRow();
	            
	            col = words.getUserWordCol();
	            
	            direction = words.getUserWordDirection();
	            
				temp = userWord.toCharArray();
	        }
	    }
	}
    /* ### METHOD ### */
    /**
     * validateCenter
     * validates if the first word passes through the 8x8 tile
     * @parama gets the direction of the word, as each direction needs different calculations
     * @paramb gets the entered word column
     * @paramc gets the entered word row
     * @paramd gets the length of the users word
     */
	public boolean validateCenter(String direction, int col, int row, int word_length) {
		//set to 8 as it is the middle of the board
		int board_center = 8;
		//for each direction, checks if the users row/col passes the middle, checks if the word is long enough to pass through the centre
		//if it doesn't start there, then sets firstmove to false so this is never ran again
        if (direction.equalsIgnoreCase("right")) {
            return 
            row == board_center &&
            (board_center - col <= word_length - 1) && (col <= board_center) && (firstMove = false);
            
        }
        if (direction.equalsIgnoreCase("left")) {
            return 
            row == board_center &&
            (col - board_center <= word_length - 1) && (col >= board_center) && (firstMove = false);
        }
        
        if (direction.equalsIgnoreCase("down")) {
            return 
            col == board_center &&	
            (board_center - row <= word_length - 1) && (row <= board_center) && (firstMove = false);
        }
        
        if (direction.equalsIgnoreCase("up")) {
            return 
            col == board_center &&		
            (row - board_center <= word_length - 1) && (row >= board_center) && (firstMove = false);
        }
        return false;

    }
    /* ### METHOD ### */
    /**
     * 
     * validates if words first/last letter touch the letters on the board
     * 
     */
	public boolean validateNextWord() {
		//false until validated
		boolean match = false;
		char[] tempArr = userWord.toCharArray();
		//for each direction, checks if the first and last character of the words match
		switch (direction.toLowerCase()) {
		
			case "right":
				
				if(board.getGameBoard()[row -1][col -1] == tempArr[0] || 
				board.getGameBoard()[row -1][col -1 + (tempArr.length - 1)] == tempArr[tempArr.length - 1]) {
					
				match=true;

			}
			
			break;
			
		case "left":

				if(board.getGameBoard()[row -1][col -1] == tempArr[0] || 
				board.getGameBoard()[row -1][col -1 - (tempArr.length - 1)] == tempArr[tempArr.length - 1]) {
					
				match=true;
					
				}
			
			break;
			
		case "up":

				if(board.getGameBoard()[row -1][col -1] == tempArr[0] || 
				board.getGameBoard()[row -1 - (tempArr.length - 1)][col -1 ] == tempArr[tempArr.length - 1]) {
					
					match=true;
					
				}
				
				break;
			
		case "down":

			if(board.getGameBoard()[row -1][col -1] == tempArr[0] || 
			board.getGameBoard()[row -1 + (tempArr.length - 1)][col -1 ] == tempArr[tempArr.length - 1]) {
					
					match=true;
				
				}
			
			break;
			
			default:
				System.out.println("Invalid direction. Enter your direction again (left, right, up, down):");
				
				return false;
		}
		
		if (!match) {
			System.out.println("Entered word does not overlap any words that are currently on the board. Try again ");
			return false;
		}
		
		return true;
	}
    /* ### METHOD ### */
    /**
     * 
     * validates if words first/last letter touch the letters on the board
     * @param passes the users word to be checked against the dictionary
     */
	public boolean dictionary(String userWord) {
		//reads this text file that acts as the dictionary.
		File file = new File ("words.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			String line;
			//runs through the whole text file line by line
			while ((line = br.readLine()) != null) {
				//and checks if the users word is in the text file
				if (line.equalsIgnoreCase(userWord)) {
					validWord = true;
					break;
				}
				
			}
			
		} catch (IOException e) {
			
			System.out.println("Sorry, error");
		}
	
		return validWord;
	}
    /* ### GET/SET METHOD(S) ### */
    /**
     * 
     * for getting players and board
     * 
     */
	public String getPlayer1() {
		
		return player1;
	}
	
	public int getPlayer1Score() {
		
		return player1score;
	}
	
	public String getPlayer2() {
		
		return player2;
	}
	
	public int getPlayer2Score() {
		
		return player2score;
	}
	
	
	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	

		
	}

