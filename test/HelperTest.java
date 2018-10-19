import junit.framework.TestCase;
import org.junit.Test;
import sprint2_gym.Helper;

public class HelperTest 
{
    public HelperTest() {
    }

    @Test
    public void onlyLettersTest() 
    {
        TestCase.assertFalse(Helper.onlyLetters("johan "));
    }
    
    @Test
    public void checkLengthTest()
    {
        TestCase.assertFalse(Helper.checkLength(1,5, "teeeeest"));
    }
    
    @Test
    public void validSocialNumberTest()
    {
        TestCase.assertTrue(Helper.validSocialnumber(1234567890));
    }
}
