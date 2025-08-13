import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

public class JunitTest03 {

    String msg = "running test01";

    MessageUtil msgUtilobj = new MessageUtil(msg);

    @Test
    public void msgTest() {
        System.out.println("we are inside the msgTest3() using MessageUtil");
        assertEquals(msg, msgUtilobj.printMessage());
    }
}
