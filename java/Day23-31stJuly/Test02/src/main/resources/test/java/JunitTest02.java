import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

@Ignore
public class JunitTest02 {

    String msg2 = "running JunitTest02";

    @Test
    public void msgTest() {
        System.out.println("we are inside the msgTest2()");
        assertEquals(msg2, "running JunitTest02");
    }
}