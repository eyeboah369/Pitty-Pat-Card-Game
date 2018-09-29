import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays; 

public class pittyPat {
	
	public static void main (String[] args) {
		//Statements to introduce user to game.
		System.out.println("Welcome to Pitty Pat!\n");	
		System.out.println("Are you ready to begin?(y/n)");
		
		//Stores the user input to start the game.
		Scanner input     = new Scanner(System.in);
		String begin      = input.nextLine();
				
		//Calls method to create 52 card deck for use in game.
		if (begin.equals("y")) {
			priorCreateDeck();
			
		}
		//Calls to method that ends the program if user chooses to do so.
		else {
			endGame();
	}
	}
		//Method that exits game if prompted
	public static void endGame() {
		System.out.println();
		System.out.println("Thanks for coming! Hope you enjoyed pitty pat!");
		 System.exit(0); 
	}
	
	
		//Method that begins game for user
	public static void priorCreateDeck() {
		// Empty array for deck
		String[] deckFill = new String[52];
		System.out.print("Type 'go' to draw your five hand cards: \n" );
		
		//Stores user input if they choose to continue in game
		Scanner input = new Scanner(System.in);
		String start  = input.nextLine();
		
		
			
		//Conditional that begins method calling for deck creation and game playing
		if (start.equals("go")) {
			
			//Method calls in this order: 1.fills deck 2.shuffle deck 3.playing of game
			fillDeck(deckFill);
			shuffleDeck(deckFill);
			gameStart(deckFill);
		
			
		} else {
								
			//Calls to method that ends the program if user chooses to do so.
			endGame();
		}
	}
	
		//Method that fills the deck
	public static String[] fillDeck(String[] deck){
			int indexDeck = 0;
			System.out.println();
			// Array for suits
			String[] suits = {"S", "H", "D", "C"};
			
			// Array for numbers			
			String[] number = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
			
			//Loop that fills the deck array with String values for cards
			for(int i = 0; i < suits.length; i++) {	
			
				//Nested loop to add cards to deck
				for(int j = 0; j < number.length; j++) {
					
					deck[indexDeck] = (suits[i] + number[j]);
					
					System.out.print(deck[indexDeck] + " ");
				
					indexDeck++;
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			return deck;
		}
	
	
	
		//Method that shuffles the values of the deck.
	public static String[] shuffleDeck(String[] deck) {
		// Assumimg 'go' was entered...
		
		//Random number seeded with current time.	
		Random num = new Random(System.currentTimeMillis());
		
		int index;
		
				
		//Loop that takes the length of string[] deck; initialized int index to a random number in deck.
		//Creates and initializes string a to match deck at index (random number).
		//setd deck at the random position to the intial value at index i and saves it in a.
		for (int i = deck.length - 1; i > 0; i--) {
			
			index       = num.nextInt(deck.length);			
			String a    = deck[index];
			deck[index] = deck[i];
			deck[i]     = a;
		}
		return deck;
	}
	
		//Method that gets a random number from the Array.
	public static String getRandom(String[] deck1 ) {
		
		
		Random r = new Random();
		int x = r.nextInt(deck1.length)+ 0;
		
		return deck1[x];
		
	}
		
		//Method that initiates the game.	
	public static String[] gameStart(String[] deck) {						
		System.out.println("Here are your hand cards: \n");
		
		//Prints out the 5 top 5 catrds for the users 'hand'.		
		for(int i = 0; i < 5; i++) {
			
			System.out.print(deck[i] + " ");
		}
		System.out.println("\n");
		
		//Stores the amount of turns the user assumes they will need.
		Scanner input2 = new Scanner(System.in);
		System.out.print(" How many turns do you need? ");
		
		int turns = input2.nextInt()-1;
			
		int handCount = 4;
			
		//Loop that grabs random card from deck and engages user to see if the number matches any in their hand.
		for(int i = 4; i <= deck.length; i++) {
			String newCard = getRandom(deck);
			System.out.println();
			System.out.print("A new card from the deck: ");
			System.out.print(newCard + " (Does it match any hand cards? type y or n) ");
			Scanner input1 = new Scanner(System.in);
			String match = input1.nextLine();
			
			
			//Condition that executes if the card number from the deck matches a hand card.
			if(match.equals("y")) {
				System.out.println("\n" + "Nice! only " + handCount + " more hand cards left.");
					
					//Nested conditional that checks if user won the game.
					if (handCount == 0) {
						System.out.println("\n" + "You win! Thanks for playing!");
						System.exit(0);
					}
					
					//subtracts cards from the users hand
				handCount--;					
			}
			
				//if user enters 'n' then the number of turns that they have decreases.
			else {
				System.out.println("\n" + turns + " more turns left");
				turns--;
			
					//if the turns counter hits zero then the game exits.
				if(turns == -1) {
					endGame();
				}
				
			}
		}
				
		return deck;
	}		

	
		
	}
