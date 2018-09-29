import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays; 

public class pittyPat {
	
	public static void main (String[] args) {
		
		System.out.println("Welcome to Pitty Pat!\n");	
		System.out.println("Are you ready to begin?(y/n)");
		
		Scanner input     = new Scanner(System.in);
		String begin      = input.nextLine();
				
		
		if (begin.equals("y")) {
			createDeck();
			
		}
		else {
			endGame();
	}
	}
		
	public static void endGame() {
		System.out.println();
		System.out.println("Thanks for coming! Hope you enjoyed pitty pat!");
		
		 System.exit(0); 
	}
	
	public static void createDeck() {
		String[] deckFill = new String[52];
		System.out.print("Type 'go' to draw your five hand cards: \n" );
		
		Scanner input = new Scanner(System.in);
		String start  = input.nextLine();
			
		String endSession     = " ";
		String[] startSession = new String[4];
		
			
		
		if (start.equals("go")) {
			
			
			fillDeck(deckFill);
			shuffleDeck(deckFill);
			gameStart(deckFill);
		
			
		} else {
								
			// TODO - STOP AND RETURN
			endGame();
		}
	}
	
	public static String[] fillDeck(String[] deck){
			int indexDeck = 0;
					
			// Empty array for deck
			
			
			// Array for suits
			System.out.println();
			String[] suits = {"S", "H", "D", "C"};	
			String[] number = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
			
			for(int i = 0; i < suits.length; i++) {	
			
				//Nested loop to add cards to deck
				for(int j = 0; j < number.length; j++) {
					
					deck[indexDeck] = (suits[i] + number[j]);
					
					System.out.print(deck[indexDeck] + " ");
				
					indexDeck++;
				}
				System.out.println();
			}
			return deck;
		}
	
	
	
	public static String[] shuffleDeck(String[] deck) {
		// Assumimg 'go' was emntered...
		
		// TODO - Seed the Random with current time			SOLVED
		Random num = new Random(System.currentTimeMillis());
		
		int index;
		
		// TODO - WHAT DOES THIS LOOP DO? Shuffling?		SOLVED
		//Loop that takes the length of string[] deck; initialized int index to a random number in deck
		//Creates and initializes string a to match deck at index (random number)
		//setd deck at the random position to the intial value at index i and saves it in a
		for (int i = deck.length - 1; i > 0; i--) {
			
			index       = num.nextInt(deck.length);			
			String a    = deck[index];
			deck[index] = deck[i];
			deck[i]     = a;
		}
		return deck;
	}
	
	//Get a Random number from the Array
	
	public static String getRandom(String[] deck1 ) {
		
		
		Random r = new Random();
		int x = r.nextInt(deck1.length)+ 0;
		
		return deck1[x];
		
	}
		
	public static String[] gameStart(String[] deck) {						
		System.out.println("\n Here are your hand cards: ");
				
		for(int i = 0; i < 5; i++) {
			
			System.out.print(deck[i] + " \n\n");
		}
		
		Scanner input2 = new Scanner(System.in);
		System.out.print(" How many turns do you need? ");
		
		int turns = input2.nextInt()-1;
			
			int handCount = 4;
			
		// TODO - WHAT'S HAPPENING HERE?
		for(int i = 4; i <= deck.length; i++) {
			String newCard = getRandom(deck);
			
			System.out.println();
			System.out.print("A new card from the deck: ");
			System.out.print(newCard + " (Does it match any hand cards? type y or n) ");
			Scanner input1 = new Scanner(System.in);
			String match = input1.nextLine();
			
			
			
			if(match.equals("y")) {
				
				
				
				System.out.println("\n" + "Nice! only " + handCount + " more hand cards left.");
				
					if (handCount == 0) {
						System.out.println("You win! Thanks for playing!");
						System.exit(0);
					}
				handCount--;					
			}
			
			else {
				System.out.println("\n" + turns + " more turns left");
				turns--;
			
				if(turns == -1) {
					endGame();
				}
				
			}
		}
				
		return deck;
	}		
	
	/*public static int rules(int ruleCount, String[] deck) {
		
		for(int i = ; i < ; i++) {
			if(deck[i].Substring(1).equals() = deck {
			}
			else {
				System.out.println("Nice try!");
			}
		}
		return ruleCount;
	}*/
	
		
	}


		
		