import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TestQue01 {

    @Test
    public void checkPalindrome(){
        boolean res1 = Que01.checkPalin("Hello World");
        boolean res2 = Que01.checkPalin("A Toyota’s a Toyota");
        boolean res3 = Que01.checkPalin("123454321");
        boolean res4 = Que01.checkPalin("Hello121olleh");
        boolean res5 = Que01.checkPalin("   Hello ** % 123 , - 321 ollEh");

        assertEquals(res1, false);
        assertEquals(res2, true);
        assertEquals(res3, true);
        assertEquals(res4, true);
        assertEquals(res5, true);

    }

}
