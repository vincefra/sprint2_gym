/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.Test;
import sprint2_gym.Files;
import sprint2_gym.Person.Customer;

/**
 *
 * @author work
 */
public class FilesTest {
    
    public FilesTest() {
    }

    @Test
    public void WriteFileTest() throws ParseException 
    {
        Customer test = new Customer();
        test.setName("John");
        test.setLastname("Doe");
        test.setSocialnumber(1234567890);
        test.setLastpayment((Date)new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-20"));

        TestCase.assertTrue(Files.WriteFile(test));
    }
}
