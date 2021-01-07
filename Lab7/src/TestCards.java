
public class TestCards {

	public static void main(String[] args) {
		
		// Example 1 (a few cards)
		
		Card c1 = new Card("H", "7");
		Card c2 = new Card("D", "7");
		Card c3 = new Card("H", "A");
		Card c4 = new Card("D", "7");
		Card c5 = new Card("S", "K");
		Card c6 = new Card("C", "10");
		
		ArrayOrderedList<Card> arr = new ArrayOrderedList<Card>();
		
		arr.add(c1);
		arr.add(c2);
		arr.add(c3);
		arr.add(c4);
		arr.add(c5);
		arr.add(c6);

		System.out.println(arr);
		
		// Example 2 (full deck)
		
		ArrayOrderedList<Card> deck = new ArrayOrderedList<Card>();
		
		String[] suits = new String[] {"H", "D", "C", "S"};
		String[] ranks = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		Card card;
		for (int s = 0; s < 4; s++) {
			for (int r = 0; r < 13; r++) {
				card = new Card(suits[s], ranks[r]);
				deck.add(card);
			}
		}
		
		System.out.println(deck);
	}

}