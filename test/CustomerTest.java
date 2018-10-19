import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.Test;
import sprint2_gym.Person.Customer;

public class CustomerTest 
{    
    Customer customer = new Customer();
    
    public CustomerTest() {
    }
    
    @Test
    public void getMembershipStatusTest() throws ParseException 
    { 
        customer.setLastpayment(
                (Date)new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-20"));
        
        TestCase.assertEquals("Giltigt", customer.getMembershipStatus(customer.getLastpayment()));
    }
}
