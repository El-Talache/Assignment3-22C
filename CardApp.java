
/**
 * CardApp.java
 * @author Gerardo R. Padilla Jr. 
 * @author Nhan Ha
 * CIS 22C, Lab 3
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CardApp {

	private List<Card> L = new List<>();

	public static void main(String[] args) {

		CardApp cardApp = new CardApp();

		System.out.println("Welcome to Gerardo and Nhan's Sorter and shuffler! ");

		cardApp.readFileToList();

		cardApp.shuffle();
		// Writing the results of the shuffled list into a text file.
		cardApp.printList(new File("shuffled.txt"), "Shuffled List:");
		cardApp.sort();
		// Writing results of sorted cards to an external text file.
		cardApp.printList(new File("sorted.txt"), "Sorted List: ");

		System.out.println("Please open shuffled.txt and sorted.txt. ");
		System.out.println("Goodbye! ");

	}

	private void printList(File file, String filename) {
		try {
			PrintWriter textWriter = new PrintWriter(file);
			textWriter.println(filename);

			textWriter.println(L); // this method was modified

			textWriter.flush();
			textWriter.close();

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

		}

	}

	private void readFileToList() {
		do {

			try {
				// Prompting for file name
				System.out.print("Please enter a file name: ");
				BufferedReader objReader;
				Scanner scan = new Scanner(System.in);
				String fileName = scan.nextLine();
				File file = new File(fileName);
				// Looping through the file while it isn't empty
				String currentLine;
				String Suit = "";
				String Rank = "";

				objReader = new BufferedReader(new FileReader(file));
				while ((currentLine = objReader.readLine()) != null) {

					Suit = Character.toString(currentLine.charAt(currentLine.length() - 1));
					// Setting the rank of the card
					if (currentLine.length() == 2) {
						Rank = String.valueOf(currentLine.charAt(0));
					} else {
						Rank = String.valueOf(currentLine.charAt(0)) + String.valueOf(currentLine.charAt(1));
					}
					L.addLast(new Card(Rank, Suit));
				}
				scan.close();
				objReader.close();
			} catch (IOException e) { // Catching any exceptions
				System.out.println("Invalid file name!" + "\n");
				continue;
			}

			break;
		} while (true);

	}

	/**
	 * Shuffles cards following this algorithm: First swaps first and last card
	 * Next, swaps every even card with the card 3 nodes away from that card. Stops
	 * when it reaches the 3rd to last card Then, swaps ALL cards with the card that
	 * is 3 cards away from it, beginning at second card, and stopping at the 3rd to
	 * last card
	 */
	public void shuffle() {
		Card temp = new Card(L.getFirst().getRank(), L.getFirst().getSuit());

		L.addFirst(L.getLast()); // add last to beginning
		L.placeIterator();
		L.advanceIterator(); // pointing to second one.
		L.removeIterator(); // remove second node (formerly the first node)
		L.removeLast();
		L.addLast(temp); // this line concludes the first and last swap

		swapCard(2);

		swapCard(1);
	}

	/*
	 * Helper method to this class to help what every "s" card with the card 3
	 * spaces in front of it
	 * 
	 * @postcondition All cards are now shuffled, depending on the s value, starting
	 * with the first card
	 * 
	 */
	private void swapCard(int s) {

		Card temp = null, temp2 = null;
		L.placeIterator();
		L.advanceIterator();
		temp = L.getIterator();

		for (int i = 0; i < L.getLength() - 4; i += s) {

			L.placeIterator();
			for (int j = 0; j <= i + 3; j++) {
				L.advanceIterator();
			}

			temp2 = L.getIterator(); // adds first card
			L.addIterator(temp);
			L.removeIterator(); //

			L.placeIterator();
			for (int j = 0; j <= i; j++) {
				L.advanceIterator();
			}

			L.addIterator(temp2);
			L.removeIterator();

			L.placeIterator();

			while (L.getIterator() != temp2) {
				L.advanceIterator();
			}
			for (int k = 0; k < s; k++) {
				L.advanceIterator();
			}
			temp = L.getIterator();

		}

	}

	/**
	 * Implements the bubble sort algorithm to sort L into sorted order, first by
	 * suit (alphabetical order) then by rank from 2 to A
	 */
	public void sort() {

		Card currentNode = null, next = null;
		if (L.getLength() > 1) {
			L.placeIterator();
			for (int i = 0; i <= L.getLength() - 1; i++) {
				for (int j = 0; j <= L.getLength() - i - 1; j++) {

					// advancing current node at j.
					L.placeIterator();
					for (int k = 0; k < j - 1; k++) {
						L.advanceIterator();
					}
					currentNode = L.getIterator();

					// advancing to the next node at j+1
					L.placeIterator();
					for (int k = 0; k < j; k++) {
						L.advanceIterator();
					}
					next = L.getIterator();

					// Swapping the node by adding a new one and removing the previous one
					if (currentNode.compareTo(next) > 0) {

						L.addIterator(currentNode);
						L.reverseIterator();
						L.removeIterator();
						L.placeIterator();
					}
				}
			}
		}
	}
}
