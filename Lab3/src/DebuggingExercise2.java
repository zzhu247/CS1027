public class DebuggingExercise2 {

	private static int load = 1;
	public static void main(String[] args) {
		int i;
		int total;
		
		i = process(1);
		total = 0;

		
		if (load == 0) {
			System.out.println("The value of total is infinity");
		}else {
			total = (i * 100) / load;
			System.out.println("The value of total is "+total);
		}
			
	}

	private static int process(int step) {
		int i = 1;
		int result = step;
		for (; i <= 3; ++i) {
			result = result * i * step + step;
			if (result > 100) {
				load = 0;
				step = step - result;
			}
			else {
				load = load * result;
				++step;
			}
		}
		
		// What are the values of i, step, result, and load?
		// i = 4
		// step = -468
		// result = 472
		// load = 0
		return result;	
	}
}