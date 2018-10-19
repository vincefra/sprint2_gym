package sprint2_gym;

public final class Helper 
{
    //https://stackoverflow.com/questions/7486012/static-classes-in-java
    
    private static int minName = 1;
    private static int maxName = 20;
    
    private Helper(){}
    
    // <editor-fold defaultstate="collapsed" desc=" Help methods ">

    public static long tryParseLong(String value) 
    {  
        try
        {
            return Long.parseLong(value);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    
    public static boolean validSocialnumber(long socialnumber)
    {
        return String.valueOf(socialnumber).length() == 10;
    }
    
    public static boolean validName(String value)
    {
        return checkLength(minName, maxName, value) && onlyLetters(value);
    }
    
    public static boolean onlyLetters(String value) 
    {   
        /*
            ^: Field starts with.
            $: Field ends with. 
        */
        return value.matches("^[a-öA-Ö]+$");
    }
    
    public static boolean checkLength(int min, int max, String value)
    {
        return value.length() >= min && value.length() <= max;
    }
    
    // </editor-fold>

}