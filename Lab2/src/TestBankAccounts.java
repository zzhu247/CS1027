import java.io.*;

/**
 * TestBankAccounts.java:
 *  This class will test aspects of inheritance for the BankAccount class
 *  and its subclasses.
 * @author CS027b 2007
 */

public class TestBankAccounts {
    
    public static void main(String[] args) {
      
        BankAccount bacc0 = new BankAccount(0);
        System.out.println(bacc0.toString());
        
        BankAccount bacc1 = new BankAccount(5000);
        System.out.println(bacc1.toString());
        
        CheckingAccount chacc1 = new CheckingAccount(500.0);
        System.out.println(chacc1.toString());
                          
        SavingsAccount sacc1 = new SavingsAccount(1000.0, 1.0);
        System.out.println(sacc1.toString()); 
        
        //-------------------------------------------------------
        // add your code here
        
        bacc0 = chacc1;
        
        //chacc1 = bacc1;
        
        BankAccount bacc2 = new CheckingAccount(200.0);
        chacc1 =  (CheckingAccount) bacc2;
        
        //((CheckingAccount)bacc1).deductFees();
        
        chacc1.deductFees();
        
        //((CheckingAccount)sacc1).deductFees();
        
        chacc1.deposit(100.0);
        

        

        
    }
    
}