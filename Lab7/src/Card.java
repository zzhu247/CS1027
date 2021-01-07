
public class Card implements Comparable<Card>{
	
	private String suit; // S (spade), H (heart), D (diamond), or C (club)
	private String rank; // A (ace), 2, 3, ..., 10, J (jack), Q (queen), or K (king)

	public Card (String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit () {
		return suit;
	}
	
	public String getRank () {
		return rank;
	}
	
	public void setSuit (String suit) {
		this.suit = suit;
	}
	
	public void setRank (String rank) {
		this.rank = rank;
	}
	
	public String toString () {
		return rank + " of " + suit;
	}

	public boolean equals (Card other) {
		if (other.rank == this.rank && other.suit == this.suit) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSuitValue() {
		if (this.suit == "D") {
			return 1;
		}
		else if (this.suit == "C") {
			return 2;
		}
		else if (this.suit == "H") {
			return 3;
		}
		else if (this.suit == "S") {
			return 4;
		} else {
			return 0;
		}
	}
	
	public int getRankValue() {
		switch (this.rank) {
			case "2":
				return 2;
			case "3":
				return 3;
			case "4":
				return 4;
			case "5":
				return 5;
			case "6":
				return 6;
			case "7":
				return 7;
			case "8":
				return 8;
			case "9":
				return 9;
			case "10":
				return 10;
			case "J":
				return 11;
			case "Q":
				return 11;
			case "K":
				return 11;
			case "A":
				return 12;
			default:
				return 0;
		}
	}
	
	
	@Override
	public int compareTo(Card o) {
		if (o.equals(this))
			return 0;
		else {
			int thisrank = this.getRankValue();
			int orank = o.getRankValue();
			if (thisrank > orank) {
				return 1;
			}
			else if (thisrank < orank) {
				return -1;
			} else {
				int thissuit = this.getSuitValue();
				int osuit = o.getSuitValue();
				if (thissuit > osuit) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}

}