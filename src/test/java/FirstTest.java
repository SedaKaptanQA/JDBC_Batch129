import org.junit.Assert;
import org.junit.Test;


public class FirstTest {

    @Test
    public void firstTest01(){
        Assert.assertTrue(6<9);

    }

    @Test
    public void firstTest02(){

        Assert.assertTrue("test fail",17<9);
        //Test kaldığında mesaj alırız

    }

    @Test
    public void firstTest03(){
        Assert.assertEquals("sayılar eşit değil",3,3);

    }




}
