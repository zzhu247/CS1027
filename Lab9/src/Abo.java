
public class Abo {
	
	public static int rabo(int n) {
		if (n<=0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n>1 && n%2==0) {
			return 1+rabo(n/2);
		} else {
			return 2+rabo((n+1)/2);
		}
	}
	
	public static int iabo(int n) {
		int result=0;
		if (n<=0) {
			result+=0;
		}
		else if (n == 1) {
			result++;
		} else {
			while (n > 1) {
				if (n%2 == 0) {
					result ++;
					n = n/2;
				} else {
					result += 2;
					n = (n+1)/2;
				}
			}
			result ++;
		}
		return result;
	}
	
	public static void main(String args[]) {
		System.out.print("Recursive method output is: ");
		for (int i=0; i<19; i++) {
			int output = rabo(i);
			System.out.print(output+", ");
		}
		System.out.print(rabo(19));
		
		System.out.println();
		System.out.print("Iterative method output is: ");
		for (int i=0; i<19; i++) {
			int output = iabo(i);
			System.out.print(output+", ");
		}
		System.out.print(iabo(19));
	}
}
