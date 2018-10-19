package sprint2_gym.Person;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Customer extends Person{
    
    private Date lastpayment;

    
    public void setLastpayment(Date lastpayment)
    {
        this.lastpayment = lastpayment;
    }
    
    public Date getLastpayment()
    {
        return this.lastpayment;
    }
    
    @Override
    public String toString()
    {
        return "Namn: " + getName() + " " + getLastname() + "\n" +
                "Personummer: " + getSocialnumber() + "\n" + 
                "Medlemskap: " + getMembershipStatus(getLastpayment()) + "\n";
    }
    
    public String getMembershipStatus(Date lastpayment)
    {
        long difference = new Date().getTime() - lastpayment.getTime();

        if ((TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) / 365) >= 1)
            return "Utgått";
        else
            return "Giltigt";
    } 
}
