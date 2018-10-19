package sprint2_gym.Person;

import sprint2_gym.Helper;



public class Person 
{
    private long socialnumber;
    private String name;
    private String lastname;
    
    Person(){}
    
    // <editor-fold defaultstate="collapsed" desc=" Set/Get ">
    
    public void setName(String name)
    {
        if (Helper.validName(name))
            this.name = name;
    }
    
    public void setLastname(String name)
    {
        if (Helper.validName(name))
            this.lastname = name;
    }
    
    public void setSocialnumber(long socialnumber)
    {
        if (Helper.validSocialnumber(socialnumber))
            this.socialnumber = socialnumber;
    }
    
    public long getSocialnumber()
    {
        return this.socialnumber;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getLastname()
    {
        return this.lastname;
    }
    
    // </editor-fold>
}
