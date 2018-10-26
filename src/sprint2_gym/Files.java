package sprint2_gym;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import sprint2_gym.Person.Customer;

public final class Files {
    
    private Files(){}
    
    // <editor-fold defaultstate="collapsed" desc=" File ">

    public static ArrayList<Customer> LoadCustomerFile()
    {
        ArrayList<Customer> customers = new ArrayList();
        File file = new File("customers.txt"); 
      
        try
        {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine())
            {
                Customer customer = new Customer();
                
                String line = sc.nextLine();
                String[] linesplit = line.split(",");
                
                if (line.length() > 0)
                {
                    customer.setSocialnumber(Helper.tryParseLong(linesplit[0]));
                    customer.setName(linesplit[1].split(" ")[1].trim());
                    customer.setLastname(linesplit[1].split(" ")[2].trim());

                    if (sc.hasNextLine())
                        customer.setLastpayment((Date)
                                new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine()));

                    customers.add(customer);
                }
            }
        }
        catch (FileNotFoundException | ParseException e)
        {
            System.out.println("Something went wrong, " + e);
        }
        
        return customers;
    }
    
    public static boolean WriteFile(Customer customer)
    {
        try 
        { 
            File file = new File(customer.getSocialnumber() + ".txt");
            boolean exist = file.exists();
                    
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            
            try (BufferedWriter bw = new BufferedWriter(fileWritter)) 
            {
                if (!exist)
                {
                    bw.append(String.valueOf(customer.getSocialnumber()));
                    bw.append(", " + customer.getName() + " " + customer.getLastname());
                    bw.newLine();      
                }
                
                bw.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                bw.newLine();
                bw.close();
                return true;
            }
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static Customer ExistPerson(String data, ArrayList<Customer> customers)
    {   
        if (customers.size() > 0)
        {
            for(Customer customer : customers)
                if (customer.getName().equalsIgnoreCase(data))
                        return customer;  
                else if (Helper.tryParseLong(data) > 0)
                {
                    if (customer.getSocialnumber() == Helper.tryParseLong(data))
                        return customer;
                }
        }
        
        return null;
    }
    // </editor-fold>
}
