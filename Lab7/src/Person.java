
public class Person implements Comparable<Person> {
	
	/* Attribute declarations */
	private String name;
	private String city;
	private String email;
			
	/**
	 * Constructor initializes the person's name and email address
	 */
	public Person(String name, String email, String city) {
		this.name = name;
		this.email = email;
		this.city = city;
	}

	/**
	 * toString to display the person's info in a clean format
	 * return String of the person's info
	 */
	public String toString() {
		String s = String.format("%10s\t\t%30s\t\t%10s", name, email, city);
		return s;
	}
	
	private int sortByName(Person other) {
		return this.name.compareTo(other.name);
	}

	private int sortByEmail(Person other) {
		return this.email.compareTo(other.email);
	}
	
	private int sortByCity(Person other) {
		return this.city.compareTo(other.city);
	}
	
	/**
	 * compareTo determines the order of the contacts
	 */
	public int compareTo(Person other) {
		if (ContactList.sortBy == 'n') {
			return this.sortByName(other);
		}
		else if (ContactList.sortBy == 'e') {
			return this.sortByEmail(other);
		} else {
			return this.sortByCity(other);
		}
	}

}