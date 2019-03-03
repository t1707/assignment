import org.junit.*;

public class TestQue04 {

    @Test
    public void shortUrl(){
        Que04 qObject = new Que04();
        String res = qObject.encode("https://support.veltra.com/en/support/article/can-i-call-veltra-for-more-information/?");
        System.out.println(res);
        System.out.println(qObject.decode(res));
    }

}
