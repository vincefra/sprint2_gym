package sprint2_gym;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import sprint2_gym.Person.Customer;

public class Sprint2_gym
{
    static Files files = new Files();
    static ArrayList<Customer> Customers = files.LoadCustomerFile();
    
    public static void main(String[] args) 
    {
        findCustomer();
    }
    
    public static void findCustomer()
    {
        while (true)
        {           
            Scanner scan = new Scanner(System.in);
            
            try
            {
                System.out.println("Mata in namn eller personnummer för att söka efter kund!");

                if (scan.hasNext())
                {
                    Customer c = files.ExistPerson(scan.nextLine(), Customers);
                    if (c != null)
                    {
                        if (c.getMembershipStatus(c.getLastpayment()).equalsIgnoreCase("Giltigt"))
                            files.WriteFile(c);
                        
                        System.out.println(c.toString());
                        continue;
                    }
                }

                System.out.println("Kunde ej hitta kund, var vänlig och försök igen!");
            }
            catch (InputMismatchException e)
            {
                System.out.println("Something went wrong, " + e);
            }
        }
    }
}
