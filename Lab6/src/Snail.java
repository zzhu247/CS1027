
public class Snail {
	
	public static char icon = '@';
	private int position;
	private QueueADT<Integer> movePattern;
	
	public Snail (int[] pattern) {
		position = 0;
		movePattern = new LinkedQueue<Integer> ();
		for (int i=0; i< pattern.length; i++) {
			movePattern.enqueue(pattern[i]);
		}
	}
	
	public void move () {
		int var = movePattern.dequeue();
		movePattern.enqueue(var);
		position += var;
		if (position > 50) {
			position = 50;
		}
	}
	
	public int getPosition () {
		return position;
	}
	
	public void display () {
		int dashesBefore = position;
		int dashesAfter = 50 - position;
		for (int i = 0; i < dashesBefore; i++) {
			System.out.print("-");
		}
		System.out.print("@");
		for (int i = 0; i < dashesAfter; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}

}