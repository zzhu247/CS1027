
public class Receipt {
	public Receipt (Product[] cart) {
		int length = cart.length;
		System.out.println("      Item       Code      Cost   After Tax");
		System.out.println("----------------------------------------------");
		double total = 0;
		for (int i=0; i< length; i++) {
			System.out.print(String.format("%10s", cart[i].getName()));
			System.out.print("   ");
			System.out.print(String.format("%10s", cart[i].getCode()));
			System.out.print("   ");
			System.out.print(String.format("%5.2f", cart[i].getCost()));
			double aftertax = cart[i].getCost()*(1+Product.getTax());
			total += aftertax;
			System.out.print("   ");
			System.out.print(String.format("%5.2f", aftertax));
			System.out.println();
		}
		System.out.println("----------------------------------------------");
		System.out.print("                                  ");
		System.out.print(String.format("%5.2f", total));
	}
	
	public static void main (String[] args) {
		Product item1 = new Product("Bread", "BL 4007", 3.99);
		Product item2 = new Product("Eggs", "JE 1972", 2.99);
		Product item3 = new Product("Lasagna", "PM 1291", 11.99);
		
		Product[] cart = new Product[3];
		cart[0] = item1;
		cart[1] = item2;
		cart[2] = item3;
		
		Receipt thecart = new Receipt(cart);
	}
}
