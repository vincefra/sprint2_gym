package sprint2_gym;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import sprint2_gym.Person.Customer;

public class Sprint2_gym
{
    public static ArrayList<Customer> Customers = Files.LoadCustomerFile();
    
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
                    Customer customer = Files.ExistPerson(scan.nextLine(), Customers);
                    if (customer != null)
                    {
                        if (customer.checkMembershipStatus(customer.getLastpayment()) == 1)
                            Files.WriteFile(customer);

                        System.out.println(customer.toString());
                    }
                    else
                        System.out.println("Kunde ej hitta kund, var vänlig och försök igen!");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Something went wrong, " + e);
            }
        }
    }
}
