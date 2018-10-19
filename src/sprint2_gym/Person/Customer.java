package sprint2_gym.Person;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Customer extends Person
{    
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
                "Medlemskap: " + 
                getMembershipStatus(checkMembershipStatus(getLastpayment())) + "\n";
    }
    
    public int checkMembershipStatus(Date lastpayment)
    {
        long difference = new Date().getTime() - lastpayment.getTime();

        return (TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) / 365 >= 1) ? 0 : 1;
    }
    
    public String getMembershipStatus(int status)
    {   
        return (status > 0) ? "Giltigt" : "Utgått";
    }
}
