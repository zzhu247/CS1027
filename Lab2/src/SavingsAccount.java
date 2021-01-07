/**
 * SavingsAccount.java:
 *  This class is a simple model of a saving account,
 *  to be used for understanding inheritance.
 * @author Zihan Zhu
 */

class SavingsAccount extends BankAccount{
    /** Attribute:
     * Record the interest rate */
	private double interestRate;
	
    /** Creates a new instance of saving account 
     * @param initialAmount initial amount deposited into new account
     * @param rate interest rate of the saving account
     */
	public SavingsAccount(double initialAmount, double rate) {
		super(initialAmount);
		this.interestRate = rate;	
	}
	
    /** Accessor method for interest rate 
     * @return current interest rate
     */
	public double getInterestRate() {
		return interestRate;
	}
	
    /** calculate the interest gained in the saving account
     * 	add the interest to the account balance
     */
	public void calculateInterest() {
		double balance = getBalance();
		double interest = (getInterestRate()) * balance;
		deposit(interest);
	}
	
    /** Represent saving account as a String for display purposes
     * @return String representation of the saving account
     */
	public String toString() {
		return ("SavingsAccount: balance $" + getBalance() + ", interest rate " + getInterestRate()); 
	}
	
	public static void main(String[] args) {
		SavingsAccount myAccount = new SavingsAccount(100.0,0.15);
		myAccount.calculateInterest();
		System.out.println(myAccount.toString());
	}
}