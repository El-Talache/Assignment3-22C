/**
 * Card.java
 * 
 * 
 * @author Gerardo R. Padilla Jr.
 * @author Nhan Ha CIS 22C, Lab 3
 */

public class Card implements Comparable<Card> {
	private String rank;
	private String suit;

	/**
	 * Constructor for the Card class the mutators will validate the innut
	 * 
	 * @param rank the rank of card from 2 to A
	 * 
	 * @param suit the suit of card C, D, H, or S
	 * 
	 */
	public Card(String rank, String suit) {
		setSuit(suit);
		setRank(rank);
	}

	/**
	 * Returns the card's rank
	 * 
	 * @return rank a rank from 2 (low) to A (high)
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Returns the card's suit
	 * 
	 * @return C, D, H, or S, which has been verified to be a correct suit since it
	 *         was assigned
	 */
	public String getSuit() {

		return suit;
	}

	/**
	 * Updates the card's rank
	 * 
	 * @param rank a new rank
	 * @precondition rank must be between 2 and 10, or equal to J, Q, K, or A
	 * @throws IllegalArgumentException when precondition is violated
	 */
	public void setRank(String rank) throws IllegalArgumentException {
		if (rank.equals("A") || rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
			this.rank = rank;
		} else if (Integer.parseInt(rank) >= 2 && Integer.parseInt(rank) <= 10) {
			this.rank = rank;
		} else
			throw new IllegalArgumentException("setRank: rank input is not valid");
	}

	/**
	 * Updates the card's suit
	 * 
	 * @param suit the new suit
	 * @precondition suit must be equal to S, H, D, or C
	 * @throws IllegalArgumentException when precondition is violated
	 */
	public void setSuit(String suit) {
		if (suit.equals("S") || suit.equals("C") || suit.equals("H") || suit.equals("D")) {
			this.suit = suit;
		} else
			throw new IllegalArgumentException("setSuit: suit input is not valid");
	}

	/**
	 * Concatenates rank and suit
	 */
	@Override
	public String toString() {
		return (rank + suit);
	}

	/**
	 * Overrides the equals method for Card Compares rank and suit and follows the
	 * equals formula given in Lesson 4 and also in Joshua Block's text
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (!(o instanceof Card)) {
			return false;
		}
		Card C = (Card) o;
		if (this.getSuit() == C.getSuit() && this.getRank() == C.getRank())
			return true;
		else
			return false;
	}

	/**
	 * Orders two cards first by suit (alphabetically) Next by rank. "A" is
	 * considered the high card Order goes 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	 * 
	 * @return a negative number if this comes before c and a positive number if c
	 *         comes before this and 0 if this and c are equal according to the
	 *         above equals method
	 */
	@Override
	public int compareTo(Card c) {
		String[] suitCompare = { "C", "D", "H", "S" };
		String[] rankCompare = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

		String card1 = getSuit();
		String card2 = c.getSuit();
		int card1Val = -1;
		int card2Val = -1;

		for (int i = 0; i < 4; i++) // this loop will rank card values alphabetically by their suit
		{
			if (suitCompare[i].equals(card1))
				card1Val = i;

			if (suitCompare[i].equals(card2))
				card2Val = i;

		}
		// System.out.println( " Suit: " +card1Val + " " + card2Val);
		if (card1Val != card2Val) {
			return card1Val - card2Val; // will return negative if card2Val is higher,
		}

		card1 = getRank(); // now to compare Ranks
		card2 = c.getRank();

		card1Val = -1;// resetting input
		card2Val = -1;

		for (int i = 0; i < 13; i++) // this loop will rank card values by their rank values
		{
			if (rankCompare[i].equals(card1))
				card1Val = i;

			if (rankCompare[i].equals(card2))
				card2Val = i;

		}
		// System.out.println("Rank: " + card1Val + " " + card2Val);
		if (card1Val != card2Val) {
			return card1Val - card2Val; // will return negative if card2val rank is higher
		}

		return 0; // this will only happen when both cards matched suit and Rank

	}
}
